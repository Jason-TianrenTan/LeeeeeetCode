package com.company;

public class Main {

    class ParkingSystem {

        int big, medium, small;
        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1:
                    if (big > 0) {
                        big--;
                        return true;
                    }
                    return false;
                case 2:
                    if (medium > 0) {
                        medium--;
                        return true;
                    }
                    return false;
                case 3:
                    if (small > 0) {
                        small--;
                        return true;
                    }
                    return false;
                default:return false;
            }
        }
    }

    public void work() {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1)); // 返回 true ，因为有 1 个空的大车位
        System.out.println(parkingSystem.addCar(2)); // 返回 true ，因为有 1 个空的中车位
        System.out.println(parkingSystem.addCar(3)); // 返回 false ，因为没有空的小车位
        System.out.println(parkingSystem.addCar(1)); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
