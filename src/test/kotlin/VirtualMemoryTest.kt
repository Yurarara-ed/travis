import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import virtual.memory.readingMethods.checkFilesProperties
import virtual.memory.readingMethods.getAppeals
import virtual.memory.readingMethods.getMemoryLimit

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

}