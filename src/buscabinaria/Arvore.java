package buscabinaria;

public class Arvore {

    int tamanho;
    Node root;

    Arvore() {
        this.tamanho = 0;
        this.root = null;
    }

    Node inserir(Node root, int numero) {
        if (root == null) {
            root = new Node();
            root.info = numero;
        } else {
            if (numero < root.info) {
                root.e = inserir(root.e, numero);
            } else {
                root.d = inserir(root.d, numero);
            }
        }
        return root;
    }
    
    Node remover(Node root, int numero) {
        if (root == null) {
            return null;
        } else {
            if (numero == root.info) {                
                if (root.e == null) {
                    return root.d;
                } else {
                    Node p;
                    if (root.d == null) {
                        return root.e;
                    } else {
                        p = maximo(root.e);
                        root.e = remover(root.e, p.info);
                        return root;
                    }
                }
            } else {
                if (numero < root.info) {
                    root.e = remover(root.e, numero);
                } else {
                    root.d = remover(root.d, numero);
                }
                return root;
            }
        }

    }
    
    Node buscar(Node root, int elemento) {
        if (root == null) { // Se árvore vazia
            return null; // Retorna nulo
        } else {
            if (elemento == root.info) { // Se atual for igual ao elemento
                return root;
            } else {
                if (elemento < root.info) { // Verifica se o valor procurado é menor que o valor do nó atual
                    return this.buscar(root.e, elemento);
                } else {
                    return this.buscar(root.d, elemento);
                }
            }
        }
    }

    Node maximo(Node root) {
        if (root.d == null) {
            return root;
        } else {
            return this.maximo(root.d);
        }
    }

    Node minimo(Node root) {
        if (root.e == null) {
            return root;
        } else {
            return this.minimo(root.e);
        }
    }

    // R E D
    void preOrdem(Node root) {
        if (root != null) {
            System.out.print(root.info + " ");
            this.preOrdem(root.d);
            this.preOrdem(root.e);
        }
    }

    //E R D
    void emOrdem(Node root) {
        if (root != null) {
            this.emOrdem(root.e);
            System.out.print(root.info + " ");
            this.emOrdem(root.d);
        }
    }

    // E D R
    void posOrdem(Node root) {
        if (root != null) {
            this.posOrdem(root.e);
            this.posOrdem(root.d);
            System.out.println(root.info + " ");
        }
    }
}
