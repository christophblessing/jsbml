/*
 * $Id:  SpatialTestModelWriter.java 14:31:11 draeger $
 * $URL: SpatialTestModelWriter.java $
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 * 
 * Copyright (C) 2009-2014  jointly by the following organizations:
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
package org.sbml.jsbml.ext.spatial.test;

import javax.xml.stream.XMLStreamException;

import org.sbml.jsbml.Compartment;
import org.sbml.jsbml.Model;
import org.sbml.jsbml.Reaction;
import org.sbml.jsbml.SBMLDocument;
import org.sbml.jsbml.SBMLException;
import org.sbml.jsbml.SBMLWriter;
import org.sbml.jsbml.Species;


/**
 * @author Andreas Dr&auml;ger
 * @version $Rev$
 * @since 1.0
 * @date 07.02.2014
 */
public class SpatialTestModelWriter {

  /**
   * @param args
   * @throws XMLStreamException
   * @throws SBMLException
   */
  public static void main(String[] args) throws SBMLException, XMLStreamException {
    SBMLDocument doc = new SBMLDocument(2, 4);
    Model model = doc.createModel("m1");
    Compartment comp = model.createCompartment("default");
    //    Species s1 = model.createSpecies("s1", comp);
    //    Species s2 = model.createSpecies("s2", comp);
    //    Species p1 = model.createSpecies("p1", comp);
    //    Reaction r1 = model.createReaction("r1");
    //    r1.setCompartment(comp);
    //    r1.createReactant(s1);
    //    r1.createReactant(s2);
    //    r1.createProduct(p1);


    SBMLWriter.write(doc, System.out, ' ', (short) 2);
  }
}