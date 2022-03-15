package dev.gonz.patterns.creational

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class PrototypeTest {

    @Test
    fun `given some generic prototypes, when factory clones them with no new power, then get regular pokemons with same power`() {
        val firePrototype = FirePokemon()
        val waterPrototype = WaterPokemon()
        val grassPrototype = GrassPokemon()
        val genericPokemonFactory = PokemonPrototypeFactory(firePrototype, waterPrototype, grassPrototype)

        val firePokemon = genericPokemonFactory.cloneFirePokemon()
        val waterPokemon = genericPokemonFactory.cloneWaterPokemon()
        val grassPokemon = genericPokemonFactory.cloneGrassPokemon()

        assertTrue(firePrototype !== firePokemon)
        assertTrue(waterPrototype !== waterPokemon)
        assertTrue(grassPrototype !== grassPokemon)
        assertEquals(expected = firePrototype.power, actual = firePokemon.power)
        assertEquals(expected = waterPrototype.power, actual = waterPokemon.power)
        assertEquals(expected = grassPrototype.power, actual = grassPokemon.power)
    }

    @Test
    fun `given some generic prototypes, when factory clones them with new power, then get regular pokemons with different power`() {
        val firePrototype = FirePokemon()
        val waterPrototype = WaterPokemon()
        val grassPrototype = GrassPokemon()
        val genericPokemonFactory = PokemonPrototypeFactory(firePrototype, waterPrototype, grassPrototype)

        val firePokemon = genericPokemonFactory.cloneFirePokemon(newPower = 80)
        val waterPokemon = genericPokemonFactory.cloneWaterPokemon(newPower = 75)
        val grassPokemon = genericPokemonFactory.cloneGrassPokemon(newPower = 10)

        assertTrue(firePrototype !== firePokemon)
        assertTrue(waterPrototype !== waterPokemon)
        assertTrue(grassPrototype !== grassPokemon)
        assertNotEquals(illegal = firePrototype.power, actual = firePokemon.power)
        assertNotEquals(illegal = waterPrototype.power, actual = waterPokemon.power)
        assertNotEquals(illegal = grassPrototype.power, actual = grassPokemon.power)
    }
}
