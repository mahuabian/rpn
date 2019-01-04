package com.company.calc;

import com.company.calc.oper.OpException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * date: 2019/1/4 8:41 PM
 *
 * @date 2019/01/04
 */
public class RPNCalculatorTest {



    @Test
    public void  Example1(){
        Calculator calc = new RPNCalculator();
        calc.calc("5 2");
        assertEquals("stack: 5 2",calc.dumpStack());
    }


    @Test
    public void  Example2(){
        Calculator calc = new RPNCalculator();
        calc.calc("2 sqrt");
        assertEquals("stack: 1.4142135623",calc.dumpStack());
        calc.calc("clear 9 sqrt");
        assertEquals("stack: 3",calc.dumpStack());
    }

    @Test
    public void  Example3(){
        Calculator calc = new RPNCalculator();
        calc.calc("5 2 -");
        assertEquals("stack: 3",calc.dumpStack());
        calc.calc("3 -");
        assertEquals("stack: 0",calc.dumpStack());
        calc.calc("clear");
        assertEquals("stack:",calc.dumpStack());
    }

    @Test
    public void  Example4(){
        Calculator calc = new RPNCalculator();
        calc.calc("5 4 3 2");
        assertEquals("stack: 5 4 3 2",calc.dumpStack());
        calc.calc("undo undo *");
        assertEquals("stack: 20",calc.dumpStack());
        calc.calc("5 *");
        assertEquals("stack: 100",calc.dumpStack());
        calc.calc("undo");
        assertEquals("stack: 20 5",calc.dumpStack());
    }

    @Test
    public void  Example5(){
        Calculator calc = new RPNCalculator();
        calc.calc("7 12 2 /");
        assertEquals("stack: 7 6",calc.dumpStack());
        calc.calc("*");
        assertEquals("stack: 42",calc.dumpStack());
        calc.calc("4 /");
        assertEquals("stack: 10.5",calc.dumpStack());
    }

    @Test
    public void  Example6(){
        Calculator calc = new RPNCalculator();
        calc.calc("1 2 3 4 5");
        assertEquals("stack: 1 2 3 4 5",calc.dumpStack());
        calc.calc("*");
        assertEquals("stack: 1 2 3 20",calc.dumpStack());
        calc.calc("clear 3 4 -");
        assertEquals("stack: -1",calc.dumpStack());
    }

    @Test
    public void  Example7(){
        Calculator calc = new RPNCalculator();
        calc.calc("1 2 3 4 5");
        assertEquals("stack: 1 2 3 4 5",calc.dumpStack());
        calc.calc("* * * *");
        assertEquals("stack: 120",calc.dumpStack());
    }



    @Test
    public void  Example8(){
        Calculator calc = new RPNCalculator();
        try {
            calc.calc("1 2 3 * 5 + * * 6 5");
            fail("OpException did not throw!");
        }catch (OpException e){
            assertEquals("operator * (position: 15): insucient parameters",e.getMessage());
        }
        assertEquals("stack: 11",calc.dumpStack());
    }


}