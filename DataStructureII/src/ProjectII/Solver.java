package ProjectII;

import java.util.ArrayList;
import java.util.Stack;
import utilities.SimpleReader;

public class Solver {

    // contador de estados gerados
    public static int count = 0;
    public static ArrayList<String> words;

    // registra o melhor estado encontrado até agora
    public static State best;

    public static char[][] matrix1 = {
        {'-', '-', '-', '-', '-'},
        {'-', '#', '-', '#', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '#', '-', '#', '-'},
        {'-', '-', '-', '-', '-'}
    };

    public static char[][] matrix2 = {
        {'-', '#', '-', '#', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '#', '-', '#', '-'},
        {'-', '-', '-', '-', '-'},
        {'-', '#', '-', '#', '-'}
    };

    public static void solve(String word, State state) {

        System.out.println(state.isValid());

        if (state.isValid()) {
            count++;
            System.out.println(state);
        } else {
            // baseado no estado parcial atual, gera e testa diferentes variações
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    //test
                    boolean sh = state.addWord(i, j, 'h', word);
                    System.out.println(sh + " " + word);
                    //
                    if(sh){//if (state.addWord(i, j, 'h', word)) {
                        //test
                        boolean sv = state.addWord(i, j, 'v', word);
                        System.out.println(sv + " " + word);
                        System.out.println(state);
                        //
                        if(sv){//if (state.addWord(i, j, 'v', word)) {
                            solve(word, state);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
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
        // procura a melhor sequência com exatos 6 caracteres
//        long start = System.currentTimeMillis();
        readWords("palavras-5.txt");

        for (String s : words) {
            solve(s, new State(matrix1.clone(), words));
        }
//
//        System.out.println();
//        System.out.println("count: " + count);
//        System.out.println("time : " + (System.currentTimeMillis() - start) / 1000.0 + " s");

////-----------------------------------------testes-----------------------------------------------
//        System.out.println("----------------------------------");
//        char[][] matrixTeste = {
//            {'a', '#', 'c', '#', 'e'},
//            {'B', 'r', 'a', 's', 'a'},
//            {'C', '#', 'l', '#', 's'},
//            {'D', 'e', 'd', 'a', 'l'},
//            {'E', '#', 'o', '#', 'a'}
//        };
//        int col = 1;
//
//        ArrayList<String> a = new ArrayList<>();
//        a.add("aBCDE");
//        a.add("Brasa");
//        a.add("Dedal");
//        a.add("caldo");
//        a.add("easla");
//
//        String word = "";
//        int sharp = 0;
//
//        for (int row = 0; row < matrixTeste.length; row++) {
//            word += matrixTeste[row][col];
//            if (matrixTeste[row][col] == '#') {
//                sharp++;
//            }
//        }
//
//        if (sharp == 3) {
//            System.out.println("true");
//        } else {
//            System.out.println(a.contains(word));
//            System.out.println(word);
//        }
    }
}
