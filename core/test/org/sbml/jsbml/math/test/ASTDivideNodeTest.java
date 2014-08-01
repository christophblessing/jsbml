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

import org.junit.Test;
import org.sbml.jsbml.ASTNode.Type;
import org.sbml.jsbml.math.ASTCnIntegerNode;
import org.sbml.jsbml.math.ASTDivideNode;


/**
 * Test cases for {@link ASTDivideNode}
 * 
 * @author Victor Kofia
 * @version $Rev$
 * @since 1.0
 * @date Jul 25, 2014
 */
public class ASTDivideNodeTest {

  /**
   * Test method for {@link org.sbml.jsbml.math.ASTDivideNode#clone()}.
   */
  @Test
  public final void testClone() {
    ASTDivideNode divide = new ASTDivideNode();
    ASTDivideNode unknown = divide.clone();
    assertTrue(divide.equals(unknown));
  }

  /**
   * Test method for {@link org.sbml.jsbml.math.ASTDivideNode#clone()}.
   */
  @Test
  public final void testCloneWithChildren() {
    ASTDivideNode divide = new ASTDivideNode(new ASTCnIntegerNode(1), new ASTCnIntegerNode(2));
    ASTDivideNode unknown = divide.clone();
    assertTrue(divide.equals(unknown));
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTDivideNode#ASTDivideNode(org.sbml.jsbml.math.ASTDivideNode)}.
   */
  @Test
  public final void testCloneWithConstructor() {
    ASTDivideNode divide = new ASTDivideNode();
    ASTDivideNode unknown = new ASTDivideNode(divide);
    assertTrue(divide.equals(unknown));
  }
  
  /**
   * Test method for {@link org.sbml.jsbml.math.ASTDivideNode#isAllowableType(org.sbml.jsbml.ASTNode.Type)}.
   */
  @Test
  public final void testIsAllowableType() {
    ASTDivideNode divide = new ASTDivideNode();
    assertTrue(divide.isAllowableType(Type.DIVIDE) && !divide.isAllowableType(null));
  }
  
}