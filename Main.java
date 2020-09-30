package life;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sizeOfUniverse = sc.nextInt();
        int seed = sc.nextInt();
        int generations = sc.nextInt();
        int[][] currentGeneration;
        int[][] nextGeneration;

        currentGeneration = generationAlgorithm.newGeneration(sizeOfUniverse, seed);
        if (generations == 0) {
            currentGeneration = generationAlgorithm.newGeneration(sizeOfUniverse, seed);
        } else {
            for (int i = 0; i < generations; i++) {
                nextGeneration = generationAlgorithm.countPopulation(currentGeneration);
                nextGeneration = stateOfTheUniverse.equalOldAndNewGen(nextGeneration, currentGeneration);
                currentGeneration = nextGeneration;
            }
        }
        printUniverse(currentGeneration);
    }

    static void printUniverse(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (ints[j] == 1) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

class stateOfTheUniverse {
    static int[][] equalOldAndNewGen(int[][] next, int[][] current) {
        int size = next.length;
        int[][] nextGen = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (current[i][j] == 0 && next[i][j] == 3) {
                    nextGen[i][j] = 1;
                } else if (current[i][j] == 1 && next[i][j] == 2 || next[i][j] == 3){
                    nextGen[i][j] = 1;
                } else {
                    nextGen[i][j] = 0;
                }
            }
        }
        return nextGen;
    }
}

class generationAlgorithm {
    static int[][] newGeneration(int size, int seed) {
        Random random = new Random(seed);
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = random.nextBoolean() ? 1 : 0;
            }
        }
        return arr;
    }

    static int[][] countPopulation(int[][] current) {
        int n = current.length;
        int[][] next = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = current[i][(j + 1) % n] + current[i][(j + n - 1) % n] //horizontal cell
                        + current[(i + n - 1) % n][j] + current[(i + 1) % n][j] //vertical cell
                        + current[(i + 1) % n][(j + 1) % n] + current[(i + 1) % n][(j + n - 1) % n] //diagonal bottom
                        + current[(i + n - 1) % n][(j + 1) % n] + current[(i + n - 1) % n][(j + n - 1) % n]; //diagonal top
            }
        }
        return next;
    }
}
