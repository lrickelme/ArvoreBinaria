package com.example;

public class AVLTree {
    private Node raiz;

    public int altura(Node N) {
        if (N == null) {
            return 0;
        }
        return N.getAltura();
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node rotacaoDireita(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setAltura(max(altura(y.getLeft()), altura(y.getRight())) + 1);
        x.setAltura(max(altura(x.getLeft()), altura(x.getRight())) + 1);

        return x;
    }

    private Node rotacaoEsquerda(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setAltura(max(altura(x.getLeft()), altura(x.getRight())) + 1);
        y.setAltura(max(altura(y.getLeft()), altura(y.getRight())) + 1);

        return y;
    }

    private int getBalance(Node N) {
        if (N == null) {
            return 0;
        }
        return altura(N.getLeft()) - altura(N.getRight());
    }

    public void add(int valor) {
        raiz = addRecursivo(raiz, valor);
    }

    private Node addRecursivo(Node node, int valor) {
        if (node == null) {
            return new Node(valor);
        }

        if (valor < node.getValor()) {
            node.setLeft(addRecursivo(node.getLeft(), valor));
        } else if (valor > node.getValor()) {
            node.setRight(addRecursivo(node.getRight(), valor));
        } else {
            return node;
        }

        node.setAltura(1 + max(altura(node.getLeft()), altura(node.getRight())));

        int balance = getBalance(node);

        if (balance > 1 && valor < node.getLeft().getValor()) {
            return rotacaoDireita(node);
        }

        if (balance < -1 && valor > node.getRight().getValor()) {
            return rotacaoEsquerda(node);
        }

        if (balance > 1 && valor > node.getLeft().getValor()) {
            node.setLeft(rotacaoEsquerda(node.getLeft()));
            return rotacaoDireita(node);
        }

        if (balance < -1 && valor < node.getRight().getValor()) {
            node.setRight(rotacaoDireita(node.getRight()));
            return rotacaoEsquerda(node);
        }
        return node;
    }

    public void remove(int valor) {
        raiz = removeRecursivo(raiz, valor);
    }

    private Node removeRecursivo(Node root, int valor) {
        if (root == null) {
            return root;
        }

        if (valor < root.getValor()) {
            root.setLeft(removeRecursivo(root.getLeft(), valor));
        } else if (valor > root.getValor()) {
            root.setRight(removeRecursivo(root.getRight(), valor));
        } else {
            if ((root.getLeft() == null) || (root.getRight() == null)) {
                Node temp = null;
                if (temp == root.getLeft()) {
                    temp = root.getRight();
                } else {
                    temp = root.getLeft();
                }

                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = minValorNode(root.getRight());

                root.setValor(temp.getValor());

                root.setRight(removeRecursivo(root.getRight(), temp.getValor()));
            }
        }

        if (root == null) {
            return root;
        }

        root.setAltura(max(altura(root.getLeft()), altura(root.getRight())) + 1);

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.getLeft()) >= 0) {
            return rotacaoDireita(root);
        }

        if (balance > 1 && getBalance(root.getLeft()) < 0) {
            root.setLeft(rotacaoEsquerda(root.getLeft()));
            return rotacaoDireita(root);
        }

        if (balance < -1 && getBalance(root.getRight()) <= 0) {
            return rotacaoEsquerda(root);
        }

        if (balance < -1 && getBalance(root.getRight()) > 0) {
            root.setRight(rotacaoDireita(root.getRight()));
            return rotacaoEsquerda(root);
        }

        return root;
    }

    private Node minValorNode(Node node) {
        Node current = node;

        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        return current;
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

    public void printTree() {
        printTree(raiz, "", true);
    }

    private void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R---- ");
                indent += "   ";
            } else {
                System.out.print("L---- ");
                indent += "|  ";
            }
            System.out.println(node.getValor());
            printTree(node.getLeft(), indent, false);
            printTree(node.getRight(), indent, true);
        }
    }
}
