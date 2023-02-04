package dev.gonz.patterns.structural

import dev.gonz.patterns.utils.VisibleForTesting

interface Image {
    fun draw()
    fun changeColor(color: Color)

    enum class Color {
        red,
        blue
    }
}

// pretending this is a expensive-to-instance class
class HeavyWeightImage : Image {
    override fun draw() {}
    override fun changeColor(color: Image.Color) {}
}

class VirtualProxyImage() : Image {
    @VisibleForTesting
    var heavyWeightImage: HeavyWeightImage? = null

    override fun draw() {
        (heavyWeightImage ?: HeavyWeightImage().apply {
            heavyWeightImage = this
        }).draw()
    }

    override fun changeColor(color: Image.Color) {
        (heavyWeightImage ?: HeavyWeightImage().apply {
            heavyWeightImage = this
        }).changeColor(color)
    }
}

class ProtectedProxyImage() : Image {
    private var heavyWeightImage: HeavyWeightImage? = null

    override fun draw() {
        (heavyWeightImage ?: HeavyWeightImage()).draw()
    }

    override fun changeColor(color: Image.Color) {
        throw AccessForbiddenException()
    }
}

class AccessForbiddenException : Exception(EXCEPTION_MESSAGE) {
    companion object  {
        private val EXCEPTION_MESSAGE = """
           This method is not accessible via this object. Try with another instance. 
        """.trimIndent()
    }
}
