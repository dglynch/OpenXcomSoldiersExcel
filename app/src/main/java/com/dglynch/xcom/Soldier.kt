package com.dglynch.xcom

data class Soldier(
    val id: Int,
    val name: String,
    val base: String,
    val rank: String,
    val timeUnits: Int,
    val stamina: Int,
    val health: Int,
    val bravery: Int,
    val reactions: Int,
    val firing: Int,
    val throwing: Int,
    val strength: Int,
    val psiStrength: Int,
    val psiSkill: Int,
    val melee: Int,
    val missions: Int,
    val kills: Int,
) {
    fun getPromotionScore(): Int {
        return 2 * health + 2 * stamina + 4 * reactions + 4 * bravery + 3 * timeUnits +
                6 * firing + melee + throwing + strength + 10 * missions + 10 * kills +
                if (psiSkill > 0) (psiStrength + 2 * psiSkill) else 0;
    }
}
