/*
 * $Id: SpatialReactionPlugin.java 1445 2013-01-04 08:54:54Z andreas-draeger $
 * $URL: https://jsbml.svn.sourceforge.net/svnroot/jsbml/trunk/extensions/spatial/src/org/sbml/jsbml/ext/spatial/SpatialReactionPlugin.java $
 * ----------------------------------------------------------------------------
 * This file is part of JSBML. Please visit <http://sbml.org/Software/JSBML>
 * for the latest version of JSBML and more information about SBML.
 *
 * Copyright (C) 2009-2013 jointly by the following organizations:
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
 * @version $Rev: 1445 $
 */
public class SpatialReactionPlugin extends SpatialCallableSBase {

	/**
	 * Generated serial version identifier.
	 */
	private static final long serialVersionUID = -2154884901226244123L;

	/**
	 * 
	 */
	private Boolean isLocal;
	
	/**
	 * 
	 */
	public SpatialReactionPlugin() {
		super();
	}

	/**
	 * @param level
	 * @param version
	 */
	public SpatialReactionPlugin(int level, int version) {
		super(level, version);
	}
	
	/**
	 * @param sr
	 */
	public SpatialReactionPlugin(SpatialReactionPlugin sr) {
		super(sr);
		if (sr.isSetIsLocal()) {
			this.isLocal = Boolean.valueOf(sr.getIsLocal());
		}
	}

	/**
	 * @return
	 */
	public boolean isSetIsLocal() {
		return isLocal != null;
	}

	/* (non-Javadoc)
	 * @see org.sbml.jsbml.AbstractSBase#clone()
	 */
	@Override
	public SpatialReactionPlugin clone() {
		return new SpatialReactionPlugin(this);
	}

	/* (non-Javadoc)
	 * @see org.sbml.jsbml.AbstractSBase#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		boolean equal = super.equals(object);
		if (equal) {
			SpatialReactionPlugin sr = (SpatialReactionPlugin) object;
			equal &= sr.isSetIsLocal() == isSetIsLocal();
			if (equal && isSetIsLocal()) {
				equal &= sr.getIsLocal() == getIsLocal();
			}
		}
		return equal;
	}

	/**
	 * @return the isLocal
	 */
	public Boolean getIsLocal() {
		return isLocal;
	}
	
	/* (non-Javadoc)
	 * @see org.sbml.jsbml.AbstractSBase#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 953;
		int hashCode = super.hashCode();
		if (isSetIsLocal()) {
			hashCode += prime * isLocal.hashCode();
		}
		return hashCode;
	}
	
	/**
	 * @param isLocal the isLocal to set
	 */
	public void setIsLocal(Boolean isLocal) {
		this.isLocal = isLocal;
	}

}