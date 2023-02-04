package dev.gonz.patterns.structural

import org.junit.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull


class ProxyTest {

    @Test
    fun `given a virtual proxy object, when methods are called, then just run`() {
        val proxy = VirtualProxyImage()
        val image: Image = proxy

        assertNull(proxy.heavyWeightImage)
        image.draw()

        assertNotNull(proxy.heavyWeightImage)
        image.changeColor(Image.Color.blue)
    }

    @Test(expected = AccessForbiddenException::class)
    fun `given a protected proxy object, when method forbidden is called, then expect error`() {
        val image: Image = ProtectedProxyImage()

        image.draw()
        image.changeColor(Image.Color.blue) // throws
    }

}