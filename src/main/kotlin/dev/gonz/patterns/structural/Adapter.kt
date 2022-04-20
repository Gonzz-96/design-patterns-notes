package dev.gonz.patterns.structural

abstract class Pokemon {
    abstract fun fireAttack()
}

class PokemonTrainer(private val pokemon: Pokemon) {
    fun launchFireAttack(): String {
        pokemon.fireAttack()
        return "Fire Attack was launched"
    }
}

class DigimonAdapter(
    private val digimon: Digimon,
) : Pokemon() {
    override fun fireAttack() {
        digimon.randomDigimonAttack()
    }
}

class Digimon {
    fun randomDigimonAttack() { }
}
