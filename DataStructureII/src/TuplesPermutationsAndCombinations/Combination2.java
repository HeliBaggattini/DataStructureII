package TuplesPermutationsAndCombinations;

public class Combination2 {

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
      if (! state.contains("D")) { 
        if (! state.contains("C")) { 
          if (! state.contains("B")) { 
            if (! state.contains("A")) {
              solve(state + "A");
            }
            solve(state + "B");
          }
          solve(state + "C");
        }
        solve(state + "D");
      }
    }
  }
}

