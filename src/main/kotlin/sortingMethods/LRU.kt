package virtual.memory.sortingMethods

//Принцип работы этого алгоритма реализуется следующим образом. В случае, если страница уже загружена
// в оперативную память, то элемент к которому дольше всего не было обращений
//встаёт в начало очереди, двигая все остальные к концу. В ином случае, происходит замещение как в алгоритме FIFO

fun lru(memorylimit: Int, appeals: MutableList<Number>): MutableList<MutableList<Number>> {
    val memory = fillMemory(memorylimit, appeals)
    val requests = getRequestsStack(memorylimit, appeals)
    val outFrames = mutableListOf<Number>()

    for (req in 0 until requests.size) {
        if (memory.contains(requests[req])) {
            memory.add(memory[memory.indexOf(requests[req])])
            memory.removeAt(memory.indexOf(requests[req]))
        } else {
            outFrames.add(memory[0])
            memory.removeAt(0)
            memory.add(requests[req])
        }
    }
    return mutableListOf(memory, outFrames)
}