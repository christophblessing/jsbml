/*
 * $Id: AssignmentRule.java 38 2009-11-05 15:50:38Z niko-rodrigue $
 * $URL: https://jsbml.svn.sourceforge.net/svnroot/jsbml/trunk/src/org/sbml/jsbml/AssignmentRule.java $
 *
 *
 *==================================================================================
 * Copyright (c) 2009 the copyright is held jointly by the individual
 * authors. See the file AUTHORS for the list of authors.
 *
 * This file is part of jsbml, the pure java SBML library. Please visit
 * http://sbml.org for more information about SBML, and http://jsbml.sourceforge.net/
 * to get the latest version of jsbml.
 *
 * jsbml is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * jsbml is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with jsbml.  If not, see <http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html>.
 *
 *===================================================================================
 *
 */

package org.sbml.jsbml.element;

import java.util.HashMap;

/**
 * @author Andreas Dr&auml;ger <a
 *         href="mailto:andreas.draeger@uni-tuebingen.de">
 *         andreas.draeger@uni-tuebingen.de</a>
 * 
 */
public class AssignmentRule extends Rule {

	/**
	 * 
	 */
	private String variableID;

	/**
	 * 
	 */
	public AssignmentRule() {
		super();
		this.variableID = null;
	}
	
	/**
	 * @param sb
	 */
	public AssignmentRule(AssignmentRule sb) {
		super(sb);
		this.variableID = sb.getVariable();
	}

	/**
	 * Takes level and version from the variable.
	 */
	public AssignmentRule(Symbol variable) {
		super(variable.getLevel(), variable.getVersion());
		this.variableID = variable.getId();
	}

	/**
	 * Takes level and version from the variable.
	 * 
	 * @param math
	 */
	public AssignmentRule(Symbol variable, ASTNode math) {
		super(math, variable.getLevel(), variable.getVersion());
		this.variableID = variable.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sbml.MathContainer#clone()
	 */
	// @Override
	public AssignmentRule clone() {
		return new AssignmentRule(this);
	}

	/**
	 * 
	 * @return
	 */
	public String getVariable() {
		return variableID;
	}

	/**
	 * 
	 * @return
	 */
	public Symbol getVariableInstance() {
		Symbol variable = null;
		if (getModel() != null){
			variable = getModel().findSymbol(this.variableID);
		}
		return variable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sbml.jsbml.Rule#isCompartmentVolume()
	 */
	@Override
	public boolean isCompartmentVolume() {
		return isSetVariable() && (getVariableInstance() instanceof Compartment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sbml.jsbml.Rule#isParameter()
	 */
	@Override
	public boolean isParameter() {
		return isSetVariable() && (getVariableInstance() instanceof Parameter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sbml.jsbml.Rule#isScalar()
	 */
	@Override
	public boolean isScalar() {
		// TODO
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isSetVariable() {
		if (getModel() == null){
			return false;
		}
		return getModel().findSymbol(this.variableID) != null;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isSetVariableID() {
		return variableID != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sbml.jsbml.Rule#isSpeciesConcentration()
	 */
	@Override
	public boolean isSpeciesConcentration() {
		return isSetVariable() && (getVariableInstance() instanceof Species);
	}

	/**
	 * 
	 * @param variable
	 */
	public void setVariable(String variable) {
		Symbol nsb = null;
		if (getModel() != null){
			nsb = getModel().findSymbol(variable);
		}
		if (nsb == null)
			throw new IllegalArgumentException(
					"Only the id of an existing Species, Compartments, or Parameters allowed as variables");
		setVariable(nsb);
	}
	
	/**
	 * 
	 * @param variableID
	 */
	public void setVariableID(String variableID) {
		this.variableID = variableID;
		stateChanged();
	}

	/**
	 * 
	 * @param variable
	 */
	public void setVariable(Symbol variable) {
		this.variableID = variable != null ? variable.getId() : null;
		stateChanged();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.sbml.jsbml.Rule#isSpeciesConcentration()
	 */
	@Override
	public boolean readAttribute(String attributeName, String prefix, String value){
		boolean isAttributeRead = super.readAttribute(attributeName, prefix, value);
		
		if (!isAttributeRead){
			if (attributeName.equals("variable")){
				this.setVariable(value);
				return true;
			}
		}
		return isAttributeRead;
	}
	
	@Override
	public HashMap<String, String> writeXMLAttributes() {
		HashMap<String, String> attributes = super.writeXMLAttributes();
		
		if (isSetVariableID()){
			attributes.put("variable", getVariable());
		}

		return attributes;
	}

}
