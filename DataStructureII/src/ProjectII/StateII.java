package ProjectII;

import java.util.ArrayList;

public class StateII {

    private ArrayList<String> words; //words (for validity conference)
    private char[][] matrix;

    public StateII(char[][] matrix, ArrayList<String> words) {
        this.words = words;

        this.matrix = new char[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
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

    //verify if the actual state is a valid state
    public boolean isValid() {

        //
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

    //verify if the row has a valid word
    public boolean isSolutionRow(int row) {
        String word = "";
        int sharp = 0;
        int empty = 0;

        for (int col = 0; col < matrix[row].length; col++) {
            word += matrix[row][col];
            if (matrix[row][col] == '#') {
                sharp++;
            }
            if (matrix[row][col] == '-') {
                empty++;
            }
        }

        if (sharp == 2 || sharp == 3) {
            return true;
        } else if (empty > 0) {
            return false;
        } else {
            return words.contains(word);
        }

    }

    //verify if the column has a valid word
    public boolean isSolutionColumn(int col) {
        String word = "";
        int sharp = 0;
        int empty = 0;

        for (int row = 0; row < matrix[col].length; row++) {
            word += matrix[row][col];
            if (matrix[row][col] == '#') {
                sharp++;
            }
            if (matrix[row][col] == '-') {
                empty++;
            }
        }

        if (sharp == 2 || sharp == 3) {
            return true;
        } else if (empty > 0) {
            return false;
        } else {
            return words.contains(word);
        }

    }

    //verify if the row has a blocked space(sharp)
    public boolean rowHasSharp(int row) {

        for (int col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] == '#') {
                return true;
            }
        }
        return false;
    }

    //verify if the column has a blocked space(sharp)
    public boolean columnHasSharp(int col) {

        for (int row = 0; row < matrix[col].length; row++) {
            if (matrix[row][col] == '#') {
                return true;
            }
        }
        return false;
    }

    //verify if the matrix has empty spaces
    public boolean hasEmptySpace() {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == '-') {
                    return true;
                }
            }
        }

        return false;
    }

    //return the actual matix state
    public char[][] getMatrix() {
        return matrix;
    }

    //prints the matrix (actual state)
    public String toString() {
        String s = "";

        //printing the matrix
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                s += matrix[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }

}
