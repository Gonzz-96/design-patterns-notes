package dev.gonz.patterns.structural

import io.mockk.*
import org.junit.Test

class FacadeTest {

    @Test
    fun `given a ShapesFacade, when drawCircle is called, then verify draw on circle was called`() {
        val circleMock = mockk<Circle>()
        every { circleMock.draw() } just runs
        val facade = ShapesFacade(circleMock)

        facade.drawCircle()

        verify(exactly = 1) { circleMock.draw() }
    }
}