package ProjectII;

import java.util.ArrayList;

public class State {

    private ArrayList<String> words;
    private char[][] matrix;

    public State(char[][] matrix, ArrayList<String> words) {
        this.words = words;
        this.matrix = matrix;
    }

    //add word to the matrix
    public boolean addWord(int x, int y, char dir, String word) {

        //the direction of the word
        if (dir == 'h') {

            //if not on the beginning 
            //of the line return false
            if (y != 0) {
                return false;
            }

            //verify if fits
            boolean fits = true;

            for (int i = 0; i < matrix[x].length; i++) {
                if (matrix[x][i] == '#' || (matrix[x][i] != '-' && matrix[x][i] != word.charAt(i))) {
                    fits = false;
                    return false;
                }
            }

            //if fits add
            if (fits) {
                for (int j = 0; j < matrix[x].length; j++) {
                    matrix[x][j] = word.charAt(j);
                }
                return true;
            }
        }

        //the direction of the word
        if (dir == 'v') {
            if (x != 0) {
                return false;
            }

            //verify if fits
            boolean fits = true;

            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][y] == '#' || (matrix[i][y] != '-' && matrix[i][y] != word.charAt(i))) {
                    fits = false;
                    return false;
                }
            }

            //if fits add
            if (fits) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][y] = word.charAt(j);
                }
                return true;
            }

        }

        return false;

    }

    public boolean isValid() {
        // restricão: define qual é um estado válido
        return isSolutionColumn(0)
                && isSolutionColumn(1)
                && isSolutionColumn(2)
                && isSolutionColumn(3)
                && isSolutionColumn(4)
                && isSolutionRow(0)
                && isSolutionRow(1)
                && isSolutionRow(2)
                && isSolutionRow(3)
                && isSolutionRow(4);
    }

    private boolean isSolutionRow(int row) {
        String word = "";
        int sharp = 0;

        for (int col = 0; col < matrix[row].length; col++) {
            word += matrix[row][col];
            if (matrix[row][col] == '#') {
                sharp++;
            }
        }

        if (sharp == 2) {
            return true;
        } else {
            return words.contains(word);
        }

    }

    private boolean isSolutionColumn(int col) {
        String word = "";
        int sharp = 0;

        for (int row = 0; row < matrix[col].length; row++) {
            word += matrix[col][row];
            if (matrix[row][col] == '#') {
                sharp++;
            }
        }

        if (sharp == 2) {
            return true;
        } else {
            return words.contains(word);
        }

    }

    public String toString() {
        String s = "";
        
        //impressao da matriz
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                s += matrix[i][j] + " ";
            }
            s += "\n";
        }
        
        return s;
    }
}
