package edu.pedroMayconVictorA.trabalho;

import java.util.Scanner;

public class Main { // declaração da classe pública "Main"

    public static void main(String[] args) { // declaração do método principal "main" que recebe um array de argumentos em forma de string
        Scanner scan = new Scanner(System.in); // criação de um objeto Scanner para ler entradas do usuário

        System.out.print("Digite o tamanho do tabuleiro: "); // imprime a mensagem "Digite o tamanho do tabuleiro: " no console

        int size = scan.nextInt(); // lê o número digitado pelo usuário e armazena na variável "size" de tipo inteiro
        scan.nextLine(); // consome a quebra de linha deixada pelo nextInt() para que a próxima chamada de nextLine() não seja afetada

        JogoDaVida game = new JogoDaVida(size); // criação de um objeto do tipo JogoDaVida, que é uma classe que representa o jogo

        if (size > 1) { // testa se o tamanho do tabuleiro é maior que 1
            game.initialize(); // inicializa o jogo
            game.display(); // mostra o tabuleiro do jogo

            while (true) { // inicia um loop infinito
                String input = scan.nextLine(); // lê a entrada do usuário e armazena na variável "input" de tipo String

                if (input.equalsIgnoreCase("s")) { // testa se a entrada do usuário é "s" (ou "S", ignorando letras maiúsculas ou minúsculas)
                    game.display(); // mostra o tabuleiro do jogo
                    game.update(); // atualiza o estado do jogo
                } else if (input.equalsIgnoreCase("n")) { // testa se a entrada do usuário é "n" (ou "N", ignorando letras maiúsculas ou minúsculas)
                    System.out.println("Você Encerrou Sua Vida!"); // mostra a mensagem "Você Encerrou Sua Vida!"
                    break; // encerra o loop
                } else { // mostra a mensagem "Opção inválida. Digite S ou N." se a entrada do usuário não for "s" ou "n"
                    System.out.println("Opção inválida. Digite S ou N.");
                }
            }
        }
    }
}
