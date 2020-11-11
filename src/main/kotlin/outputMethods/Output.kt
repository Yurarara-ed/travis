package virtual.memory.outputMethods

import virtual.memory.sortingMethods.diffrence
import java.io.File

//Записывает результаты работы всей программы в файл output.txt

fun output(
    fifo: MutableList<MutableList<Number>>,
    lru: MutableList<MutableList<Number>>,
    opt: MutableList<MutableList<Number>>
) {
    var lineToWrite = "Результат работы FIFO:\nПамять:\n"
    fifo[0].forEach {
        lineToWrite += "$it \t"
    }
    lineToWrite += "\nДанные второго типа:\n"
    fifo[1].forEach {
        lineToWrite += "$it \t"
    }
    lineToWrite += "\n\n\nРезультат работы LRU:\nПамять:\n"
    lru[0].forEach {
        lineToWrite += "$it \t"
    }
    lineToWrite += "\nДанные второго типа:\n"
    lru[1].forEach {
        lineToWrite += "$it \t"
    }

    lineToWrite += "\n\n\nРезультат работы OPT:\nПамять:\n"
    opt[0].forEach {
        lineToWrite += "$it \t"
    }
    lineToWrite += "\nДанные второго типа:\n"
    opt[1].forEach {
        lineToWrite += "$it \t"
    }

    lineToWrite += "\n\n\nРазница между данными второго типа:\n${diffrence(fifo, lru, opt)}"

    println(lineToWrite)

    File("output.txt").writeText(lineToWrite)
}