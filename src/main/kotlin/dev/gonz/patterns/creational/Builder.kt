package dev.gonz.patterns.creational

data class Pokemon(
    val name: String,
    val region: Region,
    val weight: Double,
    val height: Double,
    val type: String,
    val pokemonPower: Double,
)

abstract class PokemonBuilder {
    protected var _name: String? = null
    protected  var _type: String? = null
    protected  var _power:  Double? = null
    protected  var _region: Region? = null
    protected  var _height: Double? = null
    protected  var _weight: Double? = null

    open fun setName(name: String) { _name = name }
    open fun setType(type: String) { _type = type }
    open fun setPower(power: Double) { _power = power}
    open fun setRegion(region: Region) { _region = region }
    open fun setHeight(height: Double) { _height = height }
    open fun setWeight(weight: Double) { _weight = weight }

    fun get(): Pokemon {
        return Pokemon(
            _name ?: throw IllegalStateException(),
            _region ?: throw IllegalStateException(),
            _weight ?: throw IllegalStateException(),
            _height ?: throw IllegalStateException(),
            _type ?: throw IllegalStateException(),
            _power ?: throw IllegalStateException(),
        )
    }
}

class SuperPoweredPokemonBuilder : PokemonBuilder() {
    override fun setPower(power: Double) { _power = power * 10 }
}

class NormalPokemonBuilder : PokemonBuilder()

class PokemonDirector {
    fun constructPokemon(builder: PokemonBuilder): Pokemon {
        builder.setName("Chikorita")
        builder.setRegion(Region.JOHTO)
        builder.setWeight(10.0)
        builder.setHeight(10.0)
        builder.setType("Grass")
        builder.setPower(50.0)

        return builder.get()
    }
}
