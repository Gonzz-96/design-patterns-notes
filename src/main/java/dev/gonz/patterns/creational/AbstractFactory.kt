package dev.gonz.patterns.creational

sealed interface InitialPokemon {
    interface FirePokemon : InitialPokemon
    interface WaterPokemon : InitialPokemon
    interface GrassPokemon : InitialPokemon
}

enum class Region {
    KANTO,
    JOHTO,
    HOENN,
}

abstract class PokemonFactory {
    abstract fun newFirePokemon(): InitialPokemon.FirePokemon
    abstract fun newWaterPokemon(): InitialPokemon.WaterPokemon
    abstract fun newGrassPokemon(): InitialPokemon.GrassPokemon

    companion object {
        fun getFactoryOf(region: Region): PokemonFactory = when (region) {
            Region.KANTO -> KantoFactory()
            Region.JOHTO -> JohtoFactory()
            Region.HOENN -> HoennFactory()
        }
    }
}

private class KantoFactory : PokemonFactory() {
    override fun newFirePokemon(): InitialPokemon.FirePokemon = Charmander
    override fun newWaterPokemon(): InitialPokemon.WaterPokemon = Squirtle
    override fun newGrassPokemon(): InitialPokemon.GrassPokemon = Bulbasaur
}

object Squirtle : InitialPokemon.WaterPokemon
object Bulbasaur : InitialPokemon.GrassPokemon
object Charmander : InitialPokemon.FirePokemon

private class JohtoFactory : PokemonFactory() {
    override fun newFirePokemon(): InitialPokemon.FirePokemon = Cyndaquil
    override fun newWaterPokemon(): InitialPokemon.WaterPokemon = Totodile
    override fun newGrassPokemon(): InitialPokemon.GrassPokemon = Chikorita
}

object Totodile : InitialPokemon.WaterPokemon
object Chikorita : InitialPokemon.GrassPokemon
object Cyndaquil : InitialPokemon.FirePokemon

private class HoennFactory : PokemonFactory() {
    override fun newFirePokemon(): InitialPokemon.FirePokemon = Torchic
    override fun newWaterPokemon(): InitialPokemon.WaterPokemon = Mudkip
    override fun newGrassPokemon(): InitialPokemon.GrassPokemon = Tricko
}

object Mudkip : InitialPokemon.WaterPokemon
object Tricko : InitialPokemon.GrassPokemon
object Torchic : InitialPokemon.FirePokemon
