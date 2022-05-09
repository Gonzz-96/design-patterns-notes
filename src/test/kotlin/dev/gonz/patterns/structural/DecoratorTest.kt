package dev.gonz.patterns.structural

import kotlin.test.Test
import kotlin.test.assertEquals

class DecoratorTest {

    @Test
    fun `given a view and two decorators, when they are composed, then assert they are being drawn in the correct order`() {
        val textView = TextView()
        val borderDecorator = BorderDecorator(textView)
        val scrollableDecorator = ScrollableDecorator(borderDecorator)
        val visualComponent: VisualComponent = scrollableDecorator

        val drawingResult = visualComponent.draw()

        assertEquals(
            expected = "ScrollableDecorator -> BorderDecorator -> TextView",
            actual = drawingResult,
        )
    }

    @Test
    fun `given a view and two decorators, when they are composed in a different, then assert they are being drawn in the correct order`() {
        val textView = TextView()
        val scrollableDecorator = ScrollableDecorator(textView)
        val borderDecorator = BorderDecorator(scrollableDecorator)
        val visualComponent: VisualComponent = borderDecorator

        val drawingResult = visualComponent.draw()

        assertEquals(
            expected = "BorderDecorator -> ScrollableDecorator -> TextView",
            actual = drawingResult,
        )
    }
}
