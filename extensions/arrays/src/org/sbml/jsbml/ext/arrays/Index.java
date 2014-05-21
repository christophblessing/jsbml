/*
 * $Id:  Index.java 1:28:55 PM lwatanabe $
 * $URL: Index.java $
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
 * 6. The University of Utah, Salt Lake City, UT, USA
 *
 * This library is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation. A copy of the license agreement is provided 
 * in the file named "LICENSE.txt" included with this software distribution 
 * and also available online as <http://sbml.org/Software/JSBML/License>. 
 * ---------------------------------------------------------------------------- 
 */
package org.sbml.jsbml.ext.arrays;

import java.util.Map;

import org.sbml.jsbml.AbstractMathContainer;
import org.sbml.jsbml.PropertyUndefinedError;
import org.sbml.jsbml.util.StringTools;


/**
 * @author Leandro Watanabe
 * @version $Rev$
 * @since 1.0
 * @date May 11, 2014
 */
public class Index extends AbstractMathContainer {

  
  /**
   * 
   */
  private static final long serialVersionUID = 2277400816974157871L;

  private String referencedAttribute;
  
  private int arrayDimension;
  
  private boolean isSetArrayDimension;
  
  
  /**
   * Creates an Index instance 
   */
  public Index() {
    super();
    initDefaults();
  }


  /**
   * Creates a Index instance with a level and version. 
   * 
   * @param level
   * @param version
   */
  public Index(int level, int version) {
    super(level, version);
  }


  /**
   * Clone constructor
   */
  public Index(Index obj) {
    super(obj);
    
    referencedAttribute = obj.referencedAttribute;
    arrayDimension = obj.arrayDimension;
   
  }


  /**
   * clones this class
   */
  @Override
  public Index clone() {
    return new Index(this);
  }


  /**
   * Initializes the default values using the namespace.
   */
  public void initDefaults() {
    setNamespace(ArraysConstants.namespaceURI);
    
    referencedAttribute = null;
    isSetArrayDimension = false;
    arrayDimension = -1;
  }


  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractSBase#toString()
   */
  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return null;
  }
  
  
  /**
   * Returns the value of referencedAttribute
   *
   * @return the value of referencedAttribute
   */
  public String getReferencedAttribute() {
    if (isSetReferencedAttribute()) {
      return referencedAttribute;
    }
    // This is necessary if we cannot return null here.
    throw new PropertyUndefinedError(ArraysConstants.referencedAttribute, this);
  }


  /**
   * Returns whether referencedAttribute is set 
   *
   * @return whether referencedAttribute is set 
   */
  public boolean isSetReferencedAttribute() {
    return referencedAttribute != null;
  }


  /**
   * Sets the value of referencedAttribute
   */
  public void setReferencedAttribute(String referencedAttribute) {
    String oldReferencedAttribute = this.referencedAttribute;
    this.referencedAttribute = referencedAttribute;
    firePropertyChange(ArraysConstants.referencedAttribute, oldReferencedAttribute, this.referencedAttribute);
  }


  /**
   * Unsets the variable referencedAttribute 
   *
   * @return {@code true}, if referencedAttribute was set before, 
   *         otherwise {@code false}
   */
  public boolean unsetReferencedAttribute() {
    if (isSetReferencedAttribute()) {
      String oldReferencedAttribute = referencedAttribute;
      referencedAttribute = null;
      firePropertyChange(ArraysConstants.referencedAttribute, oldReferencedAttribute, referencedAttribute);
      return true;
    }
    return false;
  }


  
  /**
   * Returns the value of arrayDimension
   *
   * @return the value of arrayDimension
   */
  public int getArrayDimension() {
    if (isSetArrayDimension()) {
      return arrayDimension;
    }
    // This is necessary if we cannot return null here.
    throw new PropertyUndefinedError(ArraysConstants.arrayDimension, this);
  }


  /**
   * Returns whether arrayDimension is set 
   *
   * @return whether arrayDimension is set 
   */
  public boolean isSetArrayDimension() {
    return isSetArrayDimension;
  }


  /**
   * Sets the value of arrayDimension
   */
  public void setArrayDimension(int arrayDimension) {
    int oldArrayDimension = this.arrayDimension;
    this.arrayDimension = arrayDimension;
    isSetArrayDimension = true;
    firePropertyChange(ArraysConstants.arrayDimension, oldArrayDimension, this.arrayDimension);
  }


  /**
   * Unsets the variable arrayDimension 
   *
   * @return {@code true}, if arrayDimension was set before, 
   *         otherwise {@code false}
   */
  public boolean unsetArrayDimension() {
    if (isSetArrayDimension()) {
      int oldArrayDimension = arrayDimension;
      arrayDimension = -1;
      isSetArrayDimension = false;
      firePropertyChange(ArraysConstants.arrayDimension, oldArrayDimension, arrayDimension);
      return true;
    }
    return false;
  }
  
  @Override
  public boolean readAttribute(String attributeName, String prefix, String value)
  {
    boolean isAttributeRead = super.readAttribute(attributeName, prefix, value);
    
    if(!isAttributeRead) {
      isAttributeRead = true;
      
      if(attributeName.equals(ArraysConstants.arrayDimension)) {
        setArrayDimension(StringTools.parseSBMLInt(value));
      }
      
      else if(attributeName.equals(ArraysConstants.referencedAttribute)) {
        setReferencedAttribute(value);
      }
      
      else {
        isAttributeRead = false;
      }
      
    }
    
    return isAttributeRead;
  }
  
  @Override
  public Map<String, String> writeXMLAttributes()
  {
  Map<String, String> attributes = super.writeXMLAttributes();
    
    if(isSetArrayDimension()) {
      attributes.remove("arrayDimension");
      attributes.put(ArraysConstants.shortLabel + ":arrayDimension", ""+getArrayDimension());
    }
    
    if(isSetReferencedAttribute()) {
      attributes.remove("referencedAttribute");
      attributes.put(ArraysConstants.shortLabel + ":referencedAttribute", getReferencedAttribute());
    }
    
    return attributes;
  }
  
}