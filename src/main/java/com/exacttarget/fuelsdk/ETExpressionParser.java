/* ETExpressionParser.java */
/* Generated By:JavaCC: Do not edit this line. ETExpressionParser.java */
package com.exacttarget.fuelsdk;

import org.apache.log4j.Logger;

public class ETExpressionParser implements ETExpressionParserConstants {
    private static Logger logger = Logger.getLogger(ETExpressionParser.class);

    final public ETExpression parse() throws ParseException {ETExpression expression = null;
        expression = Expression();
        logger.trace("returning expression: " + expression);
        {if ("" != null) return expression;}
        throw new Error("Missing return statement in function");
    }

    final public ETExpression Expression() throws ParseException {ETExpression expression = null;
        if (jj_2_1(2147483647)) {
            expression = OrExpression();
        } else {
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
                case 16:{
                    jj_consume_token(16);
                    expression = Expression();
                    jj_consume_token(17);
                    ETExpression e = expression;
                    expression = new ETExpression();
                    expression.addSubexpression(e);
                    break;
                }
                default:
                    jj_la1[0] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
        logger.trace("Expression: " + expression);
        {if ("" != null) return expression;}
        throw new Error("Missing return statement in function");
    }

    final public ETExpression OrExpression() throws ParseException {ETExpression expression = null;
        ETExpression expression1 = null;
        ETExpression expression2 = null;
        expression1 = AndExpression();
        expression = expression1;
        label_1:
        while (true) {
            if (jj_2_2(2147483647)) {
                ;
            } else {
                break label_1;
            }
            jj_consume_token(OR);
            expression2 = AndExpression();
            expression = new ETExpression();
            expression.setOperator(ETExpression.Operator.OR);
            expression.addSubexpression(expression1);
            expression.addSubexpression(expression2);
            expression1 = expression;
        }
        logger.trace("OrExpression: " + expression);
        {if ("" != null) return expression;}
        throw new Error("Missing return statement in function");
    }

    final public ETExpression AndExpression() throws ParseException {ETExpression expression = null;
        ETExpression expression1 = null;
        ETExpression expression2 = null;
        if (jj_2_3(2147483647)) {
            expression1 = SimpleExpression();
        } else {
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
                case 16:{
                    jj_consume_token(16);
                    expression1 = OrExpression();
                    jj_consume_token(17);
                    ETExpression e = expression1;
                    expression1 = new ETExpression();
                    expression1.addSubexpression(e);
                    break;
                }
                default:
                    jj_la1[1] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
        expression = expression1;
        label_2:
        while (true) {
            if (jj_2_4(2147483647)) {
                ;
            } else {
                break label_2;
            }
            jj_consume_token(AND);
            if (jj_2_5(2147483647)) {
                expression2 = SimpleExpression();
            } else {
                switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
                    case 16:{
                        jj_consume_token(16);
                        expression2 = OrExpression();
                        jj_consume_token(17);
                        break;
                    }
                    default:
                        jj_la1[2] = jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
            }
            expression = new ETExpression();
            expression.setOperator(ETExpression.Operator.AND);
            expression.addSubexpression(expression1);
            expression.addSubexpression(expression2);
            expression1 = expression;
        }
        logger.trace("AndExpression: " + expression);
        {if ("" != null) return expression;}
        throw new Error("Missing return statement in function");
    }

    final public ETExpression SimpleExpression() throws ParseException {ETExpression expression = new ETExpression();
        if (jj_2_6(2147483647)) {
            expression = BetweenExpression();
        } else if (jj_2_7(2147483647)) {
            expression = InExpression();
        } else if (jj_2_8(2147483647)) {
            expression = IsNullExpression();
        } else {
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
                case UNQUOTED_STRING:
                case SINGLE_QUOTED_STRING:
                case DOUBLE_QUOTED_STRING:{
                    expression = ComparisonExpression();
                    break;
                }
                default:
                    jj_la1[3] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
        logger.trace("SimpleExpression: " + expression);
        {if ("" != null) return expression;}
        throw new Error("Missing return statement in function");
    }

    final public ETExpression BetweenExpression() throws ParseException {ETExpression expression = new ETExpression();
        String value = null;
        value = Value();
        expression.setProperty(value);
        jj_consume_token(BETWEEN);
        expression.setOperator(ETExpression.Operator.BETWEEN);
        value = Value();
        expression.addValue(value);
        jj_consume_token(AND);
        value = Value();
        expression.addValue(value);
        logger.trace("BetweenExpression: " + expression);
        {if ("" != null) return expression;}
        throw new Error("Missing return statement in function");
    }

    final public ETExpression ComparisonExpression() throws ParseException {ETExpression expression = new ETExpression();
        String value = null;
        value = Value();
        expression.setProperty(value);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case 18:{
                jj_consume_token(18);
                expression.setOperator(ETExpression.Operator.EQUALS);
                break;
            }
            case 19:{
                jj_consume_token(19);
                expression.setOperator(ETExpression.Operator.NOT_EQUALS);
                break;
            }
            case 20:{
                jj_consume_token(20);
                expression.setOperator(ETExpression.Operator.LESS_THAN);
                break;
            }
            case 21:{
                jj_consume_token(21);
                expression.setOperator(ETExpression.Operator.LESS_THAN_OR_EQUALS);
                break;
            }
            case 22:{
                jj_consume_token(22);
                expression.setOperator(ETExpression.Operator.GREATER_THAN);
                break;
            }
            case 23:{
                jj_consume_token(23);
                expression.setOperator(ETExpression.Operator.GREATER_THAN_OR_EQUALS);
                break;
            }
            case LIKE:{
                jj_consume_token(LIKE);
                expression.setOperator(ETExpression.Operator.LIKE);
                break;
            }
            default:
                jj_la1[4] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        value = Value();
        expression.addValue(value);
        logger.trace("ComparisonExpression: " + expression);
        {if ("" != null) return expression;}
        throw new Error("Missing return statement in function");
    }

    final public ETExpression InExpression() throws ParseException {ETExpression expression = new ETExpression();
        String value = null;
        value = Value();
        expression.setProperty(value);
        jj_consume_token(IN);
        expression.setOperator(ETExpression.Operator.IN);
        jj_consume_token(16);
        value = Value();
        expression.addValue(value);
        label_3:
        while (true) {
            jj_consume_token(24);
            value = Value();
            expression.addValue(value);
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
                case 24:{
                    ;
                    break;
                }
                default:
                    jj_la1[5] = jj_gen;
                    break label_3;
            }
        }
        jj_consume_token(17);
        logger.trace("InExpression: " + expression);
        {if ("" != null) return expression;}
        throw new Error("Missing return statement in function");
    }

    final public ETExpression IsNullExpression() throws ParseException {ETExpression expression = new ETExpression();
        String value = null;
        value = Value();
        expression.setProperty(value);
        jj_consume_token(IS);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case NULL:{
                jj_consume_token(NULL);
                expression.setOperator(ETExpression.Operator.IS_NULL);
                break;
            }
            case NOT:{
                jj_consume_token(NOT);
                jj_consume_token(NULL);
                expression.setOperator(ETExpression.Operator.IS_NOT_NULL);
                break;
            }
            default:
                jj_la1[6] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        logger.trace("IsNullExpression: " + expression);
        {if ("" != null) return expression;}
        throw new Error("Missing return statement in function");
    }

    final public String Value() throws ParseException {Token token = null;
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case UNQUOTED_STRING:{
                token = jj_consume_token(UNQUOTED_STRING);
                {if ("" != null) return token.image;}
                break;
            }
            case SINGLE_QUOTED_STRING:{
                token = jj_consume_token(SINGLE_QUOTED_STRING);
                {if ("" != null) return token.image.substring(1, token.image.length() - 1);}
                break;
            }
            case DOUBLE_QUOTED_STRING:{
                token = jj_consume_token(DOUBLE_QUOTED_STRING);
                {if ("" != null) return token.image.substring(1, token.image.length() - 1);}
                break;
            }
            default:
                jj_la1[7] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        throw new Error("Missing return statement in function");
    }

    private boolean jj_2_1(int xla)
    {
        jj_la = xla; jj_lastpos = jj_scanpos = token;
        try { return !jj_3_1(); }
        catch(LookaheadSuccess ls) { return true; }
        finally { jj_save(0, xla); }
    }

    private boolean jj_2_2(int xla)
    {
        jj_la = xla; jj_lastpos = jj_scanpos = token;
        try { return !jj_3_2(); }
        catch(LookaheadSuccess ls) { return true; }
        finally { jj_save(1, xla); }
    }

    private boolean jj_2_3(int xla)
    {
        jj_la = xla; jj_lastpos = jj_scanpos = token;
        try { return !jj_3_3(); }
        catch(LookaheadSuccess ls) { return true; }
        finally { jj_save(2, xla); }
    }

    private boolean jj_2_4(int xla)
    {
        jj_la = xla; jj_lastpos = jj_scanpos = token;
        try { return !jj_3_4(); }
        catch(LookaheadSuccess ls) { return true; }
        finally { jj_save(3, xla); }
    }

    private boolean jj_2_5(int xla)
    {
        jj_la = xla; jj_lastpos = jj_scanpos = token;
        try { return !jj_3_5(); }
        catch(LookaheadSuccess ls) { return true; }
        finally { jj_save(4, xla); }
    }

    private boolean jj_2_6(int xla)
    {
        jj_la = xla; jj_lastpos = jj_scanpos = token;
        try { return !jj_3_6(); }
        catch(LookaheadSuccess ls) { return true; }
        finally { jj_save(5, xla); }
    }

    private boolean jj_2_7(int xla)
    {
        jj_la = xla; jj_lastpos = jj_scanpos = token;
        try { return !jj_3_7(); }
        catch(LookaheadSuccess ls) { return true; }
        finally { jj_save(6, xla); }
    }

    private boolean jj_2_8(int xla)
    {
        jj_la = xla; jj_lastpos = jj_scanpos = token;
        try { return !jj_3_8(); }
        catch(LookaheadSuccess ls) { return true; }
        finally { jj_save(7, xla); }
    }

    private boolean jj_3R_5()
    {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_11()) {
            jj_scanpos = xsp;
            if (jj_3R_12()) {
                jj_scanpos = xsp;
                if (jj_3R_13()) {
                    jj_scanpos = xsp;
                    if (jj_3R_14()) return true;
                }
            }
        }
        return false;
    }

    private boolean jj_3R_25()
    {
        if (jj_scan_token(DOUBLE_QUOTED_STRING)) return true;
        return false;
    }

    private boolean jj_3_5()
    {
        if (jj_3R_5()) return true;
        return false;
    }

    private boolean jj_3R_24()
    {
        if (jj_scan_token(SINGLE_QUOTED_STRING)) return true;
        return false;
    }

    private boolean jj_3R_34()
    {
        if (jj_scan_token(LIKE)) return true;
        return false;
    }

    private boolean jj_3R_33()
    {
        if (jj_scan_token(23)) return true;
        return false;
    }

    private boolean jj_3_4()
    {
        if (jj_scan_token(AND)) return true;
        return false;
    }

    private boolean jj_3R_23()
    {
        if (jj_scan_token(UNQUOTED_STRING)) return true;
        return false;
    }

    private boolean jj_3R_27()
    {
        if (jj_scan_token(16)) return true;
        if (jj_3R_4()) return true;
        if (jj_scan_token(17)) return true;
        return false;
    }

    private boolean jj_3R_32()
    {
        if (jj_scan_token(22)) return true;
        return false;
    }

    private boolean jj_3R_26()
    {
        if (jj_3R_5()) return true;
        return false;
    }

    private boolean jj_3R_15()
    {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_23()) {
            jj_scanpos = xsp;
            if (jj_3R_24()) {
                jj_scanpos = xsp;
                if (jj_3R_25()) return true;
            }
        }
        return false;
    }

