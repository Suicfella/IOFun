package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> npcNames = new HashSet<>();
        npcNames.add("ight");
        npcNames.add("fella");
        npcNames.add("ight");
        npcNames.forEach(System.out::println);
    }
}
