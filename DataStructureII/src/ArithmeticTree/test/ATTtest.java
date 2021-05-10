/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArithmeticTree.test;

import ArithmeticTree.ArithmeticTree;

/**
 *
 * @author 1511 FOX
 */
public class ATTtest {

    public static void main(String[] args) throws Exception {

        ArithmeticTree at = ArithmeticTree.createFormula("* a 2");
        at.define("a", 3.2);
        double e = at.evaluate(at.getRoot());
        System.out.println(e);
        System.out.println(at.serialize());

    }

}
