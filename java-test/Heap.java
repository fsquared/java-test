package javaOne;

class Heap

{

	private Node[] heapArray;
	private int nSize;

	Heap(int size) {
		heapArray = new Node[size];
		nSize = 0;
	}

	public void insert(Node nd){ 
		heapArray[nSize] = nd;
		
		//parent is (x - 1) / 2
		for (int i = nSize; i > 0; ) {
			int parent = (i - 1) / 2;
			Node tmp = heapArray[parent];
			if (tmp.getData() < nd.getData()) {
				heapArray[i] = tmp;
				heapArray[parent] = nd;
			}
			i = parent;
		}
		
		nSize++;

	}
	
	public Node remove() { 
		
		Node tmp = heapArray[0];
		nSize--;
		heapArray[0] = heapArray[nSize];
		heapArray[nSize] = null;
		
		//left child is 2 * x + 1
		//right child is 2 * x + 2
		for(int i = 0; i < nSize; ) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			//Node child_l = heapArray[left];
			//Node child_r = heapArray[right];
			Node parent = heapArray[i];
			
			if (heapArray[left] != null) {
				if(heapArray[right] != null)
				{
					if(heapArray[left].getData() > heapArray[right].getData()) {
						if(parent.getData() < heapArray[left].getData()) {
							heapArray[left] = parent;
							heapArray[i] = heapArray[left];
						}
						i = left;
					}
					else {
						if(parent.getData() < heapArray[right].getData()) {
							heapArray[right] = parent;
							heapArray[i] = heapArray[right];
						}
						i = right;
					}
				}
				else {
					if(parent.getData() < heapArray[left].getData()) {
						heapArray[left] = parent;
						heapArray[i] = heapArray[left];
					}
					i = left;
				}
				i = left;
			}
			else
				i = nSize;
		}
		
		return tmp;
	}

}