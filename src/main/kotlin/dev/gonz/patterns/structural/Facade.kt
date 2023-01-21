package dev.gonz.patterns.structural

class ShapesFacade(
    private val circle: Shape = Circle(),
) {

    val square: Shape by lazy { Square() }
    val rectangle: Shape by lazy { Rectangle() }

    fun drawCircle() {
        circle.draw()
    }

    fun drawSquare() {
        square.draw()
    }

    fun drawRectangle() {
        rectangle.draw()
    }
}

interface Shape {
    fun draw() {}
}

class Circle : Shape
class Square : Shape
class Rectangle : Shape