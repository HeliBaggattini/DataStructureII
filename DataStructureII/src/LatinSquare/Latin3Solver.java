package LatinSquare;

public class Latin3Solver
{
  public static int complete, partial, solution;

  public static void main(String[] args)
  {
    Latin3State start = new Latin3State();
    //start.m[1][1] = 'b';
    solve(start);
    System.out.println("partial:  " + partial);
    System.out.println("complete: " + complete);
    System.out.println("solution: " + solution);
  }
  
  public static void solve(final Latin3State state)
  {
    // find empty '-' matrix element
    boolean found = false;
    int r = 0, c = 0;
    for (r = 0; r <= 2; r++) {
      for (c = 0; c <= 2; c++) {
        if (state.m[r][c]=='-') {
          found = true;
          break;
        }
      }
      if (found) { break; }
    }

    if (!found) { // STOP CASE: matrix is full
      complete++;
      //System.out.println(state);

      if (state.isSolution()) {
        solution++;
        System.out.println(state);
      }
    }
    else { // GENERAL CASE: choose letter to fill an empty position
      partial++;
      //System.out.println(state);

      Latin3State sa = new Latin3State(state);
      sa.m[r][c] = 'a';
      solve(sa);

      Latin3State sb = new Latin3State(state);
      sb.m[r][c] = 'b';
      solve(sb);

      Latin3State sc = new Latin3State(state);
      sc.m[r][c] = 'c';
      solve(sc);
    }
  }
}
