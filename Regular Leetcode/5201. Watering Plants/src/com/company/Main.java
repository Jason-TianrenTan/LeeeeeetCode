package com.company;

public class Main {

    public int wateringPlants(int[] plants, int capacity) {
        int pos = 0;//start watering from here
        int water = capacity;
        int currentWalk = 0, totalWalk = 0;
        while (pos < plants.length) {
            currentWalk = 0;
            water = capacity;
            while (pos < plants.length && (water - plants[pos] >= 0)) {
                water -= plants[pos++];
                currentWalk++;
            }
            totalWalk += currentWalk;
            //no water left
            if (pos < plants.length) {
                totalWalk += 2 * pos;
            }
        }
        return totalWalk;
    }



    public void work() {
        int[] plants = {7};
        System.out.println(wateringPlants(plants, 8));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
