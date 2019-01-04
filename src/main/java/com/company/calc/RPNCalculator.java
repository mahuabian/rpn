/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.company.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

import com.company.calc.oper.OpException;
import com.company.calc.oper.Oper;
import com.company.calc.oper.impl.AddOper;
import com.company.calc.oper.impl.ClearOper;
import com.company.calc.oper.impl.DiviOper;
import com.company.calc.oper.impl.MultOper;
import com.company.calc.oper.impl.NumOper;
import com.company.calc.oper.impl.SqrtOper;
import com.company.calc.oper.impl.SubOper;
import com.company.calc.oper.impl.UndoOper;

/**
 * @author young
 * @version $Id: Calculator.java, v 0.1 2019年01月04日 5:31 PM young Exp $
 */
public class RPNCalculator implements Calculator {

    static final Map<String, BiFunction<Integer, String, Oper>> SELECT_MAP = new HashMap<>();

    static {
        SELECT_MAP.put("+", AddOper::new);
        SELECT_MAP.put("-", SubOper::new);
        SELECT_MAP.put("*", MultOper::new);
        SELECT_MAP.put("/", DiviOper::new);
        SELECT_MAP.put("sqrt", SqrtOper::new);
        SELECT_MAP.put("undo", UndoOper::new);
        SELECT_MAP.put("clear", ClearOper::new);
    }

    static final BiFunction<Integer, String, Oper> NUMBER = NumOper::new;

    static final int DISPLAY_SCALE = 10;
    static final char WHITE = ' ';

    final DecimalFormat numberFormat;
    final Stack<BigDecimal> numbers = new Stack<>();
    final Stack<Runnable> undos = new Stack<>();

    public RPNCalculator() {
        numberFormat = new DecimalFormat();
        numberFormat.setRoundingMode(RoundingMode.DOWN);
        numberFormat.setGroupingUsed(false);
        numberFormat.setMaximumFractionDigits(DISPLAY_SCALE);
        numberFormat.setMinimumFractionDigits(0);
    }

    @Override
    public void calc(String line) throws OpException {
        int len;
        if (line != null && (len = line.length()) > 0) {
            int begin = 0;
            for (int i = 0; i < len; i++) {
                char c = line.charAt(i);

                if (c == WHITE && begin == i) {
                    begin++;
                    continue;
                }
                String op = null;

                if (c == WHITE) {
                    op = line.substring(begin, i);
                } else if (i == len - 1) {
                    op = line.substring(begin, len);
                }

                if (null != op) {
                    Oper oper = SELECT_MAP.getOrDefault(op, NUMBER).apply(begin + 1, op);
                    begin = i + 1;
                    oper.doWith(numbers, undos);
                }
            }
        }
    }

    @Override
    public String dumpStack() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("stack:");
        if (numbers.size() > 0) {
            for (BigDecimal num : numbers) {
                sb.append(WHITE).append(numberFormat.format(num));
            }
        }
        return sb.toString();
    }

}