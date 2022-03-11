package dev.gonz.patterns.behavioral

enum class AttackType(val value: String) {
    FIRE("This is a FIRE attack!"),
    GRASS("This is a GRASS attack!"),
    WATER("This is a WATER attack!"),
    NO_ATTACK("Doing nothing")
}

sealed interface Attack {

    fun attack(): AttackType

    object GrassAttack : Attack {
        override fun attack(): AttackType {
            return AttackType.GRASS
        }
    }

    object FireAttack : Attack {
        override fun attack(): AttackType {
            return AttackType.FIRE
        }
    }

    object WaterAttack : Attack {
        override fun attack(): AttackType {
            return AttackType.WATER
        }
    }

    object NoAttack : Attack {
        override fun attack(): AttackType {
            return AttackType.NO_ATTACK
        }
    }
}

class Pokemon(var attack: Attack = Attack.NoAttack)
