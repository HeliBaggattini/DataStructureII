/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SequentialAndBinarySearch;

import java.util.ArrayList;

/**
 *
 * @author 1511 FOX
 */
public class SequentialAndBinarySearch {

    public static void main(String[] args) {
        
        ArrayList a = new ArrayList();
        ArrayList b = new ArrayList();
        
        int size = 1000;
        int find = (int)((Math.random()*1000) - 1);
        
        for(int i = 0; i <= size; i++){
            a.add(i);
            b.add(i);
        }
        
        System.out.println(sequential(a, find));
        System.out.println(binary(b, find));
        

    }

    //sequential search
    public static String sequential(ArrayList a, int n) {
        boolean find = false;
        int cont = 0;

        for (int i = 0; i <= a.size(); i++) {
            if (i == n) {

                find = true;
                cont++;
                break;
            }
            cont++;
        }

        if (find) {
            return ("o numero " + n + " foi encontrado em " + cont + " passos utilizando busca sequencial.");
        } else {
            return ("o numero não foi encontrado na lista.");
        }
        
    }

    //binary search
    public static String binary(ArrayList a, int n) {
        int cont = 0;
        boolean r = false;

        int low = 0, high = a.size() - 1;
        while (low <= high) {
            int mid = ((low + high) / 2);
            cont++;
            if ((int) a.get(mid) == n) {
                r = true;
                break;
            }
            cont++;
            if ((int) a.get(mid) > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (r) {
            return ("o numero " + n + " foi encontrado em " + cont + " passos utilizando busca binária.");
        } else {
            return ("o numero não foi encontrado na lista.");
        }

    }
}
