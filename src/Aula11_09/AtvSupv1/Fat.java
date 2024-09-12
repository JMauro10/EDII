package Aula11_09.AtvSupv1;
import java.util.Scanner;
public class Fat {
    // Método recursivo para calcular o fatorial
    public static int fatorial(int n) {
        if (n == 0) {
            return 1;  // Caso base: fatorial de 0 é 1
        } else {
            return n * fatorial(n - 1);  // Passo recursivo
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;  // Exemplo de número para calcular o fatorial
        System.out.println("Digite um numero: ");
        numero = scanner.nextInt();
        int resultado = fatorial(numero);
        System.out.println("O fatorial de " + numero + " é: " + resultado);
    }
}
