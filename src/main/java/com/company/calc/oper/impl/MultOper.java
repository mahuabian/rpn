/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.company.calc.oper.impl;

import java.math.BigDecimal;

import com.company.calc.oper.TwoParamOper;

/**
 * @author young
 * @version $Id: AddOper.java, v 0.1 2019年01月04日 6:21 PM young Exp $
 */
public class MultOper extends TwoParamOper {


    public MultOper(int position, String op) {
        super(position, op);
    }
    @Override
    protected BigDecimal calc(BigDecimal ahead, BigDecimal last) {
        return ahead.multiply(last);
    }
}