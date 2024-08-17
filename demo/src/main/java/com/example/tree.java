package com.example;

public class tree {

    private Node raiz;

    public tree() {
        this.raiz = null;
    }

    public Node getRaiz() {
        return raiz;
    }

    public void add(int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
        } else {
            addRecursivo(raiz, valor);
        }
    }

    private void addRecursivo(Node atual, int valor) {
        if (valor < atual.getValor()) {
            if (atual.getLeft() == null) {
                atual.setLeft(new Node(valor));
            } else {
                addRecursivo(atual.getLeft(), valor);
            }
        } else {
            if (atual.getRight() == null) {
                atual.setRight(new Node(valor));
            } else {
                addRecursivo(atual.getRight(), valor);
            }
        }
    }


    public void removeLast() {
        if (raiz.getRight() == null ) {
            raiz = null;
            return;
        }
        removeLast(raiz.getRight(), raiz);
    }

    private void removeLast(Node Node, Node anterior) {
        if(Node.getRight() == null) {
            if (Node.getLeft() == null) {
                anterior.setRight(null);
                return;
            }
            anterior.setRight(Node.getLeft());
            return;
        }
        removeLast(Node.getRight(), anterior.getRight());
    }

    public void removeFirst() {
        if (raiz == null) {
            System.out.println("A árvore não possui elementos, está vazia.");
            return;
        }
        if (raiz.getLeft() == null) {
            raiz = null;
            return;
        }
        removeFirst(raiz.getLeft(), raiz);
    }

    private void removeFirst(Node Node, Node anterior) {
        if (Node.getLeft() == null) {
            if (Node.getRight() == null) {
                anterior.setLeft(null);
            } else {
                anterior.setLeft(Node.getRight());
            }
        } else {
            removeFirst(Node.getLeft(), Node);
        }
    }

    public boolean search(int valor) {
        return search(raiz, valor);
    }

    private boolean search(Node Node, int valor) {
        if (Node == null) {
            return false;
        }
        if (Node.getValor() == valor) {
            return true;
        }
        if (valor < Node.getValor()) {
            return search(Node.getLeft(), valor);
        } else {
            return search(Node.getRight(), valor);
        }
    }

    public void preOrderRec() {
        preOrder(raiz);
    }

    private void preOrder(Node raiz) {
        if (raiz != null) {
            System.out.println(raiz.getValor() + " ");
            preOrder(raiz.getLeft());
            preOrder(raiz.getRight());
        }
    }

    public void recOrder() {
        order(raiz);
    }

    private void order(Node raiz) {
        if (raiz != null) {
            order(raiz.getLeft());
            System.out.println(raiz.getValor());
            order(raiz.getRight());
        }
    }

    public void postOrder() {
        postOrder(raiz);
    }

    private void postOrder(Node raiz) {
        if (raiz != null) {
            postOrder(raiz.getLeft());
            postOrder(raiz.getRight());
            System.out.println(raiz.getValor());
        }
    }
 
    public void printTree() {
        printTree(raiz);
    }

    private void printTree(Node atual) {
        if (atual != null) {
            System.out.println("Nó: " + atual.getValor());

            if (atual.getLeft() != null) {
                System.out.println("left: " + atual.getLeft().getValor());
            } else {
                System.out.println("left: Nenhum");
            }

            if (atual.getRight() != null) {
                System.out.println("direita: " + atual.getRight().getValor());
            } else {
                System.out.println("direita: Nenhum");
            }
            printTree(atual.getLeft());
            printTree(atual.getRight());
        }
    }
}