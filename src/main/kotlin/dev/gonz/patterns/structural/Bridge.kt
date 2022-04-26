package dev.gonz.patterns.structural

// Abstraction
abstract class ViewType(
    var platformImplementation: ViewPlatformImpl,
)

class Window(
    windowImpl: ViewPlatformImpl,
) : ViewType(windowImpl)

class Button(
    buttonImpl: ViewPlatformImpl,
) : ViewType(buttonImpl)

// Implementation
abstract class ViewPlatformImpl {
    abstract fun draw(): String
}

class WindowsWindow : ViewPlatformImpl() {
    override fun draw(): String = Platform.WINDOWS.name
}

class MacWindow : ViewPlatformImpl() {
    override fun draw(): String = Platform.MAC.name
}

class MacButton : ViewPlatformImpl() {
    override fun draw(): String = Platform.MAC.name
}

class LinuxButton : ViewPlatformImpl() {
    override fun draw(): String = Platform.LINUX.name
}

enum class Platform {
    WINDOWS,
    MAC,
    LINUX,
}