    private boolean jj_3R_31()
    {
        if (jj_scan_token(21)) return true;
        return false;
    }

    private boolean jj_3R_21()
    {
        if (jj_scan_token(AND)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_26()) {
            jj_scanpos = xsp;
            if (jj_3R_27()) return true;
        }
        return false;
    }

    private boolean jj_3R_30()
    {
        if (jj_scan_token(20)) return true;
        return false;
    }

    private boolean jj_3_3()
    {
        if (jj_3R_5()) return true;
        return false;
    }

    private boolean jj_3R_29()
    {
        if (jj_scan_token(19)) return true;
        return false;
    }

    private boolean jj_3R_18()
    {
        if (jj_scan_token(NOT)) return true;
        if (jj_scan_token(NULL)) return true;
        return false;
    }

    private boolean jj_3R_20()
    {
        if (jj_scan_token(16)) return true;
        if (jj_3R_4()) return true;
        if (jj_scan_token(17)) return true;
        return false;
    }

    private boolean jj_3R_28()
    {
        if (jj_scan_token(18)) return true;
        return false;
    }

    private boolean jj_3R_17()
    {
        if (jj_scan_token(NULL)) return true;
        return false;
    }

    private boolean jj_3R_19()
    {
        if (jj_3R_5()) return true;
        return false;
    }

