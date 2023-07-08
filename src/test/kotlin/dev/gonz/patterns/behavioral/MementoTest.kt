package dev.gonz.patterns.behavioral

import org.junit.Test
import kotlin.test.assertEquals

class MementoTest {

    @Test
    fun `given a document and its controller, when a new modification gets in, then verify there is one memento`() {
        val document = DocumentContent("Heaven must")
        val documentController = DocumentController(document)

        documentController.appendText(" have sent you")

        assertEquals(expected = TEST_STRING, actual = document.text)
        assertEquals(expected = 1, actual = documentController.mementos.size)
    }

    @Test
    fun `given a document and its controller, when several modification get in, then verify there are various mementos`() {
        val document = DocumentContent("Heaven must")
        val documentController = DocumentController(document)

        documentController.appendText(" have")
        documentController.appendText(" sent")
        documentController.appendText(" you")

        assertEquals(expected = TEST_STRING, actual = document.text)
        assertEquals(expected = 3, actual = documentController.mementos.size)
    }

    @Test
    fun `given a document and its controller, when one undos are performed, then verify the correct state of doc`() {
        val document = DocumentContent("Heaven must")
        val documentController = DocumentController(document)

        documentController.appendText(" have")
        documentController.appendText(" sent")
        documentController.appendText(" you")
        documentController.undoMod()

        assertEquals(expected = "Heaven must have sent", actual = document.text)
        assertEquals(expected = 2, actual = documentController.mementos.size)
    }

    @Test
    fun `given a document and its controller, when several undos are performed, then verify the correct state of doc`() {
        val document = DocumentContent("Heaven must")
        val documentController = DocumentController(document)

        documentController.appendText(" have")
        documentController.appendText(" sent")
        documentController.appendText(" you")
        documentController.undoMod()
        documentController.undoMod()
        documentController.undoMod()

        assertEquals(expected = "Heaven must", actual = document.text)
        assertEquals(expected = 0, actual = documentController.mementos.size)
    }

    companion object {
        private const val TEST_STRING = "Heaven must have sent you"
    }
}