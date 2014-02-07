/*
 * $Id$
 * $URL$
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 *
 * Copyright (C) 2009-2014 jointly by the following organizations:
 * 1. The University of Tuebingen, Germany
 * 2. EMBL European Bioinformatics Institute (EBML-EBI), Hinxton, UK
 * 3. The California Institute of Technology, Pasadena, CA, USA
 * 4. The University of California, San Diego, La Jolla, CA, USA
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation. A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as <http://sbml.org/Software/JSBML/License>.
 * ----------------------------------------------------------------------------
 */
package org.sbml.jsbml.ext.spatial;

import java.text.MessageFormat;

import org.sbml.jsbml.Parameter;

/**
 * @author Alex Thomas
 * @author Andreas Dr&auml;ger
 * @since 1.0
 * @version $Rev$
 */
public class SpatialParameterPlugin extends AbstractSpatialSBasePlugin {


  /**
   * Generated serial version identifier.
   */
  private static final long serialVersionUID = -3766260342134204275L;

  /**
   * 
   */
  private ParameterType param;


  /*
   * (non-Javadoc)
   * @see org.sbml.jsbml.ext.AbstractSBasePlugin#getExtendedSBase()
   */
  @Override
  public Parameter getExtendedSBase() {
    return (Parameter) super.getExtendedSBase();
  }

  /**
   * 
   */
  public SpatialParameterPlugin() {
    super();
  }

  /**
   * @param sb
   */
  public SpatialParameterPlugin(SpatialParameterPlugin sb) {
    super(sb);
    if (sb.isSetParamType()) {
      param = sb.getParamType().clone();
    }
  }

  /**
   * @param model
   */
  public SpatialParameterPlugin(Parameter parameter) {
    super(parameter);
  }

  public ParameterType getParamType() {
    return isSetParamType() ? param : null;
  }

  public boolean isSetParamType() {
    return param != null ? true : false;
  }

  /**
   * @param qualifier the qualifier to set
   */
  public void setParamType(ParameterType param) {
    this.param = param;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractSBase#clone()
   */
  @Override
  public SpatialParameterPlugin clone() {
    return new SpatialParameterPlugin(this);
  }


  /*
   * (non-Javadoc)
   * This will force people to cast to the different forms of parameter types
   * @see javax.swing.tree.TreeNode#getChildAt(int)
   */
  @Override
  public ParameterType getChildAt(int index) {
    if (index < 0) {
      throw new IndexOutOfBoundsException(index + " < 0");
    }

    int pos = 0;

    if (isSetParamType()) {
      if (pos==index) {
        return getParamType();
      }
      pos++;
    }

    throw new IndexOutOfBoundsException(MessageFormat.format(
      "Index {0,number,integer} >= {1,number,integer}", index,pos));
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.AbstractSBase#getChildCount()
   */
  @Override
  public int getChildCount() {
    return isSetParamType() ? 1 : 0;
  }

  /*
   * (non-Javadoc)
   * @see javax.swing.tree.TreeNode#getAllowsChildren()
   */
  @Override
  public boolean getAllowsChildren() {
    return true;
  }


}