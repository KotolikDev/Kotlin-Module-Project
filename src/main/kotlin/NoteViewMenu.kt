class NoteViewMenu(private val notes: List<Note>) : Menu<Unit>("Просмотр заметки") {
    init {
        notes.forEachIndexed { index, note ->
            addItem(note.title) { viewNote(note) }
        }
    }

    private fun viewNote(note: Note) {
        println("\n=== ${note.title} ===")
        println(note.content)
        println("\nНажмите Enter чтобы вернуться...")
        readlnOrNull()
    }

    override fun show() {
        if (notes.isEmpty()) {
            println("Нет доступных заметок.")
            return
        }
        super.show()
    }
}