import java.util.*;

class Heap {
	private ArrayList<Woman> arr;
	private int heapsize, count; // count: includes both deleted nodes and nodes on heap 
	private HashMap<String, Integer> names;

	Heap() {
		arr = new ArrayList<Woman>();
		arr.add(null); // dummy
		heapsize = 0;
		names = new HashMap<String, Integer>();
		count = 0 ;
	}

	Heap(int size) {
		arr = new ArrayList<Woman>(size + 1);
		arr.add(null); // dummy
		heapsize = 0;
		names = new HashMap<String, Integer>(size * 4 / 3); // allowance for load
															// factor
		count = 0 ;
	}

	int parent(int i) {
		return i >> 1;
	} // shortcut for i / 2, round down

	int left(int i) {
		return i << 1;
	} // shortcut for 2 * i

	int right(int i) {
		return (i << 1) + 1;
	} // shortcut for 2 * i + 1

	void shiftUp(int i) { // swap nodes and update hashmap
		while (i > 1 && arr.get(parent(i)).compareTo(arr.get(i)) < 0) {
			Woman temp = arr.get(i);
			arr.set(i, arr.get(parent(i)));
			names.put(arr.get(i).name, i);
			arr.set(parent(i), temp);
			i = parent(i);
		}
		// update hash value of the node that has been pushed all the way up
		names.put(arr.get(i).name, i);
	}

	void heapInsert(String womanName, double dilation) {
		heapsize++;
		if (heapsize >= arr.size())
			arr.add(new Woman(womanName, dilation, ++count));
		else
			arr.set(heapsize, new Woman(womanName, dilation, ++count));

		shiftUp(heapsize);
	}

	void shiftDown(int i) {
		while (i <= heapsize) {
			Woman maxV = arr.get(i);
			int max_id = i;
			// compare value of this node with its left subtree, if possible
			if (left(i) <= heapsize && maxV.compareTo(arr.get(left(i))) < 0) {
				maxV = arr.get(left(i));
				max_id = left(i);
			}
			// now compare with its right subtree, if possible
			if (right(i) <= heapsize && maxV.compareTo(arr.get(right(i))) < 0) {
				maxV = arr.get(right(i));
				max_id = right(i);
			}

			if (max_id != i) { // swap nodes and update hashmap
				Woman temp = arr.get(i);
				arr.set(i, arr.get(max_id));
				names.put(arr.get(i).name, i);
				arr.set(max_id, temp);
				i = max_id;
			} else
				break;
		}
		// set the node that has been shifted all the way down
		names.put(arr.get(i).name, i);
	}

	Woman heapExtract(String womanName) {
		int i = names.get(womanName) ;
		Woman temp = arr.get(i);
		arr.set(i, arr.get(heapsize));
		heapsize--; // virtual decrease
		names.remove(womanName) ;
		
		// node will either be shifted up or down not both
		// node order remains unchanged if no shifting up is done
		shiftUp(i) ; 
		shiftDown(i);
		return temp;
	}

	void update(String womanName, double increaseDilation) {
		int i = names.get(womanName);
		arr.get(i).dilationStatus += increaseDilation;
		shiftUp(i); // shift if needed
	}

	Woman getMax() {
		return arr.get(1);
	}

	int size() {
		return heapsize;
	}

	boolean isEmpty() {
		return heapsize == 0;
	}
}
