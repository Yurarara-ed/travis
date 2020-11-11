package virtual.memory.readingMethods

import java.io.File


//Проверяю разрешение полученного файла. Проверяю файл на пустоту

fun checkFilesProperties(filepath: String): Boolean {
    val file = File(filepath)
    val fileName = file.name
    var expansionOfFile = ""
    var fileContent = "" //Буфферная переменная, для содержания файла
    if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) { // Проверяю существование имени файла и наличия его расширения
        expansionOfFile =
            fileName.substring(fileName.lastIndexOf(".") + 1) //Получаю расширение файла
    }
    file.forEachLine {
        fileContent += it // Экспортирую контент в переменную fileContent
    }
    if (!(expansionOfFile != "txt" || fileContent.isEmpty())) return true // Главная проверка функции. Расширение и наполнение файла

    return false
}

//Получаю ограничение кол-ва памяти. (Условие Алгоритма)

fun getMemoryLimit(filepath: String): Int {
    val file = File(filepath)
    var memoryLimit =
        "-1"
    file.forEachLine {
        if (!it.isBlank()) { //Пропускаю пустые линии
            val splitLine = it.split(" ") // Разбиваю строку на колонки.
            if (splitLine.size == 1 && memoryLimit === "-1") { // Получаю ограничение памяти файла.
                memoryLimit = splitLine[0]
            }
        }
    }
    return memoryLimit.toInt()
}

//Получаю список запросов. Функция обратна получения лимита памяти. Только принимаю те строки где после сплит
//выходит больше одной колонки. В отличии от getMemoryLimit функция возращает Массив Чисел.

fun getAppeals(filepath: String): MutableList<Number> {
    val file = File(filepath)
    val appeals = mutableListOf<Number>()
    file.forEachLine {
        val splitLine = it.split(" ")
        if (splitLine.size != 1 && appeals.size == 0) {
            for (appeal in splitLine) {
                appeals.add(appeal.toInt())
            }
        }
    }
    return appeals
}