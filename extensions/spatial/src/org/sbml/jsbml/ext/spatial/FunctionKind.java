/*
 * $Id: BoundaryConditionKind.java 2109 2015-01-05 04:50:45Z pdp10 $
 * $URL: svn+ssh://pdp10@svn.code.sf.net/p/jsbml/code/trunk/extensions/spatial/src/org/sbml/jsbml/ext/spatial/FunctionKind.java $
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 *
 * Copyright (C) 2009-2015 jointly by the following organizations:
 * 1. The University of Tuebingen, Germany
 * 2. EMBL European Bioinformatics Institute (EBML-EBI), Hinxton, UK
 * 3. The California Institute of Technology, Pasadena, CA, USA
 * 4. The University of California, San Diego, La Jolla, CA, USA
 * 5. The Babraham Institute, Cambridge, UK
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation. A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as <http://sbml.org/Software/JSBML/License>.
 * ----------------------------------------------------------------------------
 */
package org.sbml.jsbml.ext.spatial;

/**
 * This enum type was created following the specifications defined in Spatial Package v0.90.
 * @author Alex Thomas
 * @author Andreas Dr&auml;ger
 * @version $Rev: 2205 $
 * @since 1.0
 * @date 10.12.2014
 */
public enum FunctionKind {
  /**
   * Math child element contains an inequality
   */
  LAYERED,
  //    /**
  //     * Shape is represented by a real-valued function whose sign
  //     * indicates coverage by the shape
  //     */
  //    R_FUNCTION;
}