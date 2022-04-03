package dev.gonz.patterns.creational

class LegendaryPokemon private constructor() {

    companion object {

        // visible for testing
        @JvmStatic
        private var INSTANCE: LegendaryPokemon? = null

        @JvmStatic
        fun get(): LegendaryPokemon = INSTANCE ?: LegendaryPokemon().apply {
            INSTANCE = this
        }
    }
}