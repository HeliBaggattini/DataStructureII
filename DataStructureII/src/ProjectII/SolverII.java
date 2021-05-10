package ProjectII;

import java.util.ArrayList;
import java.util.Stack;
import utilities.SimpleReader;

public class SolverII {

    // contador de estados gerados
    public static int complete = 0;
    public static int partial = 0;
    public static ArrayList<String> words;
    public static boolean solution = false;

    public static char[][] matrix1 = {
        {'-', '-', '-', '-', '-'},
        {'-', '#', '-', '#', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '#', '-', '#', '-'},
        {'-', '-', '-', '-', '-'}
    };

    public static char[][] matrix2 = {
        {'#', '-', '#', '-', '#'},
        {'-', '-', '-', '-', '-'},
        {'#', '-', '#', '-', '#'},
        {'-', '-', '-', '-', '-'},
        {'#', '-', '#', '-', '#'}
    };

    //bonus matrix
    public static char[][] matrix3 = {
        {'-', '#', '-', '#', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '#', '-', '#', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '#', '-', '#', '-'}
    };

    public static void solve(ArrayList<String> word, int index, StateII state) {
        ArrayList<String> wordAux = (ArrayList<String>) word.clone();
        int r = 0, c = 0;
        boolean findR = false, findC = false;

        //print the actual state(for testing purpouse)
//        System.out.println(state);
        partial++;

        if (state.hasEmptySpace()) { // STOP CASE: matrix is full

            //look for empty rows on the matrix
            for (r = 0; r < state.getMatrix()[0].length; r++) {
                if (!state.isSolutionRow(r) && !state.rowHasSharp(r)) {
                    findR = true;
                    break;
                }
            }

            //if not find empty rows, look for empty columns
            if (!findR) {
                for (c = 0; c < state.getMatrix().length; c++) {
                    if (!state.isSolutionColumn(c) && !state.columnHasSharp(c)) {
                        findC = true;
                        break;
                    }
                }
            }

            if (findR) { //if there is empty rows on the matrix, try to add the word
                //if the word fits add the word and continue
                if (state.addWord(r, 0, 'h', wordAux.get(index))) {
                    //remove the last word added to the matrix
                    wordAux.remove(index);
                    
                    //if the first solution was found stop the method
                    if(state.isValid()){
                        solution = true; //comment this line to find all possible solutions
                    }

                    if(!solution){
                        //loop for all the remeaning words
                        for (int i = 0; i < wordAux.size(); i++) {
                            StateII stateAux = new StateII(state.getMatrix(), words);
                            solve((ArrayList<String>) wordAux.clone(), i, stateAux);
                            if(solution){
                                break;
                            }
                        }
                    }
                } else {
                    return;
                }
            } else if (findC) { //if there is empty columns on the matrix, try to add word
                //if the word fits add the word and continue
                if (state.addWord(0, c, 'v', wordAux.get(index))) {
                    //remove the last word added to the matrix
                    wordAux.remove(index);
                    
                    //if the first solution was found stop the method
                    if(state.isValid()){
                        solution = true; //comment this line to find all possible solutions
                    }

                    if(!solution){
                        //loop for all the remeaning words
                        for (int i = 0; i < wordAux.size(); i++) {
                            StateII stateAux = new StateII(state.getMatrix(), words);
                            solve((ArrayList<String>) wordAux.clone(), i, stateAux);
                            if(solution){
                                break;
                            }
                        }
                    }
                }
            }

            if (state.isValid()) { //if is a valid solution, print the matrix
                complete++;
                System.out.println(state);
            }
        }
    }

    //read all words from the .txt file
    private static void readWords(String path) {
        SimpleReader f = new SimpleReader(path);
        ArrayList<String> a = new ArrayList<>();
        Stack b = new Stack();

        String s = f.readLine();
        while (s != null) {
            a.add(s);
            b.push(s);
            s = f.readLine();
        }
        f.close();

        words = a;

        //test printing
//        words.forEach(x -> {
//            System.out.println(x);
//        });
    }

    public static void main(String[] args) {
        //try all possible splutions for the matrix1, matrix2 and matrix3(bonus)
        long start = System.currentTimeMillis();

        //read the words
        readWords("palavras-5.txt"); //5891 words
//        readWords("words.txt"); //100 words

        ArrayList<String> a = words;
        System.out.println(a.size() + " words");

        //try the matrix1--------------------------------------
        for (int i = 0; i < a.size(); i++) {
            StateII s = new StateII(matrix1, words);
            solve(a, i, s);
        }

        //matrix 1
        System.out.println("----Matriz 1----");
        System.out.println("Partial: " + partial);
        System.out.println("Complete: " + complete);
        System.out.println("time : " + (System.currentTimeMillis() - start) / 1000.0 + " s");
        //try the matrix 2--------------------------------------
        System.out.println("");

        //restart the variables
        solution = false;
        start = System.currentTimeMillis();
        partial = 0;
        complete = 0;
        a = words;

        for (int i = 0; i < a.size(); i++) {
            StateII s = new StateII(matrix2, words);
            if(!solution){
                solve(a, i, s);
            }
        }

        //matrix 2
        System.out.println("----Matriz 2----");
        System.out.println("Partial: " + partial);
        System.out.println("Complete: " + complete);
        System.out.println("time : " + (System.currentTimeMillis() - start) / 1000.0 + " s");

        //try the matrix 3(bonus matrix)-------------------------
        System.out.println("");

        //restart the variables
        solution = false;
        start = System.currentTimeMillis();
        partial = 0;
        complete = 0;
        a = words;

        for (int i = 0; i < a.size(); i++) {
            StateII s = new StateII(matrix3, words);
            solve(a, i, s);
        }

        //matrix 3
        System.out.println("----Matriz 3----");
        System.out.println("Partial: " + partial);
        System.out.println("Complete: " + complete);
        System.out.println("time : " + (System.currentTimeMillis() - start) / 1000.0 + " s");
    }
}
