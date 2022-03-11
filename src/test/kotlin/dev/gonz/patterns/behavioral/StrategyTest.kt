package dev.gonz.patterns.behavioral

import org.junit.Test
import kotlin.test.assertContentEquals

class StrategyTest {

    @Test
    fun `given a normal pokemon, when attack is changed and registered at runtime, then expect the same order of attacks`() {
        val attacksList = mutableListOf<String>()
        val pokemon = Pokemon()

        attacksList.add(pokemon.attack.attack().value)
        pokemon.attack = Attack.FireAttack
        attacksList.add(pokemon.attack.attack().value)
        pokemon.attack = Attack.WaterAttack
        attacksList.add(pokemon.attack.attack().value)

        val expectedAttacks = listOf(
            AttackType.NO_ATTACK.value,
            AttackType.FIRE.value,
            AttackType.WATER.value
        )
        assertContentEquals(expected = expectedAttacks, actual = attacksList)
    }
}
