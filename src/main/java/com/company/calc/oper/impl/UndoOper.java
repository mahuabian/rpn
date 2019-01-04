/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.company.calc.oper.impl;

import java.math.BigDecimal;
import java.util.Stack;

import com.company.calc.oper.Oper;

/**
 * @author young
 * @version $Id: NormalOper.java, v 0.1 2019年01月04日 6:34 PM young Exp $
 */
public class UndoOper extends Oper {

    public UndoOper(int position, String op) {
        super(position, op);
        this.limitSize = 0;
    }

    @Override
    protected void  normalOp(final Stack<BigDecimal> numbers, Stack<Runnable> undos){
        if(undos.size() > 0){
            undos.pop().run();
        }
    }

}