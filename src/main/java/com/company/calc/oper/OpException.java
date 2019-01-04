/**
 * Company.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.company.calc.oper;

/**
 * @author young
 * @version $Id: OpException.java, v 0.1 2019年01月04日 5:59 PM young Exp $
 */
public class OpException extends  RuntimeException {

    public OpException() {
        super();
    }

    public OpException(String message) {
        super(message);
    }

    public OpException(Throwable cause) {
        super(cause);
    }
}