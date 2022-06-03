package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    Map<String, String> root;
    Map<String, Integer> rank;
    Map<String, Map<String, Double>> valuePairs;
    Map<String, Double> distToRoot;

    public String find(List<String> updatePath, String x) {
        if (updatePath == null) {
            updatePath = new ArrayList<>();
        }
        updatePath.add(x);
        distToRoot.put(x, 1.0);
        String xRoot = root.get(x);
        if (x == xRoot)
            return x;
        if (xRoot == null)
            return x;
        for (String pathElements : updatePath) {
            double updatedDistance = distToRoot.get(pathElements) * valuePairs.get(x).get(xRoot);
            distToRoot.put(pathElements, updatedDistance);
            valuePairs.get(pathElements).put(xRoot, updatedDistance);
        }

        root.put(x, find(updatePath, xRoot));
        return root.get(x);
    }

    public void union(String x, String y) {
        String ox = x, oy = y;
        x = find(null, x);
        y = find(null, y);
        if (rank.get(x) <= rank.get(y)) {
            root.put(x, y);
            valuePairs.get(x).put(y, valuePairs.get(ox).get(oy) * valuePairs.get(oy).get(y));
        }
        else {
            root.put(y, x);
            valuePairs.get(y).put(y, valuePairs.get(oy).get(ox) * valuePairs.get(ox).get(x));
        }
        if (rank.get(x) == rank.get(y) && x.equals(y))
            rank.put(y, rank.get(y) + 1);
    }

    private void checkExists(String y) {
        if (!rank.containsKey(y)) {
            rank.put(y, 0);
            root.put(y, y);
            valuePairs.put(y, new HashMap<>());
            valuePairs.get(y).put(y, 1.0);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        root = new HashMap<>();
        rank = new HashMap<>();
        valuePairs = new HashMap<>();
        distToRoot = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String u = equations.get(i).get(0), v = equations.get(i).get(1);
            checkExists(u);
            checkExists(v);
            valuePairs.get(u).put(v, values[i]);
            valuePairs.get(v).put(u, 1.0 / values[i]);
        }
        for (int i = 0; i < n; i++) {
            String u = equations.get(i).get(0), v = equations.get(i).get(1);
            union(u, v);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0), v = queries.get(i).get(1);
            if (!valuePairs.containsKey(u) || !valuePairs.containsKey(v))
                result[i] = -1;
            else {
                if (valuePairs.get(u).containsKey(v))
                    result[i] = valuePairs.get(u).get(v);
                else {
                    String rootU = find(null, u);
                    System.out.println("V");
                    String rootV = find(null, v);
                    if (rootU.equals(rootV)) {
                        result[i] = valuePairs.get(u).get(rootU) / valuePairs.get(v).get(rootV);
                    } else result[i] = -1;
                }
            }
        }

        return result;
    }

    public void work() {
        String[][] arr = {
                {"a", "b"},
                {"e1168. Optimize Water Distribution in a Village", "f"},
                {"b", "e"}
        };
        String[][] arr2 = {{"b", "a"}, {"a", "f"}};
        List<List<String>> equations = new ArrayList<>(), queries = new ArrayList<>();
        for (String[] eq : arr)
            equations.add(Arrays.stream(eq).collect(Collectors.toList()));
        for (String[] q : arr2)
            queries.add(Arrays.stream(q).collect(Collectors.toList()));
        double[] values = {3.4,1.4,2.3};
        double[] res = calcEquation(equations, values, queries);
        for (double d : res)
            System.out.println(d);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
