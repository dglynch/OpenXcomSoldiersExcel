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

import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

public class SaveFileReader {
    private static final Map<Integer, String> RANK_MAP = Map.of(
            0, "Rookie",
            1, "Squaddie",
            2, "Sergeant",
            3, "Captain",
            4, "Colonel",
            5, "Commander");

    public static List<Soldier> readSoldiers(InputStream inputStream) {
        List<Soldier> result = new ArrayList<>();
        Yaml yaml = new Yaml(new SafeConstructor(new LoaderOptions()));
        Iterable<Object> allDocuments = yaml.loadAll(inputStream);
        Iterator<Object> documents = allDocuments.iterator();
        if (documents.hasNext()) {
            documents.next(); // skip first YAML document in save file
        } else {
            throw new IllegalArgumentException("Save file has no YAML documents");
        }
        if (!documents.hasNext()) {
            throw new IllegalArgumentException("Save file has no second YAML document");
        }
        Map<?, ?> secondDocument = requiredMap(documents.next(), "second YAML document");
        List<?> bases = requiredList(secondDocument.get("bases"), "bases");
        for (Object baseValue : bases) {
            Map<?, ?> base = requiredMap(baseValue, "base");
            List<?> soldiers = requiredList(base.get("soldiers"), "base soldiers");
            for (Object soldierValue : soldiers) {
                Map<?, ?> soldier = requiredMap(soldierValue, "soldier");
                Map<?, ?> currentStats = requiredMap(soldier.get("currentStats"), "currentStats");
                result.add(new Soldier(
                        requiredInt(soldier, "id"),
                        requiredString(soldier, "name"),
                        requiredString(base, "name"),
                        RANK_MAP.get(requiredInt(soldier, "rank")),
                        requiredInt(soldier, "missions"),
                        requiredInt(soldier, "kills"),
                        optionalInt(soldier, "recovery", 0),
                        optionalBoolean(soldier, "psiTraining", false),
                        requiredInt(currentStats, "tu"),
                        requiredInt(currentStats, "stamina"),
                        requiredInt(currentStats, "health"),
                        requiredInt(currentStats, "bravery"),
                        requiredInt(currentStats, "reactions"),
                        requiredInt(currentStats, "firing"),
                        requiredInt(currentStats, "throwing"),
                        requiredInt(currentStats, "melee"),
                        requiredInt(currentStats, "strength"),
                        requiredInt(currentStats, "psiStrength"),
                        requiredInt(currentStats, "psiSkill")));
            }
        }
        return result;
    }

    private static Map<?, ?> requiredMap(Object value, String field) {
        if (value instanceof Map<?, ?> map) {
            return map;
        }
        throw new IllegalArgumentException("Expected a mapping for " + field);
    }

    private static List<?> requiredList(Object value, String field) {
        if (value instanceof List<?> list) {
            return list;
        }
        throw new IllegalArgumentException("Expected a sequence for " + field);
    }

    private static int requiredInt(Map<?, ?> values, String field) {
        return intValue(values.get(field), field);
    }

    @SuppressWarnings("SameParameterValue")
    private static int optionalInt(Map<?, ?> values, String field, int defaultValue) {
        return values.containsKey(field) ? intValue(values.get(field), field) : defaultValue;
    }

    private static int intValue(Object value, String field) {
        if (value instanceof Integer integer) {
            return integer;
        }
        if (value instanceof Long longValue) {
            return Math.toIntExact(longValue);
        }
        if (value instanceof BigInteger bigInteger) {
            return bigInteger.intValueExact();
        }
        throw new IllegalArgumentException("Expected an integer for " + field);
    }

    @SuppressWarnings("SameParameterValue")
    private static String requiredString(Map<?, ?> values, String field) {
        Object value = values.get(field);
        if (value instanceof String string) {
            return string;
        }
        throw new IllegalArgumentException("Expected a string for " + field);
    }

    @SuppressWarnings("SameParameterValue")
    private static boolean optionalBoolean(Map<?, ?> values, String field, boolean defaultValue) {
        Object value = values.get(field);
        if (value == null && !values.containsKey(field)) {
            return defaultValue;
        }
        if (value instanceof Boolean bool) {
            return bool;
        }
        throw new IllegalArgumentException("Expected a boolean for " + field);
    }
}
