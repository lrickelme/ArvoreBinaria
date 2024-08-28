package com.example;

public class Main {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        avlTree.add(10);
        avlTree.add(20);
        avlTree.add(30);
        avlTree.add(40);
        avlTree.add(50);
        avlTree.add(25);

        System.out.println("Árvore AVL após inserções:");
        avlTree.printTree();

        avlTree.remove(40);

        System.out.println("\nÁrvore AVL após remoção do valor 40:");
        avlTree.printTree();
    }
}
