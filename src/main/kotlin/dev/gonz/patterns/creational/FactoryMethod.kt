package dev.gonz.patterns.creational

interface TrainedPokemon

abstract class PokemonTrainer {

    abstract val favoritePokemon: TrainedPokemon
}

class Dragonite : TrainedPokemon {
    override fun toString(): String = "Dragonite"
}
class Charizard : TrainedPokemon {
    override fun toString(): String = "Charizard"
}

data class Gonz private constructor(
    override val favoritePokemon: TrainedPokemon = Dragonite(),
) : PokemonTrainer() {

    companion object {
        fun get() = Gonz()
    }
}

data class RandomFolk private constructor(
    override val favoritePokemon: TrainedPokemon = Charizard(),
) : PokemonTrainer() {

    companion object {
        fun get() = RandomFolk()
    }
}

fun buffTrainersPokemon(trainer: PokemonTrainer): String {
    return "${trainer.favoritePokemon} is getting buffed!"
}
