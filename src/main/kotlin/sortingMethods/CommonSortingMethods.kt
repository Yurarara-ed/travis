package virtual.memory.sortingMethods


//Функция первичного заполнения памяти. Принимает два параметра - Ограничение памяти, и Все запросы.
//Заполняет массив fillMemory данными из массива appeal по достижению предела.

fun fillMemory(memorylimit: Int, appeals: MutableList<Number>): MutableList<Number> {
    val fillMemory = mutableListOf<Number>()
    for (i in 0 until memorylimit) {
        fillMemory.add(appeals[i])
    }
    return fillMemory
}

//Функция получения очереди запросов. Аналогична функции получения первичного заполнения памяти, с той разницей
//что в теле цикла, в котором происходит заполнение, отсчёт идёт с 5.

fun getRequestsStack(memorylimit: Int, appeals: MutableList<Number>): MutableList<Number> {
    val requests = mutableListOf<Number>()
    for (i in memorylimit until appeals.size) {
        requests.add(appeals[i])
    }
    return requests
}