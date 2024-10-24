package Aula23_10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo {
    // Lista de adjacência
    private List<List<Integer>> adjList;

    // Construtor: inicializa o grafo com um número de vértices
    public Grafo(int vertices) {
        adjList = new ArrayList<>(vertices);
        
        // Inicializa cada lista de adjacência para cada vértice
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Adiciona uma aresta entre dois vértices origem/destino (não direcionado)
    public void addAresta(int origem, int destino) {
        adjList.get(origem).add(destino);
        adjList.get(destino).add(origem);  // Porque o grafo não é direcionado
    }

    // Exibe o grafo
    public void exibirGrafo() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Vértice " + i + ":");
            for (int vizinho : adjList.get(i)) {
                System.out.print(" -> " + vizinho);
            }
            System.out.println();
        }
    }

    // Conta o grau do vertice especifico 
    public Integer grauVertice(int vertice){
        return adjList.get(vertice).size();
    }

    public List<Integer> encontrarCaminho(int origem, int destino) {
        boolean[] visitado = new boolean[adjList.size()];
        int[] anterior = new int[adjList.size()];
        
        // Inicializando todos os nós como não visitados e sem antecessor
        for (int i = 0; i < adjList.size(); i++) {
            anterior[i] = -1;
        }

        // Fila para BFS
        Queue<Integer> fila = new LinkedList<>();
        fila.add(origem);
        visitado[origem] = true;

        // BFS para encontrar o caminho
        while (!fila.isEmpty()) {
            int atual = fila.poll();

            if (atual == destino) {
                break;  // Chegou ao destino
            }

            for (int vizinho : adjList.get(atual)) {
                if (!visitado[vizinho]) {
                    fila.add(vizinho);
                    visitado[vizinho] = true;
                    anterior[vizinho] = atual;
                }
            }
        }

        // Reconstruindo o caminho a partir do vetor "anterior"
        List<Integer> caminho = new ArrayList<>();
        for (int v = destino; v != -1; v = anterior[v]) {
            caminho.add(0, v);  // Adiciona no início para construir o caminho na ordem correta
        }

        // Se o primeiro elemento não for a origem, significa que não há caminho
        if (caminho.get(0) != origem) {
            return new ArrayList<>();  // Caminho não encontrado
        }

        return caminho;
    }



    public static void main(String[] args) {
        // Exemplo com 5 vértices
        Grafo grafo = new Grafo(5);

        // Adiciona arestas
        grafo.addAresta(0, 1);
        grafo.addAresta(0, 4);
        grafo.addAresta(1, 2);
        grafo.addAresta(1, 3);
        grafo.addAresta(1, 4);
        grafo.addAresta(2, 3);
        grafo.addAresta(3, 4);

        // Exibe o grafo
        grafo.exibirGrafo();

        System.out.println();

        // Exibe o grau de cada vértice
        System.out.println("O grau do vertice 0 é: " + grafo.grauVertice(0));
        System.out.println("O grau do vertice 1 é: " + grafo.grauVertice(1));
        System.out.println("O grau do vertice 2 é: " + grafo.grauVertice(2));
        System.out.println("O grau do vertice 3 é: " + grafo.grauVertice(3));
        System.out.println("O grau do vertice 4 é: " + grafo.grauVertice(4));

        System.out.println();

        // Encontrar caminho entre dois vértices
        int origem = 0;
        int destino = 3;
        List<Integer> caminho = grafo.encontrarCaminho(origem, destino);
        
        if (caminho.isEmpty()) {
            System.out.println("Não há caminho entre " + origem + " e " + destino);
        } else {
            System.out.println("Caminho entre " + origem + " e " + destino + ": " + caminho);
        }
    }
}