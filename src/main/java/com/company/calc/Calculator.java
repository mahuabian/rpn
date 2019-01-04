/**
 * Company.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.company.calc;

import com.company.calc.oper.OpException;

/**
 * @author young
 * @version $Id: Calculator.java, v 0.1 2019年01月04日 8:31 PM young Exp $
 */
public interface Calculator {

    void calc(String line) throws OpException ;

    String dumpStack();
}