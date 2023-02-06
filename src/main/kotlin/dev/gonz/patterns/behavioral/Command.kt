package dev.gonz.patterns.behavioral

interface Document {
    val fileName: String

    fun open(fileName: String)
    fun save(newFileName: String)
    fun close()
    fun format()
    fun changeBackgroundColor()
}

interface Command {
    fun execute()
}

class MacroCommand : Command {
    private val commands = mutableListOf<Command>()

    override fun execute() {
        commands.forEach(Command::execute)
    }

    fun add(command: Command) {
        commands.add(command)
    }

    fun remove(command: Command) {
        commands.remove(command)
    }
}

class OpenDocumentCommand(
    val document: Document,
) : Command {
    override fun execute() {
        val fileName = askUser()
        document.open(fileName)
    }

    private fun askUser(): String {
        return "my_awesome_file.txt"
    }
}

class SaveDocumentCommand(
    val document: Document,
    val newFileName: String? = null,
) : Command {
    override fun execute() {
        document.save(newFileName ?: document.fileName)
    }
}

class CloseDocumentCommand(
    val document: Document,
) : Command {
    override fun execute() {
        document.close()
    }
}

class SimpleCommand<T>(
    val receiver: T,
    val action: T.() -> Unit,
) : Command {

    override fun execute() {
        receiver.action()
    }
}