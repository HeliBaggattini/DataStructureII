package TuplesPermutationsAndCombinations;

public class Tuple {

    public static int complete, partial, solution;

    public static void main(String[] args) {
//        solve("");
//        System.out.println("partial:    " + partial);
//        System.out.println("complete:   " + complete);
//        //binary
//        solveBin("");
//        System.out.println("partial:    " + partial);
//        System.out.println("complete:   " + complete);
//        //binary only 3 ones
//        solveBinII("");
//        System.out.println("partial:    " + partial);
//        System.out.println("complete:   " + complete);
//        System.out.println("solution:   " + solution);
        //binary only 3 ones(only the first)
        solveBinIII("");
        System.out.println("partial:    " + partial);
        System.out.println("complete:   " + complete);
        System.out.println("solution:   " + solution);
    }

    public static void solve(String state) {
        if (state.length() == 6) { // STOP CASE
            complete++;
            System.out.println(state);
        } else { // GENERAL CASE
            partial++;
            //System.out.println(state);      
            solve(state + "A");
            solve(state + "B");
            solve(state + "C");
            solve(state + "D");
        }
    }

    public static void solveBin(String state) {
        if (state.length() == 8) { // STOP CASE
            complete++;
            System.out.println(state);
        } else { // GENERAL CASE
            partial++;
            //System.out.println(state);      
            solveBin(state + "0");
            solveBin(state + "1");
        }
    }

    public static void solveBinII(String state) {
        if (state.length() == 8) { // STOP CASE
            complete++;
            if (state.replaceAll("0", "").length() == 3) {
                solution++;
                System.out.println(state);
            }
        } else { // GENERAL CASE
            partial++;
            //System.out.println(state);      
            solveBinII(state + "0");
            solveBinII(state + "1");
        }
    }

    public static boolean solveBinIII(String state) {
        if (state.length() == 8) { // STOP CASE
            complete++;
            if (state.replaceAll("0", "").length() == 3) {
                solution++;
                System.out.println(state);
                return true;
            }
        } else { // GENERAL CASE
            partial++;
            //System.out.println(state);      
            if (solveBinIII(state + "0")) {
                return true;
            }
            if (solveBinIII(state + "1")) {
                return true;
            }
        }
        return false;
    }
}
