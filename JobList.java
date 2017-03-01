import java.util.Iterator;

public class JobList implements ListADT<Job> {
	
	private Iterator<Job> iterator;
	private Listnode<Job> head, curr;
	private int numItems;
	
	public JobList() {
		head = new Listnode<Job>(null);
		curr = head;
		numItems = 0;
	}

	@Override
	public Iterator<Job> iterator() {
		iterator = new JobListIterator(head); 
		return iterator;
	}

	@Override
	public void add(Job item) throws IllegalArgumentException {
		if (item == null) {
			throw new IllegalArgumentException();
		}
		
		if (numItems == 0) {
			head.setData(item);
		}
		else {
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
			
			Listnode<Job> e = new Listnode<Job>(item);
			curr.setNext(e);
		}
		
		numItems++;
	}

	@Override
	public void add(int pos, Job item) throws IndexOutOfBoundsException, IllegalArgumentException {
		if (pos < 0 || pos > numItems - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		if (item == null) {
			throw new IllegalArgumentException();
		}
		
		if(pos == numItems) {
			add(item);
			return;
		}
		
		curr = head.getNext();
		
		for (int i = 0; i < pos - 1; i++) {
			curr = curr.getNext();
		}
		
		curr.setNext(new Listnode<Job>(item, curr.getNext()));
		
		numItems++;
	}

	@Override
	public boolean contains(Job item) {
		curr = head.getNext();
		
		while (curr.getData() != null) {
			if (curr.getData().equals(item)) {
				return true;
			}
			else {
				curr = curr.getNext();
			}
		}
		return false;
	}

	@Override
	public int size() {
		return numItems;
	}

	@Override
	public boolean isEmpty() {
		if (numItems == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Job get(int pos) throws IndexOutOfBoundsException {
		
		if (pos < 0 || pos > numItems - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		curr = head;
		
		for (int i = 0; i < pos; i++) {
			curr = curr.getNext();
		}
		
		return curr.getData();
	}

	@Override
	public Job remove(int pos) throws IndexOutOfBoundsException {
		
		if (pos < 0 || pos > numItems - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		curr = head.getNext();
		
		for (int i = 0; i < pos - 1; i++) {
			curr = curr.getNext();
		}
		
		curr.setNext(curr.getNext().getNext());
		
		numItems--;
		
		return curr.getNext().getData();
	}

	
}