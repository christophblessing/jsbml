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

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.sbml.jsbml.PropertyUndefinedError;
import org.sbml.jsbml.ASTNode.Type;
import org.sbml.jsbml.math.ASTBoolean;


/**
 * Test cases for {@link ASTBoolean}
 * 
 * @author Victor Kofia
 * @version $Rev$
 * @since 1.0
 * @date Jul 18, 2014
 */
public class ASTBooleanTest {
  
  @Rule
  public ExpectedException exception = ExpectedException.none();
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#clone()}.
   */
  @Test
  public final void testClone() {
    ASTBoolean node = new ASTBoolean(Type.CONSTANT_TRUE);
    ASTBoolean unknown = node.clone();
    assertTrue(unknown.equals(node));
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#ASTBoolean(org.sbml.jsbml.math.ASTBoolean)}.
   */
  @Test
  public final void testConstructorClone() {
    ASTBoolean node = new ASTBoolean(Type.CONSTANT_TRUE);
    ASTBoolean unknown = new ASTBoolean(node);
    assertTrue(unknown.equals(node));
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#ASTBoolean#getAllowsChildren()}.
   */
  @Test
  public final void testGetAllowsChildren() {
    ASTBoolean node = new ASTBoolean(Type.CONSTANT_TRUE);
    assertFalse(node.getAllowsChildren());
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#ASTBoolean#getChildAt()}.
   */
  @Test
  public final void testGetChildAt() {
    ASTBoolean node = new ASTBoolean(Type.CONSTANT_TRUE);
    exception.expect(IndexOutOfBoundsException.class);
    node.getChildAt(0);
  }

  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#ASTBoolean#getAllowsChildren()}.
   */
  @Test
  public final void testGetChildCount() {
    ASTBoolean node = new ASTBoolean(Type.CONSTANT_TRUE);
    assertTrue(node.getChildCount() == 0);
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#ASTBoolean#getValue()}.
   */
  @Test
  public final void testGetValueFalse() {
    ASTBoolean node = new ASTBoolean(Type.CONSTANT_FALSE);
    assertFalse(node.getValue());
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#ASTBoolean#getValue()}.
   */
  @Test
  public final void testGetValueNonStrictException() {
    ASTBoolean node = new ASTBoolean();
    node.setStrictness(false);
    assertFalse(node.getValue());
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#ASTBoolean#getValue()}.
   */
  @Test
  public final void testGetValueStrictException() {
    ASTBoolean node = new ASTBoolean();
    exception.expect(PropertyUndefinedError.class);
    node.getValue();
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#ASTBoolean#getValue()}.
   */
  @Test
  public final void testGetValueTrue() {
    ASTBoolean node = new ASTBoolean(Type.CONSTANT_TRUE);
    assertTrue(node.getValue());
  }

  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#isAllowableType()}.
   */
  @Test
  public final void testIsAllowableTypeCONSTANT_FALSE() {
    ASTBoolean node = new ASTBoolean();
    assertTrue(node.isAllowableType(Type.CONSTANT_FALSE));
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#isAllowableType()}.
   */
  @Test
  public final void testIsAllowableTypeCONSTANT_TRUE() {
    ASTBoolean node = new ASTBoolean();
    assertTrue(node.isAllowableType(Type.CONSTANT_TRUE));
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#isAllowableType()}.
   */
  @Test
  public final void testIsAllowableTypeNull() {
    ASTBoolean node = new ASTBoolean();
    assertFalse(node.isAllowableType(null));
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#isSetType()}.
   */
  @Test
  public final void testIsSetTypeCONSTANT_FALSE() {
    ASTBoolean node = new ASTBoolean(Type.CONSTANT_FALSE);
    assertTrue(node.isSetType());
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#isSetType()}.
   */
  @Test
  public final void testIsSetTypeCONSTANT_TRUE() {
    ASTBoolean node = new ASTBoolean(Type.CONSTANT_TRUE);
    assertTrue(node.isSetType());
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#isSetType()}.
   */
  @Test
  public final void testIsSetTypeNull() {
    ASTBoolean node = new ASTBoolean();
    assertFalse(node.isSetType());
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#setValue()}.
   */
  @Test
  public final void testSetValueFalse() {
    ASTBoolean node = new ASTBoolean();
    node.setValue(false);
    assertTrue(node.getType() == Type.CONSTANT_FALSE);
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTBoolean#setValue()}.
   */
  @Test
  public final void testSetValueTrue() {
    ASTBoolean node = new ASTBoolean();
    node.setValue(true);
    assertTrue(node.getType() == Type.CONSTANT_TRUE);
  }

}