abstract class Menu<T>(protected val title: String) {
    protected val items = mutableListOf<Pair<String, () -> Unit>>()

    fun addItem(name: String, action: () -> Unit) {
        items.add(Pair(name, action))
    }

    open fun show() {
        while (true) {
            println("\n$title")
            items.forEachIndexed { index, pair ->
                println("${index + 1}. ${pair.first}")
            }
            println("0. ${if (this is MainMenu) "Выход" else "Назад"}")

            print("Выберите пункт меню: ")
            val input = readlnOrNull()

            try {
                val choice = input?.toInt() ?: throw NumberFormatException()

                when (choice) {
                    0 -> return
                    in 1..items.size -> items[choice - 1].second()
                    else -> println("Пункта с номером $choice нет в меню. Пожалуйста, выберите снова.")
                }
            } catch (e: NumberFormatException) {
                println("Некорректный ввод. Пожалуйста, введите число.")
            }
        }
    }

    protected fun promptForNonEmptyInput(prompt: String): String {
        while (true) {
            print(prompt)
            val input = readlnOrNull()?.trim()
            if (!input.isNullOrEmpty()) {
                return input
            }
            println("Поле не может быть пустым. Пожалуйста, введите значение.")
        }
    }
}