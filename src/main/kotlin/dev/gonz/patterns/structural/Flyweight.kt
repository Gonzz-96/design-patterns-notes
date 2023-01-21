package dev.gonz.patterns.structural

class GlyphClient(
    private val glyphFactory: GlyphFactory,
) {

    fun getRowFrom(string: String): Row {
        val row = glyphFactory.createRow()
        string.map {
            glyphFactory.createChar(it)
        }.let(row::addAll)
        return row
    }
}

class GlyphFactory {

    private val charsMap: HashMap<Char, CharacterGlyph> by lazy { hashMapOf() }

    fun createChar(key: Char): CharacterGlyph {
        return charsMap[key]
            ?: CharacterGlyph(key).also {
                charsMap[key] = it
            }
    }

    fun createRow(): Row {
        return Row()
    }
}

interface Glyph

class CharacterGlyph(
    val charCode: Char,
) : Glyph

class Row : Glyph, MutableList<CharacterGlyph> by mutableListOf()