package edu.pedroMayconVictorA.trabalho;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o tamanho do tabuleiro: ");
		int size = scan.nextInt();
		JogoDaVida game = new JogoDaVida(size);
		if (size > 1) {
			game.initialize();
			game.display();
			while (true) {
				//test
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("s")) {
					game.display();
					game.update();
				}
				if (input.equalsIgnoreCase("n")) {
					System.out.println("Você Encerrou Sua Vida!");
					break;
				}
			}

		}
	}
}
