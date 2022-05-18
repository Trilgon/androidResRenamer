import java.io.File

fun main(args: Array<String>) {
    var stop = false
    while (!stop){
        println("Ввведите путь до директории с файлами для переименования")
        checkDirectory(readln(), ::renameToValidRes)
        println("Хотите ввести ещё директорию для переименования?y/n")
        when(readln()){
            "n" -> stop = true
            "no" -> stop = true
            "нет" -> stop = true
            "не" -> stop = true
        }
    }
}

fun checkDirectory(path: String, processor: (file: File) -> Unit) {
    val dir = File(path)

    if (dir.exists()) {
        for (file in dir.listFiles()) {
            if (file != null && file.exists()){
                processor(file)
            }
        }
    }

}

fun renameToValidRes(file: File) {
    val fileName = file.name.lowercase().replace('-','_')
    file.renameTo(File(file.parent + "\\" + fileName))
}