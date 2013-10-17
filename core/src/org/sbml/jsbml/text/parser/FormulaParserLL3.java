/* Generated By:JavaCC: Do not edit this line. FormulaParserLL3.java */
/*
 * $Id$
 * $URL$
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 *
 * Copyright (C) 2009-2013 jointly by the following organizations:
 * 1. The University of Tuebingen, Germany
 * 2. EMBL European Bioinformatics Institute (EBML-EBI), Hinxton, UK
 * 3. The California Institute of Technology, Pasadena, CA, USA
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation. A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as <http://sbml.org/Software/JSBML/License>.
 * ----------------------------------------------------------------------------
 */

package org.sbml.jsbml.text.parser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import org.sbml.jsbml.ASTNode;
import org.sbml.jsbml.ASTNode.Type;
import org.sbml.jsbml.resources.Resource;
import org.sbml.jsbml.text.parser.IFormulaParser;

/**
 * Class used to parse infix mathematical formula and returns a representation of it as an Abstract Syntax Tree (AST)..
 *
 * <p/>Support almost the same syntax as defined in <a href="http://sbml.org/Software/libSBML/docs/java-api/org/sbml/libsbml/libsbml.html#parseL3Formula(java.lang.String)">
 * the LibSBML L3 parser</a>. The things not supported for now are the units associated with numbers.
 *
 * @author Alexander D&ouml;rr
 * @author Nicolas Rodriguez
 * @since 1.0
 * @version $Rev$
 *
 */
public class FormulaParserLL3 implements IFormulaParser, FormulaParserLL3Constants {

        public static Properties stringToType = new Properties();

        static
        {
      String path = "cfg/ASTNodeTokens.xml";
      try
      {
        stringToType.loadFromXML(Resource.class.getResourceAsStream(path));
      }
      catch (InvalidPropertiesFormatException e)
      {
        throw new RuntimeException("Invalid configuration file entries in file " + Resource.class.getResource(path), e);
      }
      catch (IOException e)
      {
        throw new RuntimeException("Could not read configuration file " + Resource.class.getResource(path), e);
      }
        }

  private void checkSize(ArrayList < ASTNode > arguments, int i) throws ParseException
  {
    if (arguments.size() > i)
    {
      throw new ParseException();
    }
  }

  private Integer getInteger(ASTNode node)
  {
    if (node.isUMinus())
    {
      if (node.getChild(0).isInteger())
      {
        return - node.getChild(0).getInteger();
      }
      else
      {
        return null;
      }
    }
    else
    {
      if (node.isInteger())
      {
        return node.getInteger();
      }
      else
      {
        return null;
      }
    }
  }

/**
 * Returns a piecewise {@link ASTNode} representing the modulo operation between the left and right child given.
 *
 * <p/> The fomula produced for 'a % b' or modulo(a, b) is 'piecewise(floor(a/b), gt(a/b, 0), ceil(a/b))'
 *
 * @param leftChild
 * @param rightChild
 * @return a piecewise {@link ASTNode} representing the modulo operation between the left and right child given.
 * @ see http://sbml.org/Documents/FAQ#Why_can.27t_I_use_the_.3Crem.3E_operator_in_SBML_MathML.3F
 */
  private ASTNode createModulo(ASTNode leftChild, ASTNode rightChild)
  {
      ASTNode node = new ASTNode(ASTNode.Type.FUNCTION_PIECEWISE);

          ASTNode floorNode = new ASTNode(ASTNode.Type.FUNCTION_FLOOR);
          ASTNode aDividedByB = new ASTNode(ASTNode.Type.DIVIDE);
          aDividedByB.addChild(leftChild);
          aDividedByB.addChild(rightChild);

          floorNode.addChild(aDividedByB);
          node.addChild(floorNode);

          ASTNode greaterThan = new ASTNode(ASTNode.Type.RELATIONAL_GT);
          greaterThan.addChild(aDividedByB.clone());
          greaterThan.addChild(new ASTNode(0));

          node.addChild(greaterThan);

          ASTNode ceilNode = new ASTNode(ASTNode.Type.FUNCTION_CEILING);
          ceilNode.addChild(aDividedByB.clone());

          node.addChild(ceilNode);

          return node;
  }

