package virtual.memory.sortingMethods

//Сортировка данных второго типа. Вывод результатов в порядке возрастания в виде строки.

fun diffrence(
    fifo: MutableList<MutableList<Number>>,
    lru: MutableList<MutableList<Number>>,
    opt: MutableList<MutableList<Number>>
): String {
    val fifoOut = fifo[1].size
    val lruOut = lru[1].size
    val optOut = opt[1].size
    val diffrence = mutableListOf("FIFO - $fifoOut", "LRU - $lruOut", "OPT - $optOut")
    diffrence.sort()
    var diffrenceMessage = ""
    diffrence.forEach {
        diffrenceMessage += "$it\n"
    }
    return diffrenceMessage
}

