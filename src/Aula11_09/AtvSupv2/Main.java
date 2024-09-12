package Aula11_09.AtvSupv2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree arvore = new BinarySearchTree();

        // Inserção de nós um a um
        System.out.println("Insira os valores para a árvore (digite '0' para finalizar):");
        int valor;
        while (true) {
            System.out.print("Digite um valor: ");
            valor = scanner.nextInt();
            if (valor == 0) break; // Condição para parar a inserção
            arvore.inserir(valor);
        }

        // Exibição da árvore em Pré-Ordem após inserção
        System.out.println("Árvore em Pré-Ordem após a inserção dos nós:");
        arvore.exibirPreOrdem();

        // Perguntar ao usuário se deseja deletar um nó
        System.out.println("Deseja deletar um nó da árvore? (s/n):");
        String opcao = scanner.next();

        while (opcao.equalsIgnoreCase("s")) {
            System.out.print("Digite o valor a ser deletado: ");
            int valorDeletar = scanner.nextInt();
            arvore.deletar(valorDeletar);

            System.out.println("Árvore em Pré-Ordem após deletar o nó " + valorDeletar + ":");
            arvore.exibirPreOrdem();

            System.out.println("Deseja deletar outro nó? (s/n):");
            opcao = scanner.next();
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
