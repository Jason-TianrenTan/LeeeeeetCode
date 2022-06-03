package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private int getLength(ListNode head) {
        ListNode current = head;
        int total = 0;
        while (current != null) {
            current = current.next;
            total++;
        }
        return total;
    }

    //Special case for last group
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int groupNo = 0;
        ListNode current = head;
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        int length = getLength(head), pt = 0;
        while (current != null) {
            groupNo++;
            int nodesLeft = length - pt;
            groupNo = Math.min(groupNo, nodesLeft);
            if (groupNo % 2 == 0) {
                ListNode start = prev, last = null;
                //prev -> current -> curNext -> finish
                for (int i = 0; i < groupNo; i++) {
                    ListNode curNext = current.next;
                    current.next = prev;
                    if (i == 0)
                        last = current;
                    prev = current;
                    current = curNext;

                }
                start.next = prev;
                last.next = current;
                prev = last;
            } else {
                for (int i = 0; i < groupNo; i++) {
                    prev = current;
                    current = current.next;
                }
            }
            pt += groupNo;
        }
        return dummy.next;
    }


//    public ListNode reverseEvenLengthGroups(ListNode head) {
//        List<Integer> numbers = new ArrayList<>();
//        ListNode current = head;
//        while (current != null) {
//            numbers.add(current.val);
//            current = current.next;
//        }
//        int group = 0;
//        int pt = 0;
//        while (pt < numbers.size()) {
//            group++;
//            int st = pt, ed = pt + group - 1;
//            ed = ed >= numbers.size() ? numbers.size() - 1 : ed;
//            int counts = ed - st + 1;
//            if (counts % 2 == 0) {
//                int i = st, j = ed;
//                while (i < j) {
//                    //swap i with ed + st - i
//                    int temp = numbers.get(j);
//                    numbers.set(j, numbers.get(i));
//                    numbers.set(i, temp);
//                    i++;
//                    j--;
//                }
//            }
//            pt += group;
//        }
//
//        ListNode dummy = new ListNode(-1);
//        ListNode cur = dummy;
//        for (int i : numbers) {
//            ListNode temp = new ListNode(i);
//            cur.next = temp;
//            cur = cur.next;
//        }
//        return dummy.next;
//    }

    void print(ListNode res) {
        ListNode cur = res;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public void work() {

        int[] nums = {1, 2, 3, 4, 5, 7, 9, 10};
        ListNode head = new ListNode(-1);
        ListNode current = head;
        for (int i : nums) {
            ListNode temp = new ListNode(i);
            current.next = temp;
            current = current.next;
        }

        ListNode res = reverseEvenLengthGroups(head.next);
        print(res);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
