/*
 * $Id$
 * $URL$
 *
 * 
 *==================================================================================
 * Copyright (c) 2009 The jsbml team.
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

package org.sbml.jsbml;

import java.util.HashMap;

import javax.swing.tree.TreeNode;

/**
 * Represents the species XML element of a SBML file.
 * 
 * @author Andreas Dr&auml;ger
 * @author marine
 * 
 * @opt attributes
 * @opt types
 * @opt visibility
 * @has 0..1 type 1..* SpeciesType
 */
public class Species extends Symbol {

	/**
	 * True means initial amount is set. False means that an initial
	 * concentration is set.
	 */
	private boolean amount;

	/**
	 * Represents the 'boundaryCondition' attribute of a Species element.
	 */
	private Boolean boundaryCondition;
	private boolean isSetBoundaryCondition = false;

	/**
	 * Represents the 'charge' attribute of a Species element.
	 */
	@Deprecated
	private Integer charge;
	/**
	 * Represents the 'compartment' attribute of a Species element.
	 */
	private String compartmentID;
	/**
	 * Represents the 'conversionFactor' attribute of a Species element.
	 */
	private String conversionFactorID;
	/**
	 * Represents the 'hasOnlySubstanceUnits' attribute of a Species element.
	 */
	private Boolean hasOnlySubstanceUnits;
	private boolean isSetHasOnlySubstanceUnits = false;

	/**
	 * Boolean value to test if the charge has been set.
	 */
	private boolean isSetCharge;
	/**
	 * Represents the 'spatialSizeUnits' attribute of a Species element.
	 */
	@Deprecated
	private String spatialSizeUnitsID;

	/**
	 * Represents the 'speciesType' attribute of a Species element.
	 */
	@Deprecated
	private String speciesTypeID;

	/**
	 * Creates a Species instance. By default, the charge, compartmentID,
	 * speciesTypeID, conversionFactorID, hasOnlySubstanceUnits,
	 * boundaryCondition are null.
	 */
	public Species() {
		super();
		initDefaults();
	}

	/**
	 * Creates a Species instance from a level and version. By default, the
	 * charge, compartmentID, speciesTypeID, conversionFactorID,
	 * hasOnlySubstanceUnits, boundaryCondition are null.
	 * 
	 * @param level
	 * @param version
	 */
	public Species(int level, int version) {
		this(null, null, level, version);
	}

	/**
	 * Creates a Species instance from a Species.
	 * 
	 * @param species
	 */
	public Species(Species species) {
		super(species);
		initDefaults();
		if (species.isSetBoundaryCondition()) {
			setBoundaryCondition(species.getBoundaryCondition());
		}
		if (species.isSetCharge()) {
			setCharge(species.getCharge());
		}
		if (species.isSetCompartment()) {
			setCompartment(new String(species.getCompartment()));
		}
		if (species.isSetSubstanceUnits()) {
			setSubstanceUnits(new String(species.getSubstanceUnits()));
		}
		if (species.isSetHasOnlySubstanceUnits()) {
			setHasOnlySubstanceUnits(new Boolean(species
					.getHasOnlySubstanceUnits()));
		}
		if (species.isSetInitialAmount()) {
			setInitialAmount(new Double(species.getInitialAmount()));
		} else if (species.isSetInitialConcentration()) {
			setInitialConcentration(species.getInitialConcentration());
		} else {
			setValue(Double.NaN);
		}
		if (species.isSetConstant()) {
			setConstant(new Boolean(species.getConstant()));
		}
		if (species.isSetSpatialSizeUnits()) {
			setSpatialSizeUnits(new String(species.getSpatialSizeUnits()));
		} else {
			this.spatialSizeUnitsID = null;
		}
	}

