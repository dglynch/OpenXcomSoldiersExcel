package com.dglynch.xcom;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SaveFileReader {
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
                result.add(new Soldier((int) soldier.get("id"), (String) soldier.get("name")));
            }
        }
        return result;
    }
}
