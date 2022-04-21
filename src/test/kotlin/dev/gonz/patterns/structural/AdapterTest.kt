package dev.gonz.patterns.structural

import org.junit.Test
import kotlin.test.assertEquals

class AdapterTest {

    @Test
    fun `given a digimon and a class expecting a pokemon, when launchFireAttack is called, then digimon attack is adapted`() {
        val digimon = Digimon()
        val adapter = DigimonAdapter(digimon)
        val pokemonTrainer = PokemonTrainer(adapter)

        val result = pokemonTrainer.launchAttack()

        assertEquals(expected = Attack.FIRE, actual = result)
    }
}