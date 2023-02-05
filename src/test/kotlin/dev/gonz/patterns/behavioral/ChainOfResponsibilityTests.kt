package dev.gonz.patterns.behavioral

import org.junit.Test
import kotlin.test.assertEquals

class ChainOfResponsibilityTests {

    @Test
    fun `given a chain compose by button-dialog-app, when handleHelp is called, then receive the correct help`() {
        val app = App()
        val dialog = Dialog(helpHandler = app)
        val button = Button(parent = dialog)
        val helpHandler: HelpHandler = button

        val help = helpHandler.handleHelp()

        assertEquals(expected = HelpTopic.buttonHelp.message, actual = help)
    }

    @Test
    fun `given a chain compose by button-dialog-app, when handleHelp is called with a different HelpTopic, then receive correct help`() {
        val app = App()
        val dialog = Dialog(helpHandler = app)
        val button = Button(parent = dialog)
        val helpHandler: HelpHandler = button

        val help = helpHandler.handleHelp(topic = HelpTopic.appHelp)

        assertEquals(expected = HelpTopic.appHelp.message, actual = help)
    }

    @Test(expected = NoHelpException::class)
    fun `given a chain compose by button-dialog-app, when handleHelp is called with an unknown HelpTopic, then expect error`() {
        val app = App()
        val dialog = Dialog(helpHandler = app)
        val button = Button(parent = dialog)
        val helpHandler: HelpHandler = button

        helpHandler.handleHelp(topic = HelpTopic.noTopic) // throws, no one handles 'HelpTopic.noTopic'
    }
}
