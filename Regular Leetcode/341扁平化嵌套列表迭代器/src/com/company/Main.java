package com.company;

import java.net.NetPermission;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Main {


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class TI implements NestedInteger {

        List<NestedInteger> list;
        int val;

        public TI(int val) {
            this.val = val;
        }

        public TI(List<NestedInteger> list) {
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return this.list == null;
        }

        @Override
        public Integer getInteger() {
            return this.val;
        }

        @Override
        public List<NestedInteger> getList() {
            return this.list;
        }
    }

    public class NestedIterator implements Iterator<Integer> {

        Stack<Iterator<NestedInteger>> stack;
        List<NestedInteger> list;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = nestedList;
            stack = new Stack<>();
            stack.push(list.iterator());
        }

        @Override
        public Integer next() {
            return stack.peek().next().getInteger();
        }

        @Override
        public boolean hasNext() {
            if (stack.empty())
                return false;
            while (!stack.empty()) {
                Iterator<NestedInteger> iter = stack.peek();
                if (!iter.hasNext()) {
                    stack.pop();
                    continue;
                }
                ;
                NestedInteger top = iter.next();
                if (top.isInteger()) {
                    List<NestedInteger> tempList = new ArrayList<>();
                    tempList.add(top);
                    stack.push(tempList.iterator());
                    return true;
                }
                stack.push(top.getList().iterator());
            }
            return false;
        }
    }

    public void work() {
        List<NestedInteger> test1 = new ArrayList<>(), test2 = new ArrayList<>();
        for (int i=0;i<5;i++)
            test1.add(new TI(i + 1));
        for (int i=10;i<12;i++)
            test2.add(new TI(i));
        List<NestedInteger> t = new ArrayList<>();
        t.add(new TI(test1));
        t.add(new TI(test2));
        NestedIterator iter = new NestedIterator(t);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
