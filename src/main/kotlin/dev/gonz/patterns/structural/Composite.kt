package dev.gonz.patterns.structural

// Component and related
sealed interface Component {
    fun price(): Int
    fun name(): String
}

abstract class Composite : Component {

    abstract val children: Iterable<Component>

    abstract fun add(pack: Component)
    abstract fun remove(pack: Component)
}

abstract class Leaf : Component

// Composite Implementations
class Box : Composite() {
    private val _children = ArrayDeque<Component>()
    override val children: Iterable<Component>
        get() = _children

    override fun add(pack: Component) {
        _children.addLast(pack)
    }

    override fun remove(pack: Component) {
        _children.remove(pack)
    }

    override fun price(): Int {
        return children.fold(0) { acc, pack -> acc + pack.price() }
    }

    override fun name(): String {
        return "Box"
    }
}

// Composite of one single leaf
class LittleBox(
    private val child: Leaf,
) : Composite() {

    override val children: Iterable<Component>
        get() = listOf(child)

    override fun add(pack: Component) {
        // do nothing; just support one child
    }

    override fun remove(pack: Component) {
        // do nothing; just support one child
    }

    override fun price(): Int {
        return child.price()
    }

    override fun name(): String {
        return "LittleBox"
    }
}

// Leaf implementation
class Product(
    private val price: Int,
    private val name: String,
) : Leaf() {
    override fun price(): Int {
        return price
    }

    override fun name(): String {
        return name
    }
}
