package edu.pedroMayconVictorA.trabalho;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o tamanho do tabuleiro: ");
		//le o o numero
		int size = scan.nextInt();
		scan.nextLine(); // consumir a quebra de linha deixada pelo nextInt()
		JogoDaVida game = new JogoDaVida(size);
		if (size > 1) {
			game.initialize();
			game.display();

			while (true) {
				String input = scan.nextLine();

				if (input.equalsIgnoreCase("s")) {
					game.display();
					game.update();
				} else if (input.equalsIgnoreCase("n")) {
					System.out.println("Você Encerrou Sua Vida!");
					break;
				} else {
					System.out.println("Opção inválida. Digite S ou N.");
				}
			}
		}
	}
}
