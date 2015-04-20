/*
 * $Id: ASTHyperbolicNode.java 2037 2014-10-19 03:26:24Z kofiav $
 * $URL: svn://svn.code.sf.net/p/jsbml/code/branches/jsbml-1.0-ASTNode2/core/src/org/sbml/jsbml/math/ASTHyperbolicNode.java $
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 * 
 * Copyright (C) 2009-2014  jointly by the following organizations:
 * 1. The University of Tuebingen, Germany
 * 2. EMBL European Bioinformatics Institute (EBML-EBI), Hinxton, UK
 * 3. The California Institute of Technology, Pasadena, CA, USA
 * 4. The University of California, San Diego, La Jolla, CA, USA
 * 5. The Babraham Institute, Cambridge, UK
 * 6. The University of Toronto, Toronto, ON, Canada
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation. A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as <http://sbml.org/Software/JSBML/License>.
 * ----------------------------------------------------------------------------
 */
package org.sbml.jsbml.math;

import org.apache.log4j.Logger;
import org.sbml.jsbml.ASTNode.Type;
import org.sbml.jsbml.SBMLException;
import org.sbml.jsbml.math.compiler.ASTNode2Compiler;
import org.sbml.jsbml.math.compiler.ASTNode2Value;
import org.sbml.jsbml.math.compiler.FormulaCompiler;
import org.sbml.jsbml.math.compiler.LaTeXCompiler;
import org.sbml.jsbml.math.compiler.MathMLXMLStreamCompiler;


/**
 * An Abstract Syntax Tree (AST) node representing a hyperbolic function
 * 
 * @author Victor Kofia
 * @version $Rev: 2037 $
 * @since 1.0
 * @date May 30, 2014
 */
public class ASTHyperbolicNode extends ASTUnaryFunctionNode {

  /**
   * 
   */
  private static final long serialVersionUID = -3473804919513699915L;
  
  /**
   * A {@link Logger} for this class.
   */
  private static final Logger logger = Logger.getLogger(ASTHyperbolicNode.class);

  /**
   * Creates a new {@link ASTHyperbolicNode}.
   */
  public ASTHyperbolicNode() {
    super();
  }
  
  /**
   * Copy constructor; Creates a deep copy of the given {@link ASTHyperbolicNode}.
   * 
   * @param node
   *            the {@link ASTHyperbolicNode} to be copied.
   */
  public ASTHyperbolicNode(ASTHyperbolicNode node) {
    super(node);
  }

  /**
   * Creates a new {@link ASTHyperbolicNode} of type {@link Type}
   * 
   * @param type
   */
  public ASTHyperbolicNode(Type type) {
    this();
    setType(type);
  }
  
  /*
   * (non-Javadoc)
   * @see org.sbml.jsbml.math.ASTUnaryFunctionNode#clone()
   */
  @Override
  public ASTHyperbolicNode clone() {
    return new ASTHyperbolicNode(this);
  }
  
  /* (non-Javadoc)
   * @see org.sbml.jsbml.math.ASTNode2#compile(org.sbml.jsbml.util.compilers.ASTNode2Compiler)
   */
  @Override
  public ASTNode2Value<?> compile(ASTNode2Compiler compiler) {
    ASTNode2Value<?> value = null;
    switch(getType()) {
    case FUNCTION_ARCCOSH:
      value = compiler.arccosh(getChild());
      break;
    case FUNCTION_ARCCOTH:
      value = compiler.arccoth(getChild());
      break;
    case FUNCTION_ARCCSCH:
      value = compiler.arccsch(getChild());
      break;
    case FUNCTION_ARCSECH:
      value = compiler.arcsech(getChild());
      break;
    case FUNCTION_ARCSINH:
      value = compiler.arcsinh(getChild());
      break;
    case FUNCTION_ARCTANH:
      value = compiler.arctanh(getChild());
      break;
    case FUNCTION_COSH:
      value = compiler.cosh(getChild());
      break;
    case FUNCTION_COTH:
      value = compiler.coth(getChild());
      break;
    case FUNCTION_CSCH:
      value = compiler.csch(getChild());
      break;
    case FUNCTION_SECH:
      value = compiler.sech(getChild());
      break;
    case FUNCTION_SINH:
      value = compiler.sinh(getChild());
      break;
    case FUNCTION_TANH:
      value = compiler.tanh(getChild());
      break;
    default: // UNKNOWN:
      value = compiler.unknownValue();
      break;
    }
    return processValue(value);
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.math.ASTUnaryFunctionNode#isAllowableType(org.sbml.jsbml.ASTNode.Type)
   */
  @Override
  public boolean isAllowableType(Type type) {
    if (type != null) {
      switch(type) {
      case FUNCTION_ARCCOSH:
      case FUNCTION_ARCCOTH:
      case FUNCTION_ARCCSCH:
      case FUNCTION_ARCSECH:
      case FUNCTION_ARCSINH:
      case FUNCTION_ARCTANH:
      case FUNCTION_COSH:
      case FUNCTION_COTH:
      case FUNCTION_CSCH:
      case FUNCTION_SECH:
      case FUNCTION_SINH:
      case FUNCTION_TANH:
        return true;
      default:
        break;
      }
    }  
    return false;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.math.AbstractASTNode#toFormula()
   */
  @Override
  public String toFormula() throws SBMLException {
    return compile(new FormulaCompiler()).toString();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.math.AbstractASTNode#toLaTeX()
   */
  @Override
  public String toLaTeX() throws SBMLException {
    return compile(new LaTeXCompiler()).toString();
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.math.AbstractASTNode#toMathML()
   */
  @Override
  public String toMathML() {
    try {
      return MathMLXMLStreamCompiler.toMathML(this);
    } catch (RuntimeException e) {
      logger.error("Unable to create MathML");
      return null;
    }
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(getClass().getSimpleName());
    builder.append(" [strict=");
    builder.append(strict);
    builder.append(", type=");
    builder.append(isSetType() ? type : "null");
    builder.append(", id=");
    builder.append(isSetId() ? id : "null");
    builder.append(", style=");
    builder.append(isSetStyle() ? style : "null");
    builder.append(", class=");
    builder.append(isSetMathMLClass() ? mathMLClass : "null");
    builder.append("]");
    return builder.toString();
  }

}