  final public Token string() throws ParseException {
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LOG:
      t = jj_consume_token(LOG);
      break;
    case STRING:
      t = jj_consume_token(STRING);
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  final public ASTNode parse() throws ParseException {
  ASTNode node = null;
    node = Expression();
    {if (true) return node;}
    throw new Error("Missing return statement in function");
  }

  final private ASTNode Expression() throws ParseException {
  ASTNode value = null;
    value = TermLvl1();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 0:
      jj_consume_token(0);
      break;
    case EOL:
      jj_consume_token(EOL);
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return value;}
    throw new Error("Missing return statement in function");
  }

  final private ASTNode TermLvl3() throws ParseException {
  ASTNode rightChild;
  ASTNode leftChild;
  ASTNode node = null;
    leftChild = Primary();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case POWER:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_1;
      }
      jj_consume_token(POWER);
      rightChild = Primary();
      node = new ASTNode(Type.POWER);
      node.addChild(leftChild);
      node.addChild(rightChild);
    }
    if (node == null)
    {
      node = leftChild;
    }

    {if (true) return node;}
    throw new Error("Missing return statement in function");
  }

  final private ASTNode TermLvl2() throws ParseException {
  ASTNode rightChild;
  ASTNode leftChild;
  ASTNode node = null;
    leftChild = TermLvl3();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TIMES:
      case DIVIDE:
      case MODULO:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TIMES:
        jj_consume_token(TIMES);
        rightChild = TermLvl3();
      node = new ASTNode('*');
      node.addChild(leftChild);
      node.addChild(rightChild);
        break;
      case DIVIDE:
        jj_consume_token(DIVIDE);
        rightChild = TermLvl3();
      Integer left, right;
      left = getInteger(leftChild);
      right = getInteger(rightChild);
      if (left != null && right != null)
      {
        node = new ASTNode();
        node.setValue(left, right);
      }
      else
      {
        node = new ASTNode('/');
        node.addChild(leftChild);
        node.addChild(rightChild);
      }
        break;
      case MODULO:
        jj_consume_token(MODULO);
        rightChild = TermLvl3();
      node = createModulo(leftChild, rightChild);
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    if (node == null)
    {
      node = leftChild;
    }

    {if (true) return node;}
    throw new Error("Missing return statement in function");
  }

  final private ASTNode TermLvl1() throws ParseException {
  ASTNode rightChild = null;
  ASTNode leftChild;
  ASTNode node = null;
  Token t;
  String s;
  Type type = null;
    leftChild = TermLvl2();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
      case COMPARISON:
      case BOOLEAN_LOGIC:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        rightChild = TermLvl2();
      node = new ASTNode('+');
      node.addChild(leftChild);
      node.addChild(rightChild);
        break;
      case MINUS:
        jj_consume_token(MINUS);
        rightChild = TermLvl2();
      node = new ASTNode('-');
      node.addChild(leftChild);
      node.addChild(rightChild);
        break;
      case BOOLEAN_LOGIC:
        t = jj_consume_token(BOOLEAN_LOGIC);
        rightChild = TermLvl2();
      s = t.image;
      if (s.equalsIgnoreCase("or") || s.equalsIgnoreCase("||"))
      {
        type = ASTNode.Type.LOGICAL_OR;
      }
      else if (s.equalsIgnoreCase("and") || s.equalsIgnoreCase("&&"))
      {
        type = ASTNode.Type.LOGICAL_AND;
      }
      else if (s.equalsIgnoreCase("xor"))
      {
        type = ASTNode.Type.LOGICAL_XOR;
      }
      node = new ASTNode(type);
      node.addChild(leftChild);
      node.addChild(rightChild);
        break;
      case COMPARISON:
        t = jj_consume_token(COMPARISON);
        rightChild = TermLvl2();
      s = t.image;
      if (s.equalsIgnoreCase("<"))
      {
        type = ASTNode.Type.RELATIONAL_LT;
      }
      else if (s.equalsIgnoreCase(">"))
      {
        type = ASTNode.Type.RELATIONAL_GT;
      }
      else if (s.equalsIgnoreCase("=="))
      {
        type = ASTNode.Type.RELATIONAL_EQ;
      }
      else if (s.equalsIgnoreCase("!="))
      {
        type = ASTNode.Type.RELATIONAL_NEQ;
      }
      else if (s.equalsIgnoreCase(">="))
      {
        type = ASTNode.Type.RELATIONAL_GEQ;
      }
      else if (s.equalsIgnoreCase("<="))
      {
        type = ASTNode.Type.RELATIONAL_LEQ;
      }
      node = new ASTNode(type);
      node.addChild(leftChild);
      node.addChild(rightChild);
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    if (node == null)
    {
      node = leftChild;
    }

    {if (true) return node;}
    throw new Error("Missing return statement in function");
  }

  final private ASTNode Primary() throws ParseException, NumberFormatException {
  Token t;
  double d;
  int i;
  ASTNode node = new ASTNode();
  ASTNode child, furtherChild;
  String s;
  String vals [ ];
  ArrayList < ASTNode > arguments = new ArrayList < ASTNode > ();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
      t = jj_consume_token(INTEGER);
    i = Integer.parseInt(t.image); // Could use StringTools.parseXXX methods here but not doing so allow to support different locale ??
    node.setValue(i);
    {if (true) return node;}
      break;
    case NUMBER:
      t = jj_consume_token(NUMBER);
    d = Double.parseDouble(t.image);
    node.setValue(d);
    {if (true) return node;}
      break;
    case EXPNUMBER:
      t = jj_consume_token(EXPNUMBER);
    s = t.image;
    vals = s.toLowerCase().split("e");
    if (vals [ 1 ].startsWith("+"))
    {
      i = Integer.parseInt(vals [ 1 ].substring(1));
    }
    else
    {
      i = Integer.parseInt(vals [ 1 ]);
    }
    node.setValue(Double.parseDouble(vals [ 0 ]), i);
    {if (true) return node;}
      break;
    default:
      jj_la1[8] = jj_gen;
      if (jj_2_1(2)) {
        t = string();
        jj_consume_token(OPEN_PAR);
        child = TermLvl1();
        label_4:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case SLPITTER:
            ;
            break;
          default:
            jj_la1[7] = jj_gen;
            break label_4;
          }
          jj_consume_token(SLPITTER);
          furtherChild = TermLvl1();
      arguments.add(furtherChild);
        }
        jj_consume_token(CLOSE_PAR);
    s = t.image;
    Type type = null;

    if (stringToType.containsKey(s.toLowerCase()))
    {
      type = ASTNode.Type.valueOf(stringToType.getProperty(s.toLowerCase()).toUpperCase());
    }
    if (s.equalsIgnoreCase("pow") || s.equalsIgnoreCase("power"))
    {
      checkSize(arguments, 1);
      node.addChild(child);
    }
    else if (s.equalsIgnoreCase("sqr"))
    {
      checkSize(arguments, 0);
      node.addChild(child);
      node.addChild(new ASTNode(2));
    }
    else if (s.equalsIgnoreCase("sqrt"))
    {
      checkSize(arguments, 0);
      node.addChild(new ASTNode(2));
      node.addChild(child);
    }
    else if (s.equalsIgnoreCase("not"))
    {
      checkSize(arguments, 0);
      node.addChild(child);
      type = Type.LOGICAL_NOT;
    }
    else if (s.equalsIgnoreCase("ln"))
    {
      checkSize(arguments, 0);
      node.addChild(child);
      type = Type.FUNCTION_LN;
    }
    else if (s.equalsIgnoreCase("lambda"))
    {
      node.addChild(child);
      type = Type.LAMBDA;
    }
    else if (s.equalsIgnoreCase("piecewise"))
    {
      node.addChild(child);
      type = Type.FUNCTION_PIECEWISE;
    }
    else if (s.equalsIgnoreCase("modulo") || s.equalsIgnoreCase("mod"))
    {
      checkSize(arguments, 1);
      ASTNode rightChild = arguments.get(0);
      arguments.clear();

          node = createModulo(child, rightChild);
          {if (true) return node;}
    }
    else
    {
      node.addChild(child);
    }
    if (type != null)
    {
      node.setType(type);
    }
    else
    {
      node.setName(s);
    }
    for (ASTNode argument : arguments)
    {
      node.addChild(argument);
    }
    {if (true) return node;}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case OPEN_PAR:
          jj_consume_token(OPEN_PAR);
          node = TermLvl1();
          jj_consume_token(CLOSE_PAR);
    {if (true) return node;}
          break;
        case MINUS:
          jj_consume_token(MINUS);
          node = Primary();
    ASTNode uiMinus = new ASTNode('-');
    uiMinus.addChild(node);
    {if (true) return uiMinus;}
          break;
        case NOT:
          jj_consume_token(NOT);
          node = TermLvl1();
    ASTNode not = new ASTNode(Type.LOGICAL_NOT);
    not.addChild(node);
    {if (true) return not;}
          break;
        case LOG:
          jj_consume_token(LOG);
          child = Primary();
    node = new ASTNode(Type.FUNCTION_LN);
    node.addChild(child);
    {if (true) return node;}
          break;
        case STRING:
          t = jj_consume_token(STRING);
    s = t.image;
    if (s.equalsIgnoreCase("true"))
    {
      node = new ASTNode(Type.CONSTANT_TRUE);
    }
    else if (s.equalsIgnoreCase("false"))
    {
      node = new ASTNode(Type.CONSTANT_FALSE);
    }
    else if (s.equalsIgnoreCase("pi"))
    {
      node = new ASTNode(Type.CONSTANT_PI);
    }
    else if (s.equalsIgnoreCase("avogadro"))
    {
      node = new ASTNode(Type.NAME_AVOGADRO);
    }
    else if (s.equalsIgnoreCase("time"))
    {
      node = new ASTNode(Type.NAME_TIME);
    }
    else if (s.equalsIgnoreCase("exponentiale"))
    {
      node = new ASTNode(Type.CONSTANT_E);
    }
    else if (s.equalsIgnoreCase("-infinity") || s.equalsIgnoreCase("-INF"))
    {
      node = new ASTNode(Double.NEGATIVE_INFINITY);
    }
    else if (s.equalsIgnoreCase("infinity") || s.equalsIgnoreCase("INF"))
    {
      node = new ASTNode(Double.POSITIVE_INFINITY);
    }
    else if (s.equalsIgnoreCase("NotANumber") || s.equalsIgnoreCase("NaN"))
    {
      node = new ASTNode(Double.NaN);
    }
    else
    {
      node = new ASTNode(s);
    }
    {if (true) return node;}
          break;
        default:
          jj_la1[9] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3_1() {
    if (jj_3R_5()) return true;
    if (jj_scan_token(OPEN_PAR)) return true;
    return false;
  }

  private boolean jj_3R_5() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(22)) {
    jj_scanpos = xsp;
    if (jj_scan_token(23)) return true;
    }
    return false;
  }

  /** Generated Token Manager. */
  public FormulaParserLL3TokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[10];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xc00000,0x4000001,0x200,0x3800,0x3800,0x30500,0x30500,0x80,0x68,0xe04400,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public FormulaParserLL3(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public FormulaParserLL3(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new FormulaParserLL3TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public FormulaParserLL3(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new FormulaParserLL3TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public FormulaParserLL3(FormulaParserLL3TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(FormulaParserLL3TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
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

  private int jj_ntk() {
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
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[27];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 10; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 27; i++) {
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
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
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
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
