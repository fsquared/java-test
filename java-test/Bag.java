package javaOne;

import java.util.Iterator;
import java.util.Vector;

public class Bag {
	private Vector<Integer> elems;
	
	Bag() {
		elems = new Vector<Integer>();
	}
	
	void insert(int inValue) {
		elems.add(inValue);
	}
	
	Iterator<Integer> iterate() {
		return elems.iterator();
	}
}
