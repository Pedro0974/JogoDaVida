package edu.pedroMayconVictorA.trabalho;

import java.util.Random;

public class JogoDaVida {
	//test

    private int size;
    private boolean[][] borda;

    //contrutor do tabuleiro
    public JogoDaVida(int size) {
        this.size = size;
        this.borda = new boolean[size][size];
    }

    //inicializador do tabuleiro
    public void initialize() {
        Random random = new Random();
        // estrutura de repeticao pra criar as celulas com valores logicos
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                borda[i][j] = random.nextBoolean();
            }
        }
    }

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

        borda = newBorda;
    }

    private int countVizinhos(int x, int y) {
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
}