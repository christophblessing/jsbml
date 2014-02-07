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

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import de.zbit.util.ResourceManager;

/**
 * Contains some constants related to the spatial package.
 * 
 * @author Alex Thomas
 * @author Nicolas Rodriguez
 * @version $Rev$
 * @since 1.0
 * @date 17.10.2013
 */
public class SpatialConstants {

  /**
   * The namespace URI of this parser for SBML level 3, version 1 and package version 1.
   */
  public static final String namespaceURI_L3V1V1 = "http://www.sbml.org/sbml/level3/version1/spatial/version1";

  /**
   * The latest namespace URI of this parser, this value can change between releases.
   */
  public static final String namespaceURI = namespaceURI_L3V1V1;

  public static final String shortLabel = "spatial";
  public static final ResourceBundle bundle = ResourceManager.getBundle("org.sbml.jsbml.ext.spatial.Messages");


  public static final List<String> namespaces;

  static {
    namespaces = new ArrayList<String>();
    namespaces.add(namespaceURI_L3V1V1);
  }

  public static final String compartment = "compartment";
  public static final String unitSize = "unitSize";
  public static final String domain1 = "domain1";
  public static final String domain2 = "domain2";
  public static final String geometry = "geometry";
  public static final String isSpatial = "isSpatial";
  public static final String compartmentMapping = "compartmentMapping";
  public static final String packageName = "Spatial";
  public static final String coordinateSystem = "coordinateSystem";
  public static final String componentType = "componentType";
  public static final String index = "index";
  public static final String boundaryMaximum = "boundaryMax";
  public static final String boundaryMinimum = "boundaryMin";
  public static final String unit = "unit";
  public static final String value = "value";
  public static final String spatialId = "spatialId";
  public static final String spatialDimension = "spatialDimension";
  public static final String domainType = "domainType";
  public static final String coord1 = "coord1";
  public static final String coord2 = "coord2";
  public static final String coord3 = "coord3";
  public static final String functionType = "functionType";
  public static final String ordinal = "ordinal";
  public static final String sampledField = "sampledField";
  public static final String sampledValue = "sampledValue";
  public static final String minValue = "minValue";
  public static final String maxValue = "maxValue";
  public static final String dataType = "dataType";
  public static final String numSamples1 = "numSamples1";
  public static final String numSamples2 = "numSamples2";
  public static final String numSamples3 = "numSamples3";
  public static final String interpolationType = "interpolationType";
  public static final String encoding = "encoding";
  public static final String imageData = "imageData";
  public static final String csgNode = "csgNode";
  public static final String primitiveType = "csgObjectRef";
  public static final String translateX = "translateX";
  public static final String translateY = "translateY";
  public static final String translateZ = "translateZ";
  public static final String rotateAxisX = "rotateAxisX";
  public static final String rotateAxisY = "rotateAxisY";
  public static final String rotateAxisZ = "rotateAxisZ";
  public static final String rotateAngleInRadians = "rotateAngleInRadians";
  public static final String scaleX = "scaleX";
  public static final String scaleY = "scaleY";
  public static final String scaleZ = "scaleZ";
  public static final String components = "components";
  public static final String componentsLength = "componentsLength";
  public static final String domain = "domain";
  public static final String polygonType = "polygonType";
  public static final String polygonObject = "polygonObject";
  public static final String pointIndex = "pointIndex";
  public static final String samples = "samples";
  public static final String samplesLength = "samplesLength";
  public static final String forwardTransformation = "forwardTransformation";
  public static final String reverseTransformation = "reverseTransformation";
  public static final String operationType = "operationType";
  public static final String isLocal = "isLocal";
  public static final String type = "type";
  public static final String variable = "variable";
  public static final String coordinateBoundary = "coordinateBoundary";
  public static final String boundaryDomainType = "boundaryDomainType";


  /**
   * @param level
   * @param version
   * @return
   */
  public static String getNamespaceURI(int level, int version) {
    return namespaceURI;
  }

}