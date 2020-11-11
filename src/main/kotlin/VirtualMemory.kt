@file:JvmName("VirtualMemory")

package virtual.memory

import virtual.memory.outputMethods.output
import virtual.memory.readingMethods.checkFilesProperties
import virtual.memory.readingMethods.getAppeals
import virtual.memory.readingMethods.getMemoryLimit
import virtual.memory.sortingMethods.fifo
import virtual.memory.sortingMethods.lru
import virtual.memory.sortingMethods.opt

fun doAlgorithm(filename: String) {
    try {
        val memorylimit = getMemoryLimit(filename)
        val appeals = getAppeals(filename)
        output(fifo(memorylimit, appeals), lru(memorylimit, appeals), opt(memorylimit, appeals))
    } catch (ex: Exception) {
        println(ex)
    }
}


fun main(args: Array<String>) {
    try {
        if (checkFilesProperties("testFiles/test.txt")) {
            doAlgorithm("testFiles/test.txt")
        } else {
            println("Something wrong with your file")
        }
    } catch (ex: Exception) {
        println(ex)
    }
}