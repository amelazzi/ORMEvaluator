package com.company;

import com.company.Common.Display.DisplayArrayCatego;
import com.company.Common.Display.DisplayArrayCompByCatego;

public class Main {

    public static void main(String[] args) {
	// write your code here
        long[] cudArray = new long[6];
        long[] fetchArray = new long[5];
        long[] funct = new long[3];
        System.out.print("Welcome to ORM Evaluator");
        DisplayArrayCatego displayArrayCatego = new DisplayArrayCatego();
        displayArrayCatego.cudArray(cudArray);
        displayArrayCatego.fetchArray(fetchArray);
        displayArrayCatego.functionArray(funct);

        DisplayArrayCompByCatego displayArrayCompByCatego = new DisplayArrayCompByCatego();
        displayArrayCompByCatego.cudCatego(cudArray, cudArray);
        displayArrayCompByCatego.fetchCatego(fetchArray, fetchArray);
        displayArrayCompByCatego.functionCatego(funct, funct);
    }
}
