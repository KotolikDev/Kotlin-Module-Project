class MainMenu : Menu<Archive>("Главное меню") {
    private val archives = mutableListOf<Archive>()

    init {
        addItem("Создать архив", ::createArchive)
        addItem("Выбрать архив", ::selectArchive)
    }

    private fun createArchive() {
        val name = promptForNonEmptyInput("Введите название архива: ")
        archives.add(Archive(name))
        println("Архив '$name' создан.")
    }

    private fun selectArchive() {
        if (archives.isEmpty()) {
            println("Нет доступных архивов. Сначала создайте архив.")
            return
        }

        ArchiveMenu(archives).show()
    }
}