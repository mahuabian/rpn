/**
 * Company.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.company.calc.oper.impl;

import java.math.BigDecimal;
import java.util.Stack;

import com.company.calc.oper.OpException;
import com.company.calc.oper.Oper;

/**
 * @author young
 * @version $Id: NormalOper.java, v 0.1 2019年01月04日 6:34 PM young Exp $
 */
public class NumOper extends Oper {

    BigDecimal num;
    public NumOper(int position,String op) {
        super(position,op);
        try {
            num = new BigDecimal(op);
        }catch (NumberFormatException e){
            throw new OpException(op +" at (position: " + position
                +" ) is NOT a number or this op is NOT supported now !");
        }
        this.limitSize = 0;
    }

    @Override
    protected void  normalOp(final Stack<BigDecimal> numbers, Stack<Runnable> undos){
        numbers.push(num);
        undos.push(numbers::pop);
    }

}