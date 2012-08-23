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
package org.sbml.jsbml.ext.spatial;


/**
 * @author Andreas Dr&auml;ger
 * @since 1.0
 * @version $Rev$
 */
public class SpatialSymbolReference extends NamedSpatialElement implements
		SpatialParameterQualifier {

	/**
	 * Generated serial version identifier.
	 */
	private static final long serialVersionUID = -8906622500258765056L;
	
	/**
	 * 
	 */
	public SpatialSymbolReference() {
		super();
	}

	/**
	 * @param level
	 * @param version
	 */
	public SpatialSymbolReference(int level, int version) {
		super(level, version);
	}

	/**
	 * @param sb
	 */
	public SpatialSymbolReference(SpatialSymbolReference sb) {
		super(sb);
	}
	
	/* (non-Javadoc)
	 * @see org.sbml.jsbml.AbstractSBase#clone()
	 */
	@Override
	public SpatialSymbolReference clone() {
		return new SpatialSymbolReference(this);
	}

}