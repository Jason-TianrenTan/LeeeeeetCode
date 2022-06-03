package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public void test() {

        List<Person> list = new ArrayList<>(Arrays.asList(new Person("name1", "a1"), new Person("name2", "a2")));
        Ex e = new Ex(list);
        e.printList();
        list.set(0, new Person("yg", "a4"));
        e.printList();
//        int[] vals = {3, 7, 9};
//        Ex e = new Ex(vals);
//        e.showData(); // prints out [3, 7, 9]
//        vals[0] = 13;
//        e.showData(); // prints out [3, 7, 9]
//        // Very confusing, because we didn't
//        // intentionally change anything about
//        // the object e refers to.
    }

    public static void main(String[] args) {
        new Main().test();
    }

    public class Person {

        String name, address;

        public Person(String name, String address) {
            this.name = name;
            this.address = address;
        }
    }

    public class Ex {
        private int[] data;
        private List<Person> list;

        public Ex(List<Person> list) {
            //deep copy
            this.list = new ArrayList<>(list);
            //shallow copy
            //this.list = list;
        }

        // Array deep copy
        public Ex(int[] values) {
            data = new int[values.length];
            for (int i = 0; i < values.length; i++)
                data[i] = values[i];
        }

        /**
         * Array shallow Copy
         * <p>
         * public Ex(int[] values) {
         * data = values;
         * }
         */

        public void showData() {
            System.out.println(Arrays.toString(data));
        }

        public void printList() {
            System.out.println("[");
            for (Person p : list)
                System.out.println("[" + p.name + ", " + p.address + "],");
            System.out.println("]");
        }
    }
}
