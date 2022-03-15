package dev.gonz.patterns.creational

// The next three classes can be subclassed th create new prototypes
open class FirePokemon(
    val power: Int = 100,
) {

    fun deepCopy(newPower: Int?): FirePokemon {
        return FirePokemon(newPower ?: power)
    }
}

open class WaterPokemon(
    val power: Int = 100,
) {

    fun deepCopy(newPower: Int?): WaterPokemon {
        return WaterPokemon(newPower ?: power)
    }
}

open class GrassPokemon(
    val power: Int = 100,
) {

    fun deepCopy(newPower: Int?): GrassPokemon {
        return GrassPokemon(newPower ?: power)
    }
}

class PokemonPrototypeFactory(
    private val firePokemon: FirePokemon,
    private val waterPokemon: WaterPokemon,
    private val grassPokemon: GrassPokemon,
) {

    fun cloneFirePokemon(newPower: Int? = null) = firePokemon.deepCopy(newPower)
    fun cloneWaterPokemon(newPower: Int? = null) = waterPokemon.deepCopy(newPower)
    fun cloneGrassPokemon(newPower: Int? = null) = grassPokemon.deepCopy(newPower)
}
