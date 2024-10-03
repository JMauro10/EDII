package AvaliacaoN1Aula02_10;

public class ArvoreBinaria {
    Node raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    // Método para contar o número de nós da árvore
    public int contarNos(Node nodo) {
        if (nodo == null) {
            return 0;
        }

        // Conta o nó atual + os nós da subárvore esquerda + os nós da subárvore direita
        return 1 + contarNos(nodo.esquerda) + contarNos(nodo.direita);
    }


    // Método para contar o número de nós folha
    public int contarNosFolha(Node nodo) {
        if (nodo == null) {
            return 0;
        }

        // Se o nó não tem filhos, é uma folha
        if (nodo.esquerda == null && nodo.direita == null) {
            return 1;
        }

        // Soma os nós folha das subárvores esquerda e direita
        return contarNosFolha(nodo.esquerda) + contarNosFolha(nodo.direita);
    }

    // Método para contar o número de nós não folha (com pelo menos um filho)
    public int contarNosNaoFolha(Node nodo) {
        if (nodo == null) {
            return 0;
        }

        // Se o nó tem pelo menos um filho, conta como nó não folha
        if (nodo.esquerda != null || nodo.direita != null) {
            return 1 + contarNosNaoFolha(nodo.esquerda) + contarNosNaoFolha(nodo.direita);
        }

        // Caso contrário, não conta o nó (ele é folha)
        return 0;
    }

    // Método para calcular o grau de um nó (quantos filhos ele possui)
    private int calcularGrau(Node nodo) {
        if (nodo == null) {
            return 0;
        }

        int grau = 0;

        if (nodo.esquerda != null) {
            grau++;
        }

        if (nodo.direita != null) {
            grau++;
        }

        return grau;
    }

    // Método para calcular o grau máximo da árvore binária (o maior número de filhos de qualquer nó)
    public int grauMaximo(Node nodo) {
        if (nodo == null) {
            return 0;
        }

        // Grau do nó atual
        int grauAtual = calcularGrau(nodo);

        // Grau máximo da subárvore esquerda e direita
        int grauEsquerda = grauMaximo(nodo.esquerda);
        int grauDireita = grauMaximo(nodo.direita);

        // Retorna o maior grau encontrado
        return Math.max(grauAtual, Math.max(grauEsquerda, grauDireita));
    }

    // Método para obter o número de nós, a partir da raiz
    public int tamanho() {
        return contarNos(raiz);
    }

    // Método para obter o número de nós folha, a partir da raiz
    public int contarFolhas() {
        return contarNosFolha(raiz);
    }

    // Método para obter o número de nós não folha
    public int contarNaoFolhas() {
        return contarNosNaoFolha(raiz);
    }

    // Método para obter o grau máximo a partir da raiz
    public int obterGrauMaximo() {
        return grauMaximo(raiz);
    }
}

