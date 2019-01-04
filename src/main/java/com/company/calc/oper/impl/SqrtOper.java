/**
 * Company.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.company.calc.oper.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;

import com.company.calc.oper.Oper;

/**
 * @author young
 * @version $Id: NormalOper.java, v 0.1 2019年01月04日 6:34 PM young Exp $
 */
public class SqrtOper extends Oper {

    public SqrtOper(int position, String op) {
        super(position, op);
        this.limitSize = 1;
    }

    @Override
    protected void  normalOp(final Stack<BigDecimal> numbers, Stack<Runnable> undos){
        final BigDecimal last = numbers.pop();
        BigDecimal x =
            new BigDecimal(Math.sqrt(last.doubleValue()), MathContext.DECIMAL64)
                .setScale(CALC_SCALE, BigDecimal.ROUND_DOWN);
        numbers.push(x);
        undos.push(() -> {
            numbers.pop();
            numbers.push(last);
        });
    }

}