/*
    Copyright 2021, 2026 Dan Lynch

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

package com.dglynch.xcom;

public record Soldier(
        int id,
        String name,
        String base,
        String rank,
        int missions,
        int kills,
        int recovery,
        boolean psiTraining,
        int timeUnits,
        int stamina,
        int health,
        int bravery,
        int reactions,
        int firing,
        int throwing,
        int melee,
        int strength,
        int psiStrength,
        int psiSkill) {
    public int promotionScore() {
        return 2 * health
                + 2 * stamina
                + 4 * reactions
                + 4 * bravery
                + 3 * timeUnits
                + 6 * firing
                + melee
                + throwing
                + strength
                + 10 * missions
                + 10 * kills
                + (psiSkill > 0 ? psiStrength + 2 * psiSkill : 0);
    }
}
