class NoteMenu(private val archive: Archive) : Menu<Note>("Заметки в архиве '${archive.name}'") {
    init {
        addItem("Создать заметку", ::createNote)
        addItem("Выбрать заметку", ::selectNote)
    }

    private fun createNote() {
        val title = promptForNonEmptyInput("Введите название заметки: ")
        val content = promptForNonEmptyInput("Введите текст заметки: ")
        archive.notes.add(Note(title, content))
        println("Заметка '$title' создана.")
    }

    private fun selectNote() {
        if (archive.notes.isEmpty()) {
            println("Нет доступных заметок. Сначала создайте заметку.")
            return
        }

        NoteViewMenu(archive.notes).show()
    }
}