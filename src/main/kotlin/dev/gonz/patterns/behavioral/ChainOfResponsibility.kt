package dev.gonz.patterns.behavioral

enum class HelpTopic(val message: String) {
    noTopic(message = "No topic"),
    appHelp(message = "App help"),
    dialogHelp(message =  "Dialog help"),
    buttonHelp(message = "Button help"),
}

abstract class HelpHandler(
    private var successor: HelpHandler? = null,
    private var helpTopic: HelpTopic = HelpTopic.noTopic
) {

    fun handleHelp(): String {
        return handleHelp(helpTopic)
    }

    fun handleHelp(topic: HelpTopic): String {
        return if (hasHelp() && helpTopic == topic) {
            helpTopic.message
        } else if (successor != null) {
            successor!!.handleHelp(topic)
        } else {
            throw NoHelpException()
        }
    }

    fun setHandler(successor: HelpHandler, helpTopic: HelpTopic) {
        this.successor = successor
        this.helpTopic = helpTopic
    }

    private fun hasHelp(): Boolean {
        return helpTopic != HelpTopic.noTopic
    }
}

class NoHelpException : Exception()

abstract class View(
    parent: View? = null,
    helpTopic: HelpTopic = HelpTopic.noTopic,
) : HelpHandler(parent, helpTopic)

class Button(
    parent: View,
    helpTopic: HelpTopic = HelpTopic.buttonHelp,
) : View(parent, helpTopic)

class Dialog(
    helpHandler: HelpHandler,
    helpTopic: HelpTopic = HelpTopic.dialogHelp,
) : View(null) {
    init  {
        setHandler(helpHandler, helpTopic)
    }
}

class App(
    helpTopic: HelpTopic = HelpTopic.appHelp,
) : HelpHandler(helpTopic = helpTopic)