    private boolean jj_3R_9()
    {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_19()) {
            jj_scanpos = xsp;
            if (jj_3R_20()) return true;
        }
        while (true) {
            xsp = jj_scanpos;
            if (jj_3R_21()) { jj_scanpos = xsp; break; }
        }
        return false;
    }

    private boolean jj_3R_22()
    {
        if (jj_3R_15()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_28()) {
            jj_scanpos = xsp;
            if (jj_3R_29()) {
                jj_scanpos = xsp;
                if (jj_3R_30()) {
                    jj_scanpos = xsp;
                    if (jj_3R_31()) {
                        jj_scanpos = xsp;
                        if (jj_3R_32()) {
                            jj_scanpos = xsp;
                            if (jj_3R_33()) {
                                jj_scanpos = xsp;
                                if (jj_3R_34()) return true;
                            }
                        }
                    }
                }
            }
        }
        if (jj_3R_15()) return true;
        return false;
    }

    private boolean jj_3R_8()
    {
        if (jj_3R_15()) return true;
        if (jj_scan_token(IS)) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_17()) {
            jj_scanpos = xsp;
            if (jj_3R_18()) return true;
        }
        return false;
    }

    private boolean jj_3_2()
    {
        if (jj_scan_token(OR)) return true;
        return false;
    }

    private boolean jj_3R_10()
    {
        if (jj_scan_token(OR)) return true;
        if (jj_3R_9()) return true;
        return false;
    }

    private boolean jj_3R_16()
    {
        if (jj_scan_token(24)) return true;
        if (jj_3R_15()) return true;
        return false;
    }

    private boolean jj_3R_4()
    {
        if (jj_3R_9()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3R_10()) { jj_scanpos = xsp; break; }
        }
        return false;
    }

    private boolean jj_3_1()
    {
        if (jj_3R_4()) return true;
        return false;
    }

    private boolean jj_3_8()
    {
        if (jj_3R_8()) return true;
        return false;
    }

    private boolean jj_3R_6()
    {
        if (jj_3R_15()) return true;
        if (jj_scan_token(BETWEEN)) return true;
        if (jj_3R_15()) return true;
        if (jj_scan_token(AND)) return true;
        if (jj_3R_15()) return true;
        return false;
    }

    private boolean jj_3_7()
    {
        if (jj_3R_7()) return true;
        return false;
    }

    private boolean jj_3_6()
    {
        if (jj_3R_6()) return true;
        return false;
    }

    private boolean jj_3R_14()
    {
        if (jj_3R_22()) return true;
        return false;
    }

    private boolean jj_3R_7()
    {
        if (jj_3R_15()) return true;
        if (jj_scan_token(IN)) return true;
        if (jj_scan_token(16)) return true;
        if (jj_3R_15()) return true;
        Token xsp;
        if (jj_3R_16()) return true;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3R_16()) { jj_scanpos = xsp; break; }
        }
        if (jj_scan_token(17)) return true;
        return false;
    }

    private boolean jj_3R_13()
    {
        if (jj_3R_8()) return true;
        return false;
    }

    private boolean jj_3R_12()
    {
        if (jj_3R_7()) return true;
        return false;
    }

    private boolean jj_3R_11()
    {
        if (jj_3R_6()) return true;
        return false;
    }

    /** Generated Token Manager. */
    public ETExpressionParserTokenManager token_source;
    SimpleCharStream jj_input_stream;
    /** Current token. */
    public Token token;
    /** Next token. */
    public Token jj_nt;
    private int jj_ntk;
    private Token jj_scanpos, jj_lastpos;
    private int jj_la;
    private int jj_gen;
    final private int[] jj_la1 = new int[8];
    static private int[] jj_la1_0;
    static {
        jj_la1_init_0();
    }
    private static void jj_la1_init_0() {
        jj_la1_0 = new int[] {0x10000,0x10000,0x10000,0xe000,0xfc0800,0x1000000,0x1080,0xe000,};
    }
    final private JJCalls[] jj_2_rtns = new JJCalls[8];
    private boolean jj_rescan = false;
    private int jj_gc = 0;

    /** Constructor with InputStream. */
    public ETExpressionParser(java.io.InputStream stream) {
        this(stream, null);
    }
    /** Constructor with InputStream and supplied encoding */
    public ETExpressionParser(java.io.InputStream stream, String encoding) {
        try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
        token_source = new ETExpressionParserTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 8; i++) jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /** Reinitialise. */
    public void ReInit(java.io.InputStream stream) {
        ReInit(stream, null);
    }
    /** Reinitialise. */
    public void ReInit(java.io.InputStream stream, String encoding) {
        try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 8; i++) jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /** Constructor. */
    public ETExpressionParser(java.io.Reader stream) {
        jj_input_stream = new SimpleCharStream(stream, 1, 1);
        token_source = new ETExpressionParserTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 8; i++) jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /** Reinitialise. */
    public void ReInit(java.io.Reader stream) {
        if (jj_input_stream == null) {
            jj_input_stream = new SimpleCharStream(stream, 1, 1);
        } else {
            jj_input_stream.ReInit(stream, 1, 1);
        }
        if (token_source == null) {
            token_source = new ETExpressionParserTokenManager(jj_input_stream);
        }

        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 8; i++) jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /** Constructor with generated Token Manager. */
    public ETExpressionParser(ETExpressionParserTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 8; i++) jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /** Reinitialise. */
    public void ReInit(ETExpressionParserTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 8; i++) jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    private Token jj_consume_token(int kind) throws ParseException {
        Token oldToken;
        if ((oldToken = token).next != null) token = token.next;
        else token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        if (token.kind == kind) {
            jj_gen++;
            if (++jj_gc > 100) {
                jj_gc = 0;
                for (int i = 0; i < jj_2_rtns.length; i++) {
                    JJCalls c = jj_2_rtns[i];
                    while (c != null) {
                        if (c.gen < jj_gen) c.first = null;
                        c = c.next;
                    }
                }
            }
            return token;
        }
        token = oldToken;
        jj_kind = kind;
        throw generateParseException();
    }

    @SuppressWarnings("serial")
    static private final class LookaheadSuccess extends java.lang.Error { }
    final private LookaheadSuccess jj_ls = new LookaheadSuccess();
    private boolean jj_scan_token(int kind) {
        if (jj_scanpos == jj_lastpos) {
            jj_la--;
            if (jj_scanpos.next == null) {
                jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
            } else {
                jj_lastpos = jj_scanpos = jj_scanpos.next;
            }
        } else {
            jj_scanpos = jj_scanpos.next;
        }
        if (jj_rescan) {
            int i = 0; Token tok = token;
            while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
            if (tok != null) jj_add_error_token(kind, i);
        }
        if (jj_scanpos.kind != kind) return true;
        if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
        return false;
    }


    /** Get the next Token. */
    final public Token getNextToken() {
        if (token.next != null) token = token.next;
        else token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        jj_gen++;
        return token;
    }

    /** Get the specific Token. */
    final public Token getToken(int index) {
        Token t = token;
        for (int i = 0; i < index; i++) {
            if (t.next != null) t = t.next;
            else t = t.next = token_source.getNextToken();
        }
        return t;
    }

    private int jj_ntk_f() {
        if ((jj_nt=token.next) == null)
            return (jj_ntk = (token.next=token_source.getNextToken()).kind);
        else
            return (jj_ntk = jj_nt.kind);
    }

    private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
    private int[] jj_expentry;
    private int jj_kind = -1;
    private int[] jj_lasttokens = new int[100];
    private int jj_endpos;

    private void jj_add_error_token(int kind, int pos) {
        if (pos >= 100) {
            return;
        }

        if (pos == jj_endpos + 1) {
            jj_lasttokens[jj_endpos++] = kind;
        } else if (jj_endpos != 0) {
            jj_expentry = new int[jj_endpos];

            for (int i = 0; i < jj_endpos; i++) {
                jj_expentry[i] = jj_lasttokens[i];
            }

            for (int[] oldentry : jj_expentries) {
                if (oldentry.length == jj_expentry.length) {
                    boolean isMatched = true;

                    for (int i = 0; i < jj_expentry.length; i++) {
                        if (oldentry[i] != jj_expentry[i]) {
                            isMatched = false;
                            break;
                        }

                    }
                    if (isMatched) {
                        jj_expentries.add(jj_expentry);
                        break;
                    }
                }
            }

            if (pos != 0) {
                jj_lasttokens[(jj_endpos = pos) - 1] = kind;
            }
        }
    }

    /** Generate ParseException. */
    public ParseException generateParseException() {
        jj_expentries.clear();
        boolean[] la1tokens = new boolean[25];
        if (jj_kind >= 0) {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for (int i = 0; i < 8; i++) {
            if (jj_la1[i] == jj_gen) {
                for (int j = 0; j < 32; j++) {
                    if ((jj_la1_0[i] & (1<<j)) != 0) {
                        la1tokens[j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 25; i++) {
            if (la1tokens[i]) {
                jj_expentry = new int[1];
                jj_expentry[0] = i;
                jj_expentries.add(jj_expentry);
            }
        }
        jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        int[][] exptokseq = new int[jj_expentries.size()][];
        for (int i = 0; i < jj_expentries.size(); i++) {
            exptokseq[i] = jj_expentries.get(i);
        }
        return new ParseException(token, exptokseq, tokenImage);
    }

    /** Enable tracing. */
    final public void enable_tracing() {
    }

    /** Disable tracing. */
    final public void disable_tracing() {
    }

    private void jj_rescan_token() {
        jj_rescan = true;
        for (int i = 0; i < 8; i++) {
            try {
                JJCalls p = jj_2_rtns[i];

                do {
                    if (p.gen > jj_gen) {
                        jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
                        switch (i) {
                            case 0: jj_3_1(); break;
                            case 1: jj_3_2(); break;
                            case 2: jj_3_3(); break;
                            case 3: jj_3_4(); break;
                            case 4: jj_3_5(); break;
                            case 5: jj_3_6(); break;
                            case 6: jj_3_7(); break;
                            case 7: jj_3_8(); break;
                        }
                    }
                    p = p.next;
                } while (p != null);

            } catch(LookaheadSuccess ls) { }
        }
        jj_rescan = false;
    }

    private void jj_save(int index, int xla) {
        JJCalls p = jj_2_rtns[index];
        while (p.gen > jj_gen) {
            if (p.next == null) { p = p.next = new JJCalls(); break; }
            p = p.next;
        }

        p.gen = jj_gen + xla - jj_la;
        p.first = token;
        p.arg = xla;
    }

    static final class JJCalls {
        int gen;
        Token first;
        int arg;
        JJCalls next;
    }

}