	/**
	 * Creates a Species instance from a level and verison. By default, the
	 * charge, compartmentID, speciesTypeID, conversionFactorID,
	 * hasOnlySubstanceUnits, boundaryCondition are null.
	 * 
	 * @param id
	 * @param level
	 * @param version
	 */
	public Species(String id, int level, int version) {
		this(id, null, level, version);
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param level
	 * @param version
	 */
	public Species(String id, String name, int level, int version) {
		super(id, name, level, version);
		initDefaults();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sbml.jsbml.Symbol#clone()
	 */
	@Override
	public Species clone() {
		return new Species(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sbml.jsbml.Symbol#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Species) {
			boolean equal = super.equals(o);
			Species s = (Species) o;
			equal &= s.getBoundaryCondition() == getBoundaryCondition();
			equal &= s.getHasOnlySubstanceUnits() == getHasOnlySubstanceUnits();
			equal &= s.getCharge() == getCharge();
			equal &= s.isSetCompartment() == isSetCompartment();
			equal &= s.isSetSpeciesType() == isSetSpeciesType();

			if (equal && isSetSpeciesType()) {
				equal &= s.getSpeciesType().equals(getSpeciesType());
			}
			if (equal && isSetCompartment()) {
				equal &= s.getCompartment().equals(getCompartment());
			}
			equal &= s.isSetInitialAmount() == isSetInitialAmount();
			if (equal && isSetInitialAmount()) {
				equal &= s.getInitialAmount() == getInitialAmount();
			} else if (equal && isSetInitialConcentration()) {
				equal &= s.getInitialConcentration() == getInitialConcentration();
			}
			equal &= s.isSetSpatialSizeUnits() == isSetSpatialSizeUnits();

			if (equal && isSetSpatialSizeUnits()) {
				equal &= s.getSpatialSizeUnits().equals(getSpatialSizeUnits());
			}
			return equal;
		}
		return false;
	}

	/**
	 * 
	 * @return the boundaryCondition Boolean of this Species.
	 */
	public boolean getBoundaryCondition() {
		return isSetBoundaryCondition() ? boundaryCondition : false;
	}

	/**
	 * 
	 * @return the charge value of this Species if it is set, 0 otherwise.
	 */
	@Deprecated
	public int getCharge() {
		return isSetCharge() ? this.charge : 0;
	}

	/**
	 * 
	 * @return the compartmentID of this Species. The empty String if it is not
	 *         set.
	 */
	public String getCompartment() {
		return isSetCompartment() ? compartmentID : "";
	}

	/**
	 * 
	 * @return The Compartment instance which as the compartmentID of this
	 *         Species as id. Null if it doesn't exist.
	 */
	public Compartment getCompartmentInstance() {
		if (getModel() == null) {
			return null;
		}
		return getModel().getCompartment(this.compartmentID);
	}

	/**
	 * 
	 * @return the conversionFactorID of this Species.
	 */
	public String getConversionFactor() {
		return conversionFactorID;
	}

	/**
	 * 
	 * @return the Parameter instance which has the conversionFactorID of this
	 *         Species as id, null if it doesn't exist.
	 */
	public Parameter getConversionFactorInstance() {
		if (getModel() == null) {
			return null;
		}
		return getModel().getParameter(this.conversionFactorID);
	}

	/**
	 * 
	 * @return the hasOnlySubstanceUnits Boolean of this Species.
	 */
	public boolean getHasOnlySubstanceUnits() {
		return hasOnlySubstanceUnits();
	}

	/**
	 * 
	 * @return the initialAmount of this Species if it has been set, o
	 *         otherwise.
	 */
	// TODO : check libsbml implementation. Should we return NaN instead ?
	public double getInitialAmount() {
		if (isSetInitialAmount()) {
			return getValue();
		}
		return 0;
	}

	/**
	 * 
	 * @return the initialConcentration of this Species if it has been set, o
	 *         otherwise.
	 */
	public double getInitialConcentration() {
		if (isSetInitialConcentration()) {
			return getValue();
		}
		return 0;
	}

	/**
	 * 
	 * @return the spatialSizeUnits of this Species.
	 */
	@Deprecated
	public String getSpatialSizeUnits() {
		return isSetSpatialSizeUnits() ? spatialSizeUnitsID : "";
	}

	/**
	 * 
	 * @return The UnitDefinition instance which as the spatialSizeUnitsID of
	 *         this Species as id. Null if it doesn't exist.
	 */
	public UnitDefinition getSpatialSizeUnitsInstance() {
		if (getModel() == null) {
			return null;
		}
		return getModel().getUnitDefinition(this.spatialSizeUnitsID);
	}

	/**
	 * 
	 * @return the speciesTypeID of this Species. The empty String if it is not
	 *         set.
	 */
	@Deprecated
	public String getSpeciesType() {
		return isSetSpeciesType() ? this.speciesTypeID : "";
	}

	/**
	 * 
	 * @return the SpeciesType instance which has the speciesTypeID of this
	 *         Species as id. Null if it doesn't exist.
	 */
	@Deprecated
	public SpeciesType getSpeciesTypeInstance() {
		if (getModel() == null) {
			return null;
		}
		return getModel().getSpeciesType(this.speciesTypeID);
	}

	/**
	 * 
	 * @return the substanceUnitsID of this Species.
	 */
	public String getSubstanceUnits() {
		return getUnits();
	}

	/**
	 * 
	 * @return The UnitsDefinition instance which has the substanceUnistID of
	 *         this Species as id.
	 */
	public UnitDefinition getSubstanceUnitsInstance() {
		return getUnitsInstance();
	}

	/**
	 * 
	 * @return
	 */
	public boolean hasOnlySubstanceUnits() {
		return isSetHasOnlySubstanceUnits() ? this.hasOnlySubstanceUnits
				: false;
	}

	/**
	 * Initialises the default values of this Species.
	 */
	public void initDefaults() {
		amount = true;
		if (getLevel() < 3) {
			hasOnlySubstanceUnits = new Boolean(false);
			boundaryCondition = new Boolean(false);
			constant = new Boolean(false);
		} else {
			hasOnlySubstanceUnits = null;
			boundaryCondition = null;
			constant = null;
		}
	}

	/**
	 * 
	 * @return the value of the boundaryCondition Boolean if it is set, false
	 *         otherwise.
	 */
	public boolean isBoundaryCondition() {
		return isSetBoundaryCondition() ? boundaryCondition : false;
	}

	/**
	 * 
	 * @return the value of the hasOnlySubstanceUnits Boolean if it is set,
	 *         false otherwise.
	 */
	public boolean isHasOnlySubstanceUnits() {
		return hasOnlySubstanceUnits();
	}

	/**
	 * 
	 * @return true if the boundaryCondition of this Species is not null.
	 */
	public boolean isSetBoundaryCondition() {
		return isSetBoundaryCondition;
	}

	/**
	 * 
	 * @return true if the charge of this Species if not null.
	 */
	public boolean isSetCharge() {
		return isSetCharge;
	}

	/**
	 * 
	 * @return true if the compartmentID of this Species is not null.
	 */
	public boolean isSetCompartment() {
		return compartmentID != null;
	}

	/**
	 * 
	 * @return true if the Compartment instance which has the compartmentID of
	 *         this Species as id is not null.
	 */
	public boolean isSetCompartmentInstance() {
		if (getModel() == null) {
			return false;
		}
		return getModel().getCompartment(this.compartmentID) != null;
	}

	/**
	 * 
	 * @return true if the conversionFactorID of this Species is not null.
	 */
	public boolean isSetConversionFactor() {
		return conversionFactorID != null;
	}

	/**
	 * 
	 * @return true if the Parameter which has the conversionFactorID of this
	 *         Species as id is not null.
	 */
	public boolean isSetConversionFactorInstance() {
		if (getModel() == null) {
			return false;
		}
		return getModel().getParameter(this.conversionFactorID) != null;
	}

	/**
	 * 
	 * @return true if the hasOnlySubstanceUnits of this Species is not null.
	 */
	public boolean isSetHasOnlySubstanceUnits() {
		return isSetHasOnlySubstanceUnits;
	}

	/**
	 * 
	 * @return Returns true if an initial amount has been set for this species.
	 */
	public boolean isSetInitialAmount() {
		return amount && isSetValue();
	}

	/**
	 * 
	 * @return Returns true if an initial concentration has been set for this
	 *         species.
	 */
	public boolean isSetInitialConcentration() {
		return !amount && isSetValue();
	}

	/**
	 * 
	 * @return true if the spatialSizeUnits of this Species is not null.
	 */
	@Deprecated
	public boolean isSetSpatialSizeUnits() {
		return this.spatialSizeUnitsID != null;
	}

	/**
	 * 
	 * @return true if the UnitDefinition which has the spatialSizeUnitsID of
	 *         this Species as id is not null.
	 */
	public boolean isSetSpatialSizeUnitsInstance() {
		if (getModel() == null) {
			return false;
		}
		return getModel().getUnitDefinition(this.spatialSizeUnitsID) != null;
	}

	/**
	 * 
	 * @return true if the speciesTypeID of this Species is not null.
	 */
	public boolean isSetSpeciesType() {
		return speciesTypeID != null;
	}

	/**
	 * 
	 * @return true if the SpeciesType instance which has the speciesTypeID of
	 *         this Species as id is not null.
	 */
	@Deprecated
	public boolean isSetSpeciesTypeInstance() {
		if (getModel() == null) {
			return false;
		}
		return getModel().getSpeciesType(this.speciesTypeID) != null;
	}

	/**
	 * 
	 * @return true if the substanceUnitsID of this species is not null.
	 */
	public boolean isSetSubstanceUnits() {
		return isSetUnits();
	}

	/**
	 * 
	 * @return true if the UnitDefinition which has the substanceUnitsID of this
	 *         Species as id is not null.
	 */
	public boolean isSetSubstanceUnitsInstance() {
		return isSetUnitsInstance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sbml.jsbml.element.SBase#readAttribute(String attributeName,
	 * String prefix, String value)(
	 */
	@Override
	public boolean readAttribute(String attributeName, String prefix,
			String value) {
		boolean isAttributeRead = super.readAttribute(attributeName, prefix,
				value);

		if (!isAttributeRead) {
			if (attributeName.equals("compartment")) {
				this.setCompartment(value);
			} else if (attributeName.equals("initialAmount")) {
				this.setInitialAmount(Double.parseDouble(value));
			} else if (attributeName.equals("initialConcentration")
					&& getLevel() > 1) {
				this.setInitialConcentration(Double.parseDouble(value));
			} else if (attributeName.equals("substanceUnits") && getLevel() > 1) {
				this.setUnits(value);
			} else if (attributeName.equals("spatialSizeUnits")
					&& getLevel() > 1) {
				this.setSpatialSizeUnits(value);
			} else if (attributeName.equals("hasOnlySubstanceUnits")
					&& getLevel() > 1) {
				if (value.equals("true")) {
					this.setHasOnlySubstanceUnits(true);
					return true;
				} else if (value.equals("false")) {
					this.setHasOnlySubstanceUnits(false);
					return true;
				}
			} else if (attributeName.equals("boundaryCondition")) {
				if (value.equals("true")) {
					this.setBoundaryCondition(true);
					return true;
				} else if (value.equals("false")) {
					this.setBoundaryCondition(false);
					return true;
				}
			} else if (attributeName.equals("conversionFactor")
					&& getLevel() == 3) {
				this.setConversionFactor(value);
				return true;
			} else if (attributeName.equals("charge") && isSetLevel()
					&& getLevel() < 3) {
				this.setCharge(Integer.parseInt(value));
				return true;
			} else if (attributeName.equals("speciesType")
					&& ((getLevel() == 2 && getVersion() >= 2) || getLevel() == 3)) {
				this.setSpeciesType(value);
				return true;
			} else if (attributeName.equals("constant") && getLevel() > 1) {
				if (value.equals("true")) {
					this.setConstant(true);
					return true;
				} else if (value.equals("false")) {
					this.setConstant(false);
					return true;
				}
			}
		}
		return isAttributeRead;
	}

	/**
	 * Sets the boundaryCondition Boolean.
	 * 
	 * @param boundaryCondition
	 */
	public void setBoundaryCondition(Boolean boundaryCondition) {
		this.boundaryCondition = boundaryCondition;
		isSetBoundaryCondition = true;
		stateChanged();
	}

	/**
	 * Sets the charge of this Species.
	 * 
	 * @param charge
	 */
	public void setCharge(int charge) {
		this.charge = Integer.valueOf(charge);
		isSetCharge = true;
		stateChanged();
	}

	/**
	 * Sets the compartmentID of this Species to the id of 'compartment'.
	 * 
	 * @param compartment
	 */
	public void setCompartment(Compartment compartment) {
		if (compartment != null)
			setCompartment(compartment.getId());
		else
			unsetCompartment();
	}

	/**
	 * Sets the compartmentID of this Species to 'compartment'.
	 * 
	 * @param compartment
	 */
	public void setCompartment(String compartment) {
		if (compartment != null && compartment.trim().length() == 0) {
			this.compartmentID = null;
		} else {
			this.compartmentID = compartment;
		}
		stateChanged();
	}

	/**
	 * Sets the conversionFactorID of this Species to the id of
	 * 'conversionFactor'.
	 * 
	 * @param conversionFactor
	 */
	public void setConversionFactor(Parameter conversionFactor) {
		this.conversionFactorID = conversionFactor != null ? conversionFactor
				.getId() : null;
		stateChanged();
	}

	/**
	 * Sets the conversionFactorID of this Species to 'conversionFactorID'.
	 * 
	 * @param conversionFactorID
	 */
	public void setConversionFactor(String conversionFactorID) {
		if (conversionFactorID != null
				&& conversionFactorID.trim().length() == 0) {
			this.conversionFactorID = null;
		} else {
			this.conversionFactorID = conversionFactorID;
		}
		stateChanged();
	}

	/**
	 * Sets hasOnlySubstanceUnits Boolean
	 * 
	 * @param hasOnlySubstanceUnits
	 */
	public void setHasOnlySubstanceUnits(Boolean hasOnlySubstanceUnits) {
		this.hasOnlySubstanceUnits = hasOnlySubstanceUnits;
		isSetHasOnlySubstanceUnits = true;
		stateChanged();
	}

	/**
	 * Sets the initialAmount of this Species.
	 * 
	 * @param initialAmount
	 */
	public void setInitialAmount(double initialAmount) {
		amount = true;
		setValue(initialAmount);
	}

	/**
	 * Sets the initialConcentration of this Species.
	 * 
	 * @param initialConcentration
	 */
	public void setInitialConcentration(double initialConcentration) {
		amount = false;
		setValue(initialConcentration);

	}

	/**
	 * Sets the spatialSizeUnitsID of this Species to 'spatialSizeUnits'.
	 * 
	 * @param spatialSizeUnits
	 */
	public void setSpatialSizeUnits(String spatialSizeUnits) {
		if (spatialSizeUnits != null && spatialSizeUnits.trim().length() == 0) {
			this.spatialSizeUnitsID = null;
		} else {
			this.spatialSizeUnitsID = spatialSizeUnits;
		}
		stateChanged();
	}

	/**
	 * Sets the spatialSizeUnitsID of this Species to the id of
	 * 'spatialSizeUnits'.
	 * 
	 * @param spatialSizeUnits
	 */
	public void setSpatialSizeUnits(UnitDefinition spatialSizeUnits) {
		this.spatialSizeUnitsID = spatialSizeUnits != null ? spatialSizeUnits
				.getId() : null;
		stateChanged();
	}

	/**
	 * Sets the speciesTypeID of this Species to the id of 'speciesType'.
	 * 
	 * @param speciesType
	 */
	@Deprecated
	public void setSpeciesType(SpeciesType speciesType) {
		this.speciesTypeID = speciesType != null ? speciesType.getId() : null;
		stateChanged();
	}

	/**
	 * Sets the speciesTypeID of this Species to 'speciesType'.
	 * 
	 * @param speciesType
	 */
	@Deprecated
	public void setSpeciesType(String speciesType) {
		if (speciesType != null && speciesType.trim().length() == 0) {
			speciesType = null;
		} else {
			this.speciesTypeID = speciesType;
		}
		stateChanged();
	}

	/**
	 * Sets the substanceUnitsID to 'unit'.
	 * 
	 * @param unit
	 */
	public void setSubstanceUnits(String unit) {
		setUnits(unit);
	}

	/**
	 * Sets the substanceUnits.
	 * 
	 * @param unit
	 */
	public void setSubstanceUnits(Unit unit) {
		setUnits(unit);
	}

	/**
	 * Sets the substanceUnits.
	 * 
	 * @param unitKind
	 */
	public void setSubstanceUnits(Unit.Kind unitKind) {
		setUnits(unitKind);
	}

	/**
	 * Sets the substanceUnitsID to the id of 'units'.
	 * 
	 * @param units
	 */
	public void setSubstanceUnits(UnitDefinition units) {
		setUnits(units);
	}

	/**
	 * Unsets the charge of this Species
	 */
	public void unsetCharge() {
		charge = null;
		isSetCharge = false;
		stateChanged();
	}

	/**
	 * Remove the reference to a comparmtent.
	 */
	public void unsetCompartment() {
		compartmentID = null;
		stateChanged();
	}

	/**
	 * Unsets the conversionFactorID of this Species.
	 */
	public void unsetConversionFactor() {
		this.conversionFactorID = null;
		stateChanged();
	}

	/**
	 * Unsets the initialAmount of this Species.
	 */
	public void unsetInitialAmount() {
		amount = false;
		unsetValue();
	}

	/**
	 * Unsets the initialConcentration of this Species.
	 */
	public void unsetInitialConcentration() {
		amount = true;
		unsetValue();
	}

	/**
	 * Unsets the spatialSizeUnits of this Species
	 */
	public void unsetSpatialSizeUnits() {
		spatialSizeUnitsID = null;
		stateChanged();
	}

	/**
	 * Unsets the substanceUnits of this Species.
	 */
	public void unsetSubstanceUnits() {
		unsetUnits();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sbml.jsbml.element.SBase#writeXMLAttributes(
	 */
	@Override
	public HashMap<String, String> writeXMLAttributes() {
		HashMap<String, String> attributes = super.writeXMLAttributes();

		if (isSetCompartment()) {
			attributes.put("compartment", getCompartment());
		}
		if (isSetSpatialSizeUnits() && getLevel() == 2
				&& (getVersion() == 1 || getVersion() == 2)) {
			attributes.put("spatialSizeUnits", getSpatialSizeUnits());
		}
		if (isSetInitialAmount()) {
			attributes
					.put("initialAmount", Double.toString(getInitialAmount()));
		}
		if (isSetInitialConcentration() && getLevel() > 1) {
			attributes.put("initialConcentration", Double
					.toString(getInitialConcentration()));
		}
		if (isSetSubstanceUnits() && getLevel() > 1) {
			attributes.put("substanceUnits", getSubstanceUnits());
		}
		if (isSetHasOnlySubstanceUnits() && getLevel() > 1) {
			attributes.put("hasOnlySubstanceUnits", Boolean
					.toString(getHasOnlySubstanceUnits()));
		}
		if (isSetConstant() && getLevel() > 1) {
			attributes.put("constant", Boolean.toString(getConstant()));
		}
		if (isSetBoundaryCondition()) {
			attributes.put("boundaryCondition", Boolean
					.toString(getBoundaryCondition()));
		}
		if (isSetConversionFactor() && getLevel() == 3) {
			attributes.put("conversionFactor", getConversionFactor());
		}
		if (isSetCharge() && isSetLevel() && getLevel() < 3) {
			attributes.put("charge", Integer.toString(getCharge()));
		}
		if (isSetSpeciesType()
				&& ((getLevel() == 2 && getVersion() >= 2) || getLevel() == 3)) {
			attributes.put("speciesType", getSpeciesType());
		}

		return attributes;
	}
}
