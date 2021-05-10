package TuplesPermutationsAndCombinations;

public class Permutation {

  public static int complete, partial;

  public static void main(String[] args) {
    solve("");
    System.out.println("partial:    " + partial);
    System.out.println("complete:   " + complete);
  }
  
  public static void solve(String state) {
    if (state.length() == 2) { // STOP CASE
      complete++;      
      System.out.println(state);      
    }
    else { // GENERAL CASE
      partial++;
      //System.out.println(state);      
      if (! state.contains("A")) { solve(state + "A"); }
      if (! state.contains("B")) { solve(state + "B"); }
      if (! state.contains("C")) { solve(state + "C"); }
      if (! state.contains("D")) { solve(state + "D"); }
    }
  }
}
















