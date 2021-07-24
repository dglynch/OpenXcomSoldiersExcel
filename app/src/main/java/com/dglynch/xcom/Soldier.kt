/*
    Copyright 2021 Dan Lynch

    This file is part of OpenXcom Soldiers Excel.

    OpenXcom Soldiers Excel is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by the Free
    Software Foundation, either version 3 of the License, or (at your option) any
    later version.

    This program is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
    FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
    details.

    You should have received a copy of the GNU General Public License along with
    this program; if not, see <http://www.gnu.org/licenses>.
*/

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
