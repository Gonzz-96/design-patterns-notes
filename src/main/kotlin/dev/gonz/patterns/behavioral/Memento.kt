package dev.gonz.patterns.behavioral

import dev.gonz.patterns.utils.VisibleForTesting

interface DocumentContentMemento

class DocumentContent(text: String) {

    var text: String = text
        private set

    fun appendText(newText: String) {
        text = buildString {
            append(text)
            append(newText)
        }
    }

    fun setMemento(memento: DocumentContentMemento) {
        if (memento !is DocumentContentMementoImpl) {
            throw Exception("The implementation of memento is not adequate for this document")
        }
        this.text = memento.oldText
    }

    fun createMemento(): DocumentContentMemento {
        return DocumentContentMementoImpl(text)
    }

    private class DocumentContentMementoImpl(
        val oldText: String,
    ) : DocumentContentMemento
}

class DocumentController(val documentContent: DocumentContent) {

    private val _mementos = mutableListOf<DocumentContentMemento>()

    @VisibleForTesting
    val mementos: List<DocumentContentMemento> get() = _mementos

    fun appendText(newText: String) {
        // save current state to undo
        _mementos.add(documentContent.createMemento())
        documentContent.appendText(newText)
    }

    fun undoMod() {
        val previousState = _mementos.removeLast()
        documentContent.setMemento(previousState)
    }
}