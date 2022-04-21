package dev.gonz.patterns.structural

abstract class Pokemon {
    abstract fun fireAttack(): Attack
}

class PokemonTrainer(private val pokemon: Pokemon) {
    fun launchAttack(): Attack {
        return pokemon.fireAttack()
    }
}

class DigimonAdapter(
    private val digimon: Digimon,
) : Pokemon() {
    override fun fireAttack(): Attack {
        return digimon.randomDigimonAttack()
    }
}

class Digimon {
    fun randomDigimonAttack() = Attack.FIRE
}

enum class Attack {
    FIRE,
    WATER,
    GRASS
}