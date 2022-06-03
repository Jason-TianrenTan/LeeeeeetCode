package com.company;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public String repeatLimitedString(String s, int repeatLimit) {
        TreeMap<Character, Integer> freqs = new TreeMap<>((o1, o2) -> -o1.compareTo(o2));
        for (int i = 0; i < s.length(); i++)
            freqs.put(s.charAt(i), freqs.getOrDefault(s.charAt(i), 0) + 1);
        StringBuilder sb = new StringBuilder();
        Character prev = null;
        while (freqs.size() > 0) {
            Iterator<Map.Entry<Character, Integer>> iter = freqs.entrySet().iterator();
            Map.Entry<Character, Integer> currentEntry = iter.next();
            char ch = currentEntry.getKey(), largest = ch;
            if (prev != null && ch == prev) {
                //get second large
                if (!iter.hasNext())
                    break;
                currentEntry = iter.next();
                ch = currentEntry.getKey();
            }
            int cnt = Math.min(currentEntry.getValue(), repeatLimit);
            if (prev != null && prev == largest)
                cnt = 1;
            for (int i = 0; i < cnt; i++)
                sb.append(ch);
            freqs.put(ch, freqs.get(ch) - cnt);
            if (freqs.get(ch) == 0)
                freqs.remove(ch);
            prev = ch;
        }
        return sb.toString();
    }

    public void work() {
        System.out.println(repeatLimitedString("zzcccac", 7));
    }
    public static void main(String[] args) {
        new Main().work();
    }
}
