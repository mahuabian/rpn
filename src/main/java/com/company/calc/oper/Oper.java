/**
 * Company.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.company.calc.oper;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @author young
 * @version $Id: Oper.java, v 0.1 2019年01月04日 6:10 PM young Exp $
 */
public abstract class Oper {

    protected String op;

    protected int limitSize;

    int position;


    public static final int CALC_SCALE = 15;

    public Oper(int position,String op) {
        this.position = position;
        this.op = op;
    }

    public void doWith(Stack<BigDecimal> numbers, Stack<Runnable> undos){
        if(numbers.size()<limitSize){
            throw new OpException(
                String.format("operator %s (position: %d): insucient parameters",op,position));
        }
        normalOp(numbers, undos);
    }

    protected abstract void  normalOp(final Stack<BigDecimal> numbers,Stack<Runnable> undos);
}