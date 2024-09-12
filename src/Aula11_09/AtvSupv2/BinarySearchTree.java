package Aula11_09.AtvSupv2;

class BinarySearchTree {
    Node raiz;

    // Método para inserir um novo nó
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private Node inserirRec(Node raiz, int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirRec(raiz.direita, valor);
        }

        return raiz;
    }

    // Método para deletar um nó
    public void deletar(int valor) {
        raiz = deletarRec(raiz, valor);
    }

    private Node deletarRec(Node raiz, int valor) {
        if (raiz == null) return raiz;

        if (valor < raiz.valor) {
            raiz.esquerda = deletarRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = deletarRec(raiz.direita, valor);
        } else {
            if (raiz.esquerda == null)
                return raiz.direita;
            else if (raiz.direita == null)
                return raiz.esquerda;

            raiz.valor = valorMinimo(raiz.direita);
            raiz.direita = deletarRec(raiz.direita, raiz.valor);
        }

        return raiz;
    }

    private int valorMinimo(Node raiz) {
        int minimo = raiz.valor;
        while (raiz.esquerda != null) {
            minimo = raiz.esquerda.valor;
            raiz = raiz.esquerda;
        }
        return minimo;
    }

    // Método para exibir a árvore em Pré-Ordem (Nó, Esquerda, Direita)
    public void exibirPreOrdem() {
        exibirPreOrdemRec(raiz);
        System.out.println();
    }

    private void exibirPreOrdemRec(Node node) {
        if (node != null) {
            System.out.print(node.valor + " ");
            exibirPreOrdemRec(node.esquerda);
            exibirPreOrdemRec(node.direita);
        }
    }
}
