package AvaliacaoN1Aula02_10;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        // Inserção manual de nós na árvore
        arvore.raiz = new Node(10);
        arvore.raiz.esquerda = new Node(5);
        arvore.raiz.direita = new Node(15);
        arvore.raiz.esquerda.esquerda = new Node(3);
        arvore.raiz.esquerda.direita = new Node(7);
        arvore.raiz.direita.esquerda = new Node(13);
        arvore.raiz.direita.direita = new Node(17);

        // Exibir o tamanho da árvore
        System.out.println("O número de nós na árvore é: " + arvore.tamanho());

        // Exibir o número de nós folha
        System.out.println("O número de nós folha na árvore é: " + arvore.contarFolhas());

        // Exibir o número de nós não folha
        System.out.println("O número de nós não folha na árvore é: " + arvore.contarNaoFolhas());

        // Exibir o grau máximo da árvore
        System.out.println("O grau máximo da árvore é: " + arvore.obterGrauMaximo());
    }
}
