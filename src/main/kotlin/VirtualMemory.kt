@file:JvmName("VirtualMemory")

package virtual.memory

import virtual.memory.readingMethods.checkFilesProperties


fun main(args: Array<String>) {
    try {
        if (checkFilesProperties("testFiles/test.txt")) {
            println("Everything ok with the file")
        } else {
            println("Something wrong with your file")
        }
    } catch (ex: Exception) {
        println(ex)
    }
}