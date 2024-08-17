package com.example;

public class Main {
    public static void main(String[] args) {
        tree tree = new tree();
        tree.add(0);
        tree.add(17);
        tree.add(85);
        tree.add(35);
        tree.add(1);
        tree.add(7);
        tree.add(9);
        tree.add(13);
        tree.add(55);
        tree.add(99);
        printer.printTree(tree);
        tree.postOrder();
        tree.preOrderRec();
    }
}
