package org.example.CustomImplementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomMap {
    Map<String,Map<String,String>>maps = new HashMap<>();
    Map<String,String>selectedMap ;

    public void create(String key){
        if (maps.size()<3){
            maps.put(key,new HashMap<>());
            System.out.println("Map "+ key + "Created Successfully.");
        }
        else {
            System.out.println("Map cannot contain more than 3 key value pair");
        }
    }
    public void select(String key){
        if (maps.containsKey(key)){
            this.selectedMap = maps.get(key);
            System.out.println("Selected Map " + key);
        }else {
            System.out.println("The map "+ key + "does not exists");
        }
    }
}
