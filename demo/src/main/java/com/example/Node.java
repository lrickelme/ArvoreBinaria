package com.example;

public class Node {
    
    private int valor;
    Node left;
    private Node right;


    public Node(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
    
    public void setRight(Node right) {
        this.right = right;
    }
}
