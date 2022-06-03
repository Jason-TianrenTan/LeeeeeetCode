package com.company.Sets;
import com.company.Utils.*;
public class LinkedListSet extends DataStructureSet{

    LinkedList innerList;
    int size = 0;
    public LinkedListSet() {
        innerList = new LinkedList();
    }

    @Override
    public boolean add(String word) {
        if (!this.contains(word)) {
            innerList.add(word);
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(String word) {
        //Traverse Linked List
        LinkedList.ListNode head = innerList.getHead();
        while (head != null) {
            if (word.equals(head.getVal()))
                return true;
            head = head.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
}
