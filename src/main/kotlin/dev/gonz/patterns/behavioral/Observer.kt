package dev.gonz.patterns.behavioral

import dev.gonz.patterns.utils.VisibleForTesting

interface Observer {
    fun update(subject: Subject)
    fun dropSubjectReference(subject: Subject)
}

abstract class Subject {
    @VisibleForTesting
    val registeredObservers: Set<Observer> get() = observers

    protected var observers = mutableSetOf<Observer>()

    fun attachObserver(observer: Observer) {
        observers.add(observer)
    }

    fun detachObserver(observer: Observer) {
        observers.remove(observer)
    }

    fun notifyUpdate() {
        observers.forEach{ it.update(this) }
    }
}

class IntSubject : Subject() {
    var number: Int = 0
        private set

    fun incrementCounter() {
        // update concrete subject state with concrete logic
        number++
        notifyUpdate()
    }

    fun destroy() {
        observers.forEach { it.dropSubjectReference(this) }
        // since this subject will be dropped, its references to its observers
        // must be dropped too
        observers = mutableSetOf()
    }
}

class StringSubject : Subject() {
    var string: String = ""
        private set

    fun appendString(newString: String) {
        // update concrete subject state with concrete logic
        string = buildString {
            append(string)
            append(newString)
        }
        notifyUpdate()
    }

    fun notifyDestruction() {
        observers.forEach { it.dropSubjectReference(this) }
    }
}

class AnyObserver(
    intSubject: IntSubject? = null,
    stringSubject: StringSubject? = null,
) : Observer {

    @VisibleForTesting
    var intSubject = intSubject
        private set
    @VisibleForTesting
    var stringSubject = stringSubject
        private set

    init {
        // observer registers itself to subjects
        intSubject?.attachObserver(this)
        stringSubject?.attachObserver(this)
    }

    private val _intValues = mutableListOf<Int>()
    private val _stringValues = mutableListOf<String>()

    @VisibleForTesting
    val intValues: List<Int>
        get() = _intValues
    @VisibleForTesting
    val stringValues: List<String>
        get() = _stringValues

    override fun update(subject: Subject) {
        if (intSubject === subject) intSubject?.number?.let(_intValues::add)
        if (stringSubject === subject) stringSubject?.string?.let(_stringValues::add)
    }

    // the java standard library offers "java.lang.ref.WeakReference" which does not imply the
    // ownership of an object (meaning that the reference counter of the object in question is not increased,
    // hence preventing a memory leak, but increasing the chances of a NPE crash)
    override fun dropSubjectReference(subject: Subject) {
        if (intSubject === subject) intSubject = null
        if (stringSubject === subject) stringSubject = null
    }
}