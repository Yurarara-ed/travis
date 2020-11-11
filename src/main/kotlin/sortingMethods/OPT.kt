package virtual.memory.sortingMethods

data class Frame(val indexOfFrame: Int, val refs: Int)

fun opt(memorylimit: Int, appeals: MutableList<Number>): MutableList<MutableList<Number>> {
    val memory = fillMemory(memorylimit, appeals)
    val requests = getRequestsStack(memorylimit, appeals)
    val outFrames = mutableListOf<Number>()

    //Реализация алгоритма следующая. Прохожу по массиву запросов. Проверяю была ли выделена страница запросу
    //если нет, то порядок действий следующий. Вызываю функцию predictFuture(), если она возращает НЕ пустой массив
    //то я выбираю её нулевой элемент, и его свойство indexOfFrame, как запрос к которому будт меньше всего обращений.
    //Далее порядок действий простой. Удаляю из массива страницу найденного мной запроса, и добавляю следующий.
    //В случае если в очереди запросов нет подготовленных обращений. То замещается конец памяти и принимаемый запрос встаёт в начало.


    for (req in 0 until requests.size) {
        if (!memory.contains(requests[req])) {
            if (predictFuture(memory, requests, req).isNotEmpty()) {
                val predict = predictFuture(memory, requests, req)[0].indexOfFrame
                outFrames.add(memory[memory.indexOf(predict)])
                memory.removeAt(memory.indexOf(predict))
                memory.add(requests[req])
            } else {
                outFrames.add(memory[0]) //left member of memory go to out frame
                memory.removeAt(0) // delete left member of memory
                memory.add(requests[req]) // add a request in a memory stack to the right
            }
        }
    }
    return mutableListOf(memory, outFrames)
}

//Функция predictFuture. Каждый элемент очереди процессов я сравниваю со следующим. Если они одинаковый то я прибавляю
//к счётчику запросов один. Тот элемент количество запросов к котому будет наименьшее, будет считаться самым редкоиспользуемым
//в очереди. Если таких элементов несколько, то берётся самый первый из них.

fun predictFuture(memory: MutableList<Number>, requests: MutableList<Number>, index: Int): List<Frame> {
    val futurePredict = mutableListOf<Frame>()
    var counter = 0
    for (i in index until requests.size) {
        if (memory.contains(requests[i])) {
            for (j in index until requests.size) {
                if (requests[i] == requests[j]) {
                    counter++
                }
            }
            futurePredict.add(Frame(requests[i].toInt(), counter))
            counter = 0
        }
    }
    return futurePredict.distinct().sortedWith(Comparator { c1: Frame, c2: Frame -> c1.refs - c2.refs })
}