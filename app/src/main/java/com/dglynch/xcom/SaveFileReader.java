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

package com.dglynch.xcom;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SaveFileReader {
    private static final Map<Integer, String> RANK_MAP = Map.of(
            0, "Rookie",
            1, "Squaddie",
            2, "Sergeant",
            3, "Captain",
            4, "Colonel",
            5, "Commander"
    );

    @SuppressWarnings("unchecked")
    public static List<Soldier> readSoldiers(InputStream inputStream) {
        List<Soldier> result = new ArrayList<>();
        Yaml yaml = new Yaml();
        Iterable<Object> allDocuments = yaml.loadAll(inputStream);
        allDocuments.iterator().next(); // skip first YAML document in save file
        Map<String, Object> secondDocument = (Map<String, Object>) allDocuments.iterator().next();
        List<Map<String, Object>> bases = (List<Map<String, Object>>) secondDocument.get("bases");
        for (Map<String, Object> base : bases) {
            List<Map<String, Object>> soldiers = (List<Map<String, Object>>) base.get("soldiers");
            for (Map<String, Object> soldier : soldiers) {
                Map<String, Object> currentStats = (Map<String, Object>) soldier.get("currentStats");
                result.add(new Soldier(
                        (int) soldier.get("id"),
                        (String) soldier.get("name"),
                        (String) base.get("name"),
                        RANK_MAP.get((Integer) soldier.get("rank")),
                        (int) currentStats.get("tu"),
                        (int) currentStats.get("stamina"),
                        (int) currentStats.get("health"),
                        (int) currentStats.get("bravery"),
                        (int) currentStats.get("reactions"),
                        (int) currentStats.get("firing"),
                        (int) currentStats.get("throwing"),
                        (int) currentStats.get("strength"),
                        (int) currentStats.get("psiStrength"),
                        (int) currentStats.get("psiSkill"),
                        (int) currentStats.get("melee"),
                        (int) soldier.get("missions"),
                        (int) soldier.get("kills")
                ));
            }
        }
        return result;
    }
}
