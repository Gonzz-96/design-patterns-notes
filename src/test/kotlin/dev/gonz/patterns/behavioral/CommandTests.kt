package dev.gonz.patterns.behavioral

import io.mockk.*
import org.junit.Test
import kotlin.test.assertContentEquals

class CommandTests {

    @Test
    fun `given a open document command, when executing it, then assert correct call to its dependencies`() {
        val document = mockk<Document>()
        val openCommand: Command = OpenDocumentCommand(document)
        every { document.open(any()) } just Runs

        openCommand.execute()

        verify { document.open("my_awesome_file.txt") }
    }

    @Test
    fun `given some simple commands, when executing them, then assert correct calls to them`() {
        val document = mockk<Document>()
        val formatCommand: Command = SimpleCommand(document) { format() }
        val changeBackgroundCommand: Command = SimpleCommand(document) { changeBackgroundColor() }
        every { document.format() } just Runs
        every { document.changeBackgroundColor() } just Runs

        formatCommand.execute()
        changeBackgroundCommand.execute()

        verify { document.format() }
        verify { document.changeBackgroundColor() }
    }

    @Test
    fun `given a macro command, when adding other commands, then check they were executed in the correct order`() {
        val document = mockk<Document>()
        val commandsCalled = mutableListOf<Command>()
        val openDocument = OpenDocumentCommand(document)
        val saveDocument = SaveDocumentCommand(document, "my_new_file.txt")
        val closeDocument = CloseDocumentCommand(document)
        val macroCommand: Command = MacroCommand().apply {
            add(openDocument)
            add(saveDocument)
            add(closeDocument)
        }
        every { openDocument.execute() } answers { commandsCalled.add(openDocument) }
        every { saveDocument.execute() } answers { commandsCalled.add(saveDocument) }
        every { closeDocument.execute() } answers { commandsCalled.add(closeDocument) }

        macroCommand.execute()

        assertContentEquals(
            expected = listOf(openDocument, saveDocument, closeDocument),
            actual = commandsCalled,
        )

    }
}