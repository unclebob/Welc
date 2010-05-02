package com.om.analysis;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InMemoryDirectory {
	private List<Element> elements = new ArrayList<Element>();

	public void addElement(Element newElement) {
		elements.add(newElement);
	}

	public void generateIndex() {
		Element index = new Element("index");
		for (Iterator<Element> it = elements.iterator(); it.hasNext();) {
			Element current = it.next();
			index.addText(current.getName());
		}
		addElement(index);
	}

	public int getElementCount() {
		return elements.size();
	}

	public Element getElement(String name) {
		for (Iterator<Element> it = elements.iterator(); it.hasNext();) {
			Element current = it.next();
			if (current.getName().equals(name)) {
				return current;
			}
		}
		return null;
	}
}
