package TuplesPermutationsAndCombinations;

public class Combination1 {

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
      int l = state.length();
      if (l==0 || state.charAt(l-1) < 'A') { solve(state + "A"); }
      if (l==0 || state.charAt(l-1) < 'B') { solve(state + "B"); }
      if (l==0 || state.charAt(l-1) < 'C') { solve(state + "C"); }
      if (l==0 || state.charAt(l-1) < 'D') { solve(state + "D"); }
    }
  }
}

