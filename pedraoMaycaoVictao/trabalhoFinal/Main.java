package edu.pedraoMaycaoVictao.trabalhoFinal;

import java.util.Scanner;

public class Main {

	// o método principal do programa, cria uma instância da classe JogoDaVida,
	// inicializa a matriz bidimensional e
	// exibe a matriz inicial. Em seguida, ele entra em um loop e espera que o
	// usuário pressione 'S' para atualizar a matriz
	// ou 'N' para sair. Quando o usuário escolhe 'N', o programa é encerrado.
	// Depois disso, ele executa um loop novamente para
	// verificar se há células com mais de três vizinhos e as mata. Finalmente,
	// exibe a matriz final.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int size = 0;
		while (size <= 1) {
			System.out.print("Digite o tamanho do tabuleiro (maior que 1): ");

			size = scan.nextInt();
			scan.nextLine();
		}

		JogoDaVida game = new JogoDaVida(size);
		game.initialize();
		game.display();

		while (true) {
			String input = scan.nextLine();

			if (input.equalsIgnoreCase("s")) {
				game.update();
				// Matar células com mais de três vizinhos
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						int count = game.countVizinhos(i, j);

						if (game.getBorda()[i][j] && count > 3) {
							game.getBorda()[i][j] = false;
						}
					}
				}
				// Mostrar o tabuleiro final após matar células com mais de três vizinhos
				game.display();
			} else if (input.equalsIgnoreCase("n")) {
				System.out.println("Você Encerrou Sua Vida!");
				break;
			} else {
				System.out.println("Opção inválida. Digite S ou N.");

			}
		}

	}
}
