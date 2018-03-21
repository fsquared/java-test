package javaOne;

public class DataArray {
	  private Person[] elements;

	  private int elemIndex;
	  	  
	  DataArray(int size) {
		  elements = new Person[size];
		  
		  elemIndex = 0;
	  }
	  
	  private void insertAtPos(Person inPerson, int inPos) {
		  
		  if(elemIndex == elements.length)
			  return;
		  
		  for (int i=elemIndex; i > inPos; --i) {
			  elements[i] = elements[i - 1]; 
		  }
		  
		  elements[inPos] = inPerson;
		  
		  elemIndex++;
	  }
	  
	  void insert(Person inPerson) {
		  
		  if(elemIndex == elements.length)
			  return;
		  		  
		  boolean inserted = false;
		  for(int i = 0; i < elemIndex; ++i) {
			  if(0 < elements[i].getLast().compareTo(inPerson.getLast())) {
				  insertAtPos(inPerson, i);
				  inserted = true;
				  break;
			  }
		  }
		  
		  if (false == inserted)
			  insertAtPos(inPerson, elemIndex);
		  
	  }
	  
	  void display() {
		  
		  for(int i = 0; i < elemIndex; ++i)
		  	elements[i].display();
	  }
	  
}
