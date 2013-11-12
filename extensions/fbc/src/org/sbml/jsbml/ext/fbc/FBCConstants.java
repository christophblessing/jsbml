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
 * 4. The University of California, San Diego, La Jolla, CA, USA
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation. A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as <http://sbml.org/Software/JSBML/License>.
 * ----------------------------------------------------------------------------
 */
package org.sbml.jsbml.ext.fbc;

/**
 * 
 * @author Nicolas Rodriguez
 * @since 1.0
 * @version $Rev$
 */
public class FBCConstants {

	public static final String activeObjective = "activeObjective";
	/**
	 * The namespace URI of this parser.
	 */
	public static final String namespaceURI = "http://www.sbml.org/sbml/level3/version1/fbc/version1";
	
	/**
	 * 
	 */
	public static final String shortLabel = "fbc";
	
	/**
	 * 
	 */
	public static final String chemicalFormula = "chemicalFormula";
	
	/**
	 * 
	 */
	public static final String charge = "charge";
	
	/**
	 * 
	 */
	public static final int MIN_SBML_LEVEL = 3;
	
	/**
	 * 
	 */
	public static final int MIN_SBML_VERSION = 1;
	
  public static final String operation = "operation";
  public static final String reaction = "reaction";
  public static final String value = "value";
  public static final String type = "type";
  public static final String coefficient = "coefficient";
  public static final String listOfObjectives = "listOfObjectives";
	
	/**
	 * 
	 * @param level
	 * @param version
	 * @return
	 */
  public static String getNamespaceURI(int level, int version) {
    return namespaceURI;
  }

}