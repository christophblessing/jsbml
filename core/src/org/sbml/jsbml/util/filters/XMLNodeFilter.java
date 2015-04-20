/*
 * $Id: XMLNodeFilter.java 2109 2015-01-05 04:50:45Z andreas-draeger $
 * $URL: svn://svn.code.sf.net/p/jsbml/code/trunk/core/src/org/sbml/jsbml/util/filters/XMLNodeFilter.java $
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
package org.sbml.jsbml.util.filters;

import org.sbml.jsbml.xml.XMLNode;
import org.w3c.dom.Element;

/**
 * Search recursively an {@link XMLNode} tree to find any {@link XMLNode} with a
 * certain local name and namespace. It is a bit equivalent to the DOM method
 * {@link Element#getElementsByTagNameNS(String, String)}.
 * 
 * @author Nicolas Rodriguez
 */
public class XMLNodeFilter implements Filter {

  /**
   * 
   */
  private String elementLocalName;

  /**
   * 
   */
  private String elementNamespaceURI;

  /**
   * 
   * @param elementName
   */
  public XMLNodeFilter(String elementName)
  {
    if (elementName == null || elementName.trim().length() == 0) {
      elementName = "*";
    }

    elementLocalName = elementName;
    elementNamespaceURI = "*";
  }

  /**
   * 
   * @param elementName
   * @param namespaceURI
   */
  public XMLNodeFilter(String elementName, String namespaceURI)
  {
    if ((elementName == null) || (elementName.trim().length() == 0)) {
      elementName = "*";
    }
    if ((namespaceURI == null) || (namespaceURI.trim().length() == 0)) {
      namespaceURI = "*";
    }

    elementLocalName = elementName;
    elementNamespaceURI = namespaceURI;
  }

  /* (non-Javadoc)
   * @see org.sbml.jsbml.util.filters.Filter#accepts(java.lang.Object)
   */
  @Override
  public boolean accepts(Object o) {

    if (o instanceof XMLNode && ((XMLNode) o).isElement())
    {
      XMLNode xmlNode = (XMLNode) o;

      if ((elementLocalName.equals(xmlNode.getName()) || elementLocalName.equals("*"))
          && (elementNamespaceURI.equals("*") || elementNamespaceURI.equals(xmlNode.getURI())))
      {
        return true;
      }
    }

    return false;
  }
}