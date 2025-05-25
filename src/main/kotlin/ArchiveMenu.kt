class ArchiveMenu(private val archives: List<Archive>) : Menu<Note>("Архивы") {
    init {
        archives.forEachIndexed { index, archive ->
            addItem(archive.name) { NoteMenu(archive).show() }
        }
    }

    override fun show() {
        if (archives.isEmpty()) {
            println("Нет доступных архивов.")
            return
        }
        super.show()
    }
}