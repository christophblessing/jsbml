/*
 * $Id$
 * $URL$
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 *
 * Copyright (C) 2009-2012 jointly by the following organizations:
 * 1. The University of Tuebingen, Germany
 * 2. EMBL European Bioinformatics Institute (EBML-EBI), Hinxton, UK
 * 3. The California Institute of Technology, Pasadena, CA, USA
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation. A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as <http://sbml.org/Software/JSBML/License>.
 * ----------------------------------------------------------------------------
 */
package org.sbml.jsbml.ext.qual;

import java.util.Calendar;

import org.sbml.jsbml.ASTNode;
import org.sbml.jsbml.CVTerm;
import org.sbml.jsbml.Compartment;
import org.sbml.jsbml.Model;
import org.sbml.jsbml.SBMLDocument;
import org.sbml.jsbml.SBMLWriter;
import org.sbml.jsbml.test.gui.JSBMLvisualizer;
import org.sbml.jsbml.text.parser.ParseException;

/**
 * @author Florian Mittag
 * @version $Rev$
 * @since 1.0
 * @date 27.10.2011
 */
public class BuildToyModelTest {

  public static final String QUAL_NS = "http://www.sbml.org/sbml/level3/version1/qual/version1";
  
  public static final String QUAL_NS_PREFIX = "qual";
  
  
  /**
   * @param args
   */
public static void main(String[] args) {
    
    SBMLDocument sbmlDoc = new SBMLDocument(3, 1);
    sbmlDoc.addNamespace(QUAL_NS_PREFIX, "xmlns", QUAL_NS);
    
    // sbmlDoc.readAttribute("required", QUAL_NS_PREFIX, "true");
    sbmlDoc.getSBMLDocumentAttributes().put(QUAL_NS_PREFIX + ":required", "true");
    
    Model model = sbmlDoc.createModel("m_default_name");
    
    model.getHistory().addModifiedDate(Calendar.getInstance().getTime());
    model.getAnnotation().addCVTerm(new CVTerm(CVTerm.Qualifier.BQB_IS, "urn:miriam:obo.go:GO%3A1234567"));
    
    QualitativeModel qModel = new QualitativeModel(model);

    model.addExtension(QUAL_NS, qModel);

    // ListOfCompartments
    Compartment comp1 = model.createCompartment("comp1");
    comp1.setConstant(true);
    
    // ListOfQualitativeSpecies
    QualitativeSpecies g0 = qModel.createQualitativeSpecies("G0", comp1.getId(), false);
    g0.setMaxLevel(1);
    g0.setInitialLevel(0);
    
    g0.getAnnotation().addCVTerm(new CVTerm(CVTerm.Qualifier.BQB_IS, "urn:miriam:obo.go:GO%3A1234567"));
    g0.setNotes("<notes>\n\t<body xmlns=\"http://www.w3.org/1999/xhtml\">\n\t\t<p>TestNotes parsing &#285; &#65;</p>\n\t</body>\n</notes>");
    
    QualitativeSpecies g1 = qModel.createQualitativeSpecies("G1", comp1.getId(), false);
    g1.setName("G1 name");
    g1.setMaxLevel(3);
    g1.setInitialLevel(1);


    QualitativeSpecies g2 = qModel.createQualitativeSpecies("G2", comp1.getId(), false);
    g2.setMaxLevel(2);
    g2.setInitialLevel(2);

    g2.getAnnotation().addCVTerm(new CVTerm(CVTerm.Qualifier.BQB_IS, "urn:miriam:obo.go:GO%3A1234567"));
    g2.getHistory().addModifiedDate(Calendar.getInstance().getTime());
    
    QualitativeSpecies g3 = qModel.createQualitativeSpecies("G3", comp1.getId(), true);
    g3.setMaxLevel(1);
    g3.setInitialLevel(1);

    // ListOfTransitions
    Transition tr_g1 = qModel.createTransition("tr_G1");
    
    //// ListOfInputs
    Input in0 = tr_g1.createInput("in0", g0, InputTransitionEffect.consumption);
    in0.setSign(Sign.dual);
    Input in2 = tr_g1.createInput("in2", g2, InputTransitionEffect.none);
    Input in3 = tr_g1.createInput("in3", g3, InputTransitionEffect.none);
    
    
    //// ListOfOutputs
    Output out1 = tr_g1.createOutput("o1", g1, OutputTransitionEffect.assignmentLevel);
    
    //// ListOfFunctionTerms
    FunctionTerm defTerm = new FunctionTerm();
    defTerm.setDefaultTerm(true);
    defTerm.setResultLevel(0);

    FunctionTerm ft1 = new FunctionTerm();
    ft1.setResultLevel(1);

    ASTNode mathNode = null;
    try {
    	mathNode = ASTNode.parseFormula("G0 > 2");
        ft1.setMath(mathNode);
    } catch (ParseException e) {
    	e.printStackTrace();
    }
      
    tr_g1.addFunctionTerm(defTerm);
    tr_g1.addFunctionTerm(ft1);

    Input in4 = new Input("in4", g3, InputTransitionEffect.none);
    Output out2 = new Output("o2", g1, OutputTransitionEffect.assignmentLevel);

    Transition tr2 = qModel.createTransition("tr2", in4, out2); 
    
    FunctionTerm ft2 = new FunctionTerm();

    mathNode = null;
    try {
    	mathNode = ASTNode.parseFormula("7");
        ft2.setMath(mathNode);
    	mathNode.setUnits("dimensionless");
    	
    	System.out.println(mathNode.toMathML());
    	
    } catch (ParseException e) {
    	e.printStackTrace();
    }

    tr2.addFunctionTerm(ft2);
    
    String outFile = "testFile.xml";

    try {
        
        SBMLWriter.write(sbmlDoc, outFile, "BuildToyModelTest", "1");
     } catch (Exception e) {
       e.printStackTrace();
     }

    new JSBMLvisualizer(sbmlDoc); 
    
   

  }

}