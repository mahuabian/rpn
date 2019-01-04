package com.company.calc;

import java.util.Scanner;

import com.company.calc.oper.OpException;

public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Calculator calc  = new RPNCalculator();
        while ( scan.hasNextLine()){
            String line = scan.nextLine();
            try {
                calc.calc(line);
            }catch (OpException e){
                System.err.println(e.getMessage());
            }
            System.out.println(calc.dumpStack());
        }
    }
}
