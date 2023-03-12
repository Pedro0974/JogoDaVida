package edu.pedraoMaycaoVictao.trabalhoFinal;

import java.util.Random;

public class JogoDaVida {
	private int size;
	private boolean[][] borda;

	// contrutor jogo
	public JogoDaVida(int size) {
		this.size = size;
		this.borda = new boolean[size][size];
	}

	// o método inicializa a matriz bidimensional com valores booleanos aleatórios.
	public void initialize() {
		Random random = new Random();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				borda[i][j] = random.nextBoolean();
			}
		}
	}

	// o método atualiza o estado da matriz bidimensional com base nas regras do
	// jogo da vida.
	// Ele cria uma nova matriz bidimensional, aplica as regras do jogo e, em
	// seguida, atualiza a matriz
	// original com os novos valores.
	public void update() {
		boolean[][] newBorda = new boolean[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int count = countVizinhos(i, j);

				if (borda[i][j]) {
					if (count < 2 || count > 3) {
						newBorda[i][j] = false;
					} else {
						newBorda[i][j] = true;
					}
				} else {
					if (count == 3) {
						newBorda[i][j] = true;
					} else {
						newBorda[i][j] = false;
					}
				}
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				borda[i][j] = newBorda[i][j];
			}
		}
	}

	// o método conta o número de células vizinhas para uma célula específica na
	// posição (x, y).
	int countVizinhos(int x, int y) {
		int count = 0;

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0) {
					continue;
				}

				int row = (x + i + size) % size;
				int col = (y + j + size) % size;

				if (borda[row][col]) {
					count++;
				}
			}
		}

		return count;
	}

	// o método exibe a matriz bidimensional na tela em um formato legível para o
	// usuário e solicita que o usuário
	// pressione 'S' para continuar ou 'N' para sair.
	public void display() {
		System.out.println("_ " + "_ ".repeat(size) + "_");

		for (int i = 0; i < size; i++) {
			System.out.print("| ");

			for (int j = 0; j < size; j++) {
				if (borda[i][j]) {
					System.out.print("* ");
				} else {
					System.out.print(". ");
				}
			}

			System.out.println(" |");
		}

		System.out.println("- " + "- ".repeat(size) + "- " + "");
		System.out.print("Pressione 'S' para continuar ou digite 'N' para sair: \n");
	}

	// retorna o array borda da instância atual da classe JogoDaVida, que foi
	// inicializado no construtor
	// e é atualizado no método update().
	public boolean[][] getBorda() {
		return this.borda;
	}
}
