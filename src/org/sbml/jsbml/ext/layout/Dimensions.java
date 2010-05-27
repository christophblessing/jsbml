/*
 * $Id$
 * $URL$
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

package org.sbml.jsbml.ext.layout;

import javax.swing.tree.TreeNode;

import org.sbml.jsbml.AbstractNamedSBase;

public class Dimensions extends AbstractNamedSBase {

	/**
	 * 
	 */
	private double width;
	/**
	 * 
	 */
	private double height;
	/**
	 * 
	 */
	private double depth;
	
	/**
	 * 
	 */
	public Dimensions() {
		
	}
	
	/**
	 * 
	 * @param level
	 * @param version
	 */
	public Dimensions(int level, int version) {
		super(level, version);
	}
	
	/**
	 * 
	 * @param dimensions
	 */
	public Dimensions(Dimensions dimensions) {
		super(dimensions);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public double getWidth() {
		return width;
	}


	/**
	 * 
	 * @param width
	 */
	public void setWidth(double width) {
		this.width = width;
	}


	/**
	 * 
	 * @return
	 */
	public double getHeight() {
		return height;
	}


	/**
	 * 
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
	}


	/**
	 * 
	 * @return
	 */
	public double getDepth() {
		return depth;
	}


	/**
	 * 
	 * @param depth
	 */
	public void setDepth(double depth) {
		this.depth = depth;
	}


	/*
	 * (non-Javadoc)
	 * @see org.sbml.jsbml.AbstractSBase#clone()
	 */
	@Override
	public Dimensions clone() {
		return new Dimensions(this);
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getAllowsChildren()
	 */
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildAt(int)
	 */
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.tree.TreeNode#getChildCount()
	 */
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
