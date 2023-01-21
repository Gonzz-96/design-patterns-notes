package dev.gonz.patterns.structural

import org.junit.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertNotSame
import kotlin.test.assertSame

class FlyweightTest {

    @Test
    fun `given a GlyphClient and any string, when getRowFrom, then verify identity of glyphs of the same char`() {
        val glyphFactory = GlyphFactory()
        val client = GlyphClient(glyphFactory)

        val row = client.getRowFrom("aaaaaaaaaabbbbbbbbbbcccccccccc")

        row.forEach {
            assertSame(it, glyphFactory.createChar(it.charCode))
        }
    }

    @Test
    fun `given a GlyphClient and any string, when getRowFrom, then verify rows are different instances with same contents`() {
        val glyphFactory = GlyphFactory()
        val client = GlyphClient(glyphFactory)

        val rowOne = client.getRowFrom("Hello, world!")
        val rowTwo = client.getRowFrom("Hello, world!")

        assertNotSame(rowOne, rowTwo)
        assertContentEquals(rowOne, rowTwo)
    }
}