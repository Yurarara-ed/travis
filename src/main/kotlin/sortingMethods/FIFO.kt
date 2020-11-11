package virtual.memory.sortingMethods

fun fifo(memorylimit: Int,appeals: MutableList<Number>): MutableList<MutableList<Number>> {
    val memory = fillMemory(memorylimit,appeals) //Получаю первичное заполнение оперативной памяти
    val requests = getRequestsStack(memorylimit,appeals) //Получаю список запросов
    val outFrames = mutableListOf<Number>() //Инициализирую пустой массив для данных второго типа

    //Прохожу циклом по списку запросов и сравниваю каждый с ячейками в памяти.
    //Если обращение не подготовлено. то запрос встаёт в начало очереди, замещая крайний левый элемент(конец очереди)

    for(req in 0 until requests.size){
        if(memory.contains(requests[req])){
            continue
        }else{
            outFrames.add(memory[0]) //Добавляю элемент в ответы второго типа
            memory.removeAt(0)
            memory.add(requests[req])
        }
    }
    return mutableListOf(memory,outFrames)
}

