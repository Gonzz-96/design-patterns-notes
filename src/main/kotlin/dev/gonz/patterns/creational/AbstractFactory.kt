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

sealed interface KantoPokemon
object Squirtle : KantoPokemon, InitialPokemon.WaterPokemon
object Bulbasaur : KantoPokemon, InitialPokemon.GrassPokemon
object Charmander : KantoPokemon, InitialPokemon.FirePokemon

private class JohtoFactory : PokemonFactory() {
    override fun newFirePokemon(): InitialPokemon.FirePokemon = Cyndaquil
    override fun newWaterPokemon(): InitialPokemon.WaterPokemon = Totodile
    override fun newGrassPokemon(): InitialPokemon.GrassPokemon = Chikorita
}

sealed interface JohtoPokemon
object Totodile : JohtoPokemon, InitialPokemon.WaterPokemon
object Chikorita : JohtoPokemon, InitialPokemon.GrassPokemon
object Cyndaquil : JohtoPokemon, InitialPokemon.FirePokemon

private class HoennFactory : PokemonFactory() {
    override fun newFirePokemon(): InitialPokemon.FirePokemon = Torchic
    override fun newWaterPokemon(): InitialPokemon.WaterPokemon = Mudkip
    override fun newGrassPokemon(): InitialPokemon.GrassPokemon = Tricko
}

sealed interface  HoennPokemon
object Mudkip : HoennPokemon, InitialPokemon.WaterPokemon
object Tricko : HoennPokemon,  InitialPokemon.GrassPokemon
object Torchic : HoennPokemon, InitialPokemon.FirePokemon
