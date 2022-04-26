package dev.gonz.patterns.structural

import org.junit.Test
import kotlin.test.assertIs

class BridgeTest {

    @Test
    fun `given a Window object, when implementation changes, then check correct type of object`() {
        val windowsWindow: ViewPlatformImpl = WindowsWindow()
        val window: ViewType = Window(windowsWindow)

        assertIs<WindowsWindow>(window.platformImplementation)

        val macWindow: ViewPlatformImpl = MacWindow()
        window.platformImplementation = macWindow

        assertIs<MacWindow>(window.platformImplementation)
    }

    @Test
    fun `given a Button object, when implementation changes, then check correct type of object`() {
        val macButton: ViewPlatformImpl = MacButton()
        val window: ViewType = Button(macButton)

        assertIs<MacButton>(window.platformImplementation)

        val linuxButton: ViewPlatformImpl = LinuxButton()
        window.platformImplementation = linuxButton

        assertIs<LinuxButton>(window.platformImplementation)
    }
}
