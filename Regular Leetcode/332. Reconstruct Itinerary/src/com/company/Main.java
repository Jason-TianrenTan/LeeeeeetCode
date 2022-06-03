package com.company;

import java.util.*;

public class Main {

    Map<String, Map<String, Integer>> edges;
    boolean found = false;
    int flights;
    public List<String> findItinerary(List<List<String>> tickets) {
        edges = new TreeMap<>();
        flights = tickets.size();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            edges.putIfAbsent(from, new TreeMap<>());
            edges.get(from).putIfAbsent(to, 0);
            edges.get(from).put(to, edges.get(from).get(to) + 1);//unvisited
        }
        String start = "JFK";
        List<String> seq = new ArrayList<>();
        seq.add(start);
        dfs(start, seq);
        return seq;
    }

    public void dfs(String current, List<String> seq) {
        Map<String, Integer> adj = edges.getOrDefault(current, null);
        if (adj != null) {
            for (Map.Entry<String, Integer> entry : adj.entrySet()) {
                String target = entry.getKey();
                int visited = entry.getValue();
                if (visited > 0) {
                    adj.put(target, visited - 1);
                    seq.add(target);
                    if (seq.size() == flights + 1) {
                        found = true;
                        return;
                    }
                    dfs(target, seq);
                    if (!found) {
                        adj.put(target, visited);
                        seq.remove(seq.size() - 1);
                    }
                }
            }
        }
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
