import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import virtual.memory.readingMethods.checkFilesProperties
import virtual.memory.readingMethods.getAppeals
import virtual.memory.readingMethods.getMemoryLimit
import virtual.memory.sortingMethods.*

internal class VirtualMemoryTest {

    //Тесты связанные с обработкой данных из файла.

    @Test
    fun `check expansion and fill`() {
        assertEquals(true, checkFilesProperties("testFiles/test.txt"))
    }

    @Test
    fun `check bad expansion or emptiness`() {
        assertEquals(false, checkFilesProperties("testFiles/emptyfile.txt"))
        assertEquals(false, checkFilesProperties("testFiles/common.docx"))
    }

    @Test
    fun `check getting memory limit`() {
        assertEquals(5, getMemoryLimit("testFiles/test.txt"))
    }

    @Test
    fun `check getting appeals`() {
        val result = mutableListOf<Number>(6, 5, 6, 8, 9, 8, 7, 8, 9, 1, 100, 200, 600, 8560, 400, 300, 250)
        assertEquals(result, getAppeals("testFiles/test.txt"))
    }

    //Функции общей сортировки

    @Test
    fun `check filling memory`() {
        val memoryLimit = 5;
        val appeals = mutableListOf<Number>(1, 2, 3, 4, 5, 6, 7, 8)
        val result = mutableListOf<Number>(1, 2, 3, 4, 5)
        assertEquals(result, fillMemory(memoryLimit, appeals))
    }

    @Test
    fun `check getting request list`() {
        val memoryLimit = 10;
        val appeals = mutableListOf<Number>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val result = mutableListOf<Number>()
        assertEquals(result, getRequestsStack(memoryLimit, appeals))
    }

    //Тесты алгоритмов

    @Test
    fun `fifo`() {
        val resultOne = mutableListOf(mutableListOf(3, 1, 2, 6, 7), mutableListOf(1, 2))
        val resultTwo = mutableListOf(mutableListOf(5, 7, 9, 5, 7, 2, 15, 6, 4, 8), mutableListOf(8, 9, 7, 8, 9))

        assertEquals(resultOne, fifo(5, mutableListOf<Number>(1, 2, 3, 1, 2, 6, 7, 1, 2)))
        assertEquals(resultTwo, fifo(10, mutableListOf<Number>(8, 9, 7, 8, 9, 5, 7, 9, 5, 7, 5, 2, 15, 6, 4, 8, 2)))
    }

}