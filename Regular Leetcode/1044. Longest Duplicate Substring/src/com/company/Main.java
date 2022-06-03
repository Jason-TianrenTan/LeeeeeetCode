package com.company;

import java.util.*;

public class Main {

    static final long BASE = 26;
    static final long MODULUS = ;//for modulate

    public String longestDupSubstring(String s) {
        int low = 1, high = s.length();
        String duplicateStr = null;
        while (low <= high) {
            int len = low + (high - low) / 2;
            String findStr;
            if ((findStr = searchDuplicate(s, len)) != null) {
                duplicateStr = findStr;
                low = len + 1;
            } else high = len - 1;
        }
        if (duplicateStr != null)
            return duplicateStr;
        return "";
    }

    private long calculatePower(int pow) {
        long res = 1;
        for (int i = 0; i < pow; i++)
            res = (res * BASE) % MODULUS;
        return res;
    }

    private String searchDuplicate(String s, int len) {
        int strlen = s.length();
        long hash = 0;
        long significant_power = calculatePower(len - 1);
        for (int i = 0; i < len; i++) {
            hash = ((hash * BASE) % MODULUS + (s.charAt(i) - 'a')) % MODULUS;
        }

        //roll hashing
        /**
         * @param Integer: hash value
         * @param ArrayList: list of strings' first index with the same hash value
         */
        Map<Long, ArrayList<Integer>> hashmap = new HashMap<>();
        hashmap.put(hash, new ArrayList<>());
        hashmap.get(hash).add(0);
        for (int i = 1; i < strlen - len + 1; i++) {
            long deleteHash = (significant_power * (s.charAt(i - 1) - 'a')) % MODULUS;
            int addHash = s.charAt(i + len - 1) - 'a';
            long new_hash = ((hash - deleteHash) * BASE + MODULUS) % MODULUS;
            new_hash = (new_hash + addHash) % MODULUS;

            List<Integer> strIndices = hashmap.get(new_hash);
            if (strIndices != null) {
                String current = s.substring(i, i + len);
                for (int str_index : strIndices) {
                    String s1 = s.substring(str_index, str_index + len);
                    if (current.equals(s1))
                        return current;
                }
            }
            hashmap.putIfAbsent(new_hash, new ArrayList<>());
            hashmap.get(new_hash).add(i);
            hash = new_hash;
        }
        return null;
    }

    public void work() {
        String s = "ababdaebdabedeabbdddbcebaccececbccccebbcaaabaadcadccddaedaacaeddddeceedeaabbbbcbacdaeeebaabdabdbaebadcbdebaaeddcadebedeabbbcbeadbaacdebceebceeccddbeacdcecbcdbceedaeebdaeeabccccbcccbceabedaedaacdbbdbadcdbdddddcdebbcdbcabbebbeabbdccccbaaccbbcecacaebebecdcdcecdeaccccccdbbdebaaaaaaeaaeecdecedcbabedbabdedbaebeedcecebabedbceecacbdecabcebdcbecedccaeaaadbababdccedebeccecaddeabaebbeeccabeddedbeaadbcdceddceccecddbdbeeddabeddadaaaadbeedbeeeaaaeaadaebdacbdcaaabbacacccddbeaacebeeaabaadcabdbaadeaccaecbeaaabccddabbeacdecadebaecccbabeaceccaaeddedcaecddaacebcaecebebebadaceadcaccdeebbcdebcedaeaedacbeecceeebbdbdbaadeeecabdebbaaebdddeeddabcbaaebeabbbcaaeecddecbbbebecdbbbaecceeaabeeedcdecdcaeacabdcbcedcbbcaeeebaabdbaadcebbccbedbabeaddaecdbdbdccceeccaccbdcdadcccceebdabccaebcddaeeecddddacdbdbeebdabecdaeaadbadbebecbcacbbceeabbceecaabdcabebbcdecedbacbcccddcecccecbacddbeddbbbadcbdadbecceebddeacbeeabcdbbaabeabdbbbcaeeadddaeccbcdabceeabaacbeacdcbdceebeaebcceeebdcdcbeaaeeeadabbecdbadbebbecdceaeeecaaaedeceaddedbedbedbddbcbabeadddeccdaadaaeaeeadebbeabcabbdebabeedeeeccadcddaebbedadcdaebabbecedebadbdeacecdcaebcbdababcecaecbcbcdadacaebdedecaadbaaeeebcbeeedaaebbabbeeadadbacdedcbabdaabddccedbeacbecbcccdeaeeabcaeccdaaaddcdecadddabcaedccbdbbccecacbcdecbdcdcbabbeaacddaeeaabccebaaaebacebdcdcbbbdabadeebbdccabcacaacccccbadbdebecdaccabbecdabdbdaebeeadaeecbadedaebcaedeedcaacabaccbbdaccedaedddacbbbdbcaeedbcbecccdbdeddcdadacccdbcdccebdebeaeacecaaadccbbaaddbeebcbadceaebeccecabdadccddbbcbaebeaeadacaebcbbbdbcdaeadbcbdcedebabbaababaacedcbcbceaaabadbdcddadecdcebeeabaadceecaeccdeeabdbabebdcedceaeddaecedcdbccbbedbeecabaecdbba";
        System.out.println(longestDupSubstring(s));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
