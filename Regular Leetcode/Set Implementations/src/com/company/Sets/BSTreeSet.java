package com.company.Sets;

import com.company.Utils.BSTree;
import com.company.Utils.DataStructureSet;

public class BSTreeSet extends DataStructureSet {

    BSTree tree;

    //public void traverse() {this.tree.traverse();}
    public BSTreeSet() { this.tree = new BSTree(); }

    @Override
    public boolean add(String word) {
        return tree.insertNode(word);
    }

    @Override
    public boolean contains(String word) {
        return tree.contains(word);
    }

    @Override
    public int size() {
        return tree.size();
    }
}
