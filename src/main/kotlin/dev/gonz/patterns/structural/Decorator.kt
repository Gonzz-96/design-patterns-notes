package dev.gonz.patterns.structural

// principal abstract component
abstract class VisualComponent {
    abstract fun draw(): String
}

// implementation
class TextView : VisualComponent() {
    override fun draw(): String {
        return "TextView"
    }
}

// decorator
abstract class Decorator(
    val visualComponent: VisualComponent,
) : VisualComponent() {

    override fun draw(): String {
        return visualComponent.draw()
    }
}

// implementations of decorator
class BorderDecorator(
    visualComponent: VisualComponent,
) : Decorator(visualComponent) {
    override fun draw(): String {
        return buildString {
            append("BorderDecorator -> ")
            append(super.draw())
        }
    }
}

class ScrollableDecorator(
    visualComponent: VisualComponent,
) : Decorator(visualComponent) {
    override fun draw(): String {
        return buildString {
            append("ScrollableDecorator -> ")
            append(super.draw())
        }
    }
}
