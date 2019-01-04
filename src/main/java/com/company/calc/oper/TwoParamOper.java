/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.company.calc.oper;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @author young
 * @version $Id: NormalOper.java, v 0.1 2019年01月04日 6:34 PM young Exp $
 */
public abstract class TwoParamOper extends Oper {

    public TwoParamOper(int position, String op) {
        super(position,op);
        this.limitSize = 2;
    }

    @Override
    protected void  normalOp(final Stack<BigDecimal> numbers, Stack<Runnable> undos){
        final BigDecimal last = numbers.pop();
        final BigDecimal ahead = numbers.pop();

        numbers.push(calc(ahead,last));
        undos.push(() -> {
            numbers.pop();
            numbers.push(ahead);
            numbers.push(last);
        });
    }

    protected abstract BigDecimal calc(BigDecimal ahead,BigDecimal last);
}