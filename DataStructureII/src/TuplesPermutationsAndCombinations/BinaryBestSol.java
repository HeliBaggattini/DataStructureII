/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TuplesPermutationsAndCombinations;

/**
 *
 * @author 1511 FOX
 */
public class BinaryBestSol {

    public static int complete, partial, solution;
    public static int bestSol = 0;
    public static String bestStr = "";

    public static void main(String[] args) {
        solve("");
        System.out.println("partial:    " + partial);
        System.out.println("complete:   " + complete);
        System.out.println("solution:   " + solution);
        System.out.println("best solution value:   " + bestSol);
        System.out.println("best solution String:   " + bestStr);
    }

    public static int evaluate(String value) {
        return (int) (Math.random() * 1000) + 1;
    }

    public static void solve(String state) {
        if (state.length() == 8) { // STOP CASE
            complete++;
            if (state.replaceAll("0", "").length() == 3) {
                solution++;

                int ev = evaluate(state);
                if (ev > bestSol) {
                    bestSol = ev;
                    bestStr = state;
                }

                System.out.println(state);
            }
        } else { // GENERAL CASE
            partial++;
            //System.out.println(state);      
            solve(state + "0");
            solve(state + "1");
        }
    }

}
