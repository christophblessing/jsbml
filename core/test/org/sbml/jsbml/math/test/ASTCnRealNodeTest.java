/*
 * $Id$
 * $URL$
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
package org.sbml.jsbml.math.test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.sbml.jsbml.ASTNode.Type;
import org.sbml.jsbml.math.ASTCnRealNode;


/**
 * Test cases for {@link ASTCnRealNode}
 * 
 * @author Victor Kofia
 * @version $Rev$
 * @since 1.0
 * @date Jul 25, 2014
 */
public class ASTCnRealNodeTest {

  @Rule
  public ExpectedException exception = ExpectedException.none();

  /**
   * Test method for {@link org.sbml.jsbml.math.ASTCnRealNode#clone()}.
   */
  @Test
  public final void testClone() {
    ASTCnRealNode real = new ASTCnRealNode();
    ASTCnRealNode unknown = real.clone();
    assertTrue(real.equals(unknown));
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTCnRealNode#clone()}.
   */
  @Test
  public final void testCloneWithValue() {
    ASTCnRealNode real = new ASTCnRealNode(10.0);
    ASTCnRealNode unknown = real.clone();
    assertTrue(real.equals(unknown));
  }

  /**
   * Test method for {@link org.sbml.jsbml.math.ASTCnRealNode#ASTCnRealNode(org.sbml.jsbml.math.ASTCnRealNode)}.
   */
  @Test
  public final void testCloneWithConstructor() {
    ASTCnRealNode real = new ASTCnRealNode();
    ASTCnRealNode unknown = new ASTCnRealNode(real);
    assertTrue(real.equals(unknown));
  }

  /**
   * Test method for {@link org.sbml.jsbml.math.ASTCnRealNode#isAllowableType(org.sbml.jsbml.ASTNode.Type)}.
   */
  @Test
  public final void testIsAllowableType() {
    ASTCnRealNode real = new ASTCnRealNode();
    assertTrue(real.isAllowableType(Type.REAL) && !real.isAllowableType(null));
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTCnRealNode#isSetReal()}.
   */
  @Test
  public final void testIsSetReal() {
    ASTCnRealNode isSet = new ASTCnRealNode(10.0);
    ASTCnRealNode notSet = new ASTCnRealNode();
    assertTrue(isSet.isSetReal() && !notSet.isSetReal());
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTCnRealNode#getReal()}.
   */
  @Test
  public final void testNoValue() {
    ASTCnRealNode real = new ASTCnRealNode();
    assertTrue(Double.isNaN(real.getReal()));
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTCnRealNode#getReal()}.
   */
  @Test
  public final void testWithValue() {
    ASTCnRealNode real = new ASTCnRealNode(10.0);
    assertTrue(real.getReal() == 10.0);
  }
  
}