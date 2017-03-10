/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          p2
// FILE:             JobList.java
//
// Authors: Cody Kairis, Jake Vande Walle
// Author1: Cody Kairis, kairis@wisc.edu, kairis, lecture 002
// Author2: Jake Vande Walle, jvandewalle@wisc.edu, jvandewalle, lecture 002
//
/////////////////////////////////////////////////////////////////////////////

import java.util.Iterator;

public class JobList implements ListADT<Job> {

	//data members
	private int numJobs;
	
	//private Iterator<Job> itr;
	
	//Reference to the header node in a JobList instance
	private Listnode<Job> head;
	
	/** This is the constructor for each JobList instance. Specifies the number
	 * of Jobs in the list and the reference to the list itself
	 * 
	 * @param none
	 */
	public JobList() {
		this.numJobs = 0;
		this.head = new Listnode<Job>(null);
	}
	
	/**
	* This method returns an iterator for the JobList instance
	*
	* @return Iterator<Job>
	* @param none
	*/
	public Iterator<Job> iterator() {
		
		Iterator<Job> itr =  new JobListIterator(head.getNext());
		return itr;
	}
	
	/** This method adds a Job to the end of the JobList
	 * 
	 * @param the job to be added
	 * @return none
	 * @throws IllegalArgumentException if job input is null
	 */
	public void add(Job e) {
		if (e == null) throw new IllegalArgumentException();
		
		Listnode<Job> curr = head;
		
		while(curr.getNext() != null) {
			curr = curr.getNext();
		}
		
		curr.setNext(new Listnode<Job>(e));
		numJobs++;
	}
	
	/** This method adds a job at a designated position within the JobList
	 * 
	 * @param position to add the job
	 * @param Job to be added
	 * @return none
	 * @throws IndexOutOfBoundsException if position is faulty
	 * @throws IllegalArgumentException if job input is null
	 * 
	 */
	public void add(int pos, Job e) {
		if(e == null){
			throw new IllegalArgumentException();
		}
		
		if(pos < 0 || pos > numJobs) {
			throw new IndexOutOfBoundsException();
		}
		
		// if asked to add item to the end of the List
		if(pos == numJobs) {
			add(e);
			return;
		}
		
		Listnode<Job> curr = head;
		for(int i = 0; i < pos; i++) {
			curr = curr.getNext();
		}
		curr.setNext(new Listnode<Job>(e, curr.getNext()));
		
		numJobs++;
	}
	
	/** This method checks if a JobList contains a particular job
	 * 
	 * @param the job being checked for in the JobList
	 * @return whether or not the JobList contains that Job
	 * @throws IllegalArgumentException if job input is null
	 */
	public boolean contains(Job e) {
		if (e == null) {
			throw new IllegalArgumentException();
		}
		Listnode<Job> curr = head;
		
		for (int i = 0; i < numJobs; i++) {
			if (curr.getNext().getData() == e) {
				return true;
			}
		}
		return false;
	}
	
	/** Returns the job at a specified index in the JobList
	 * 
	 * @param position of job that is desired
	 * @return the job at the specified position
	 * @throws IndexOutOfBoundsException when position is faulty
	 */
	public Job get(int pos) {
		//Check if pos is a good input or not, if not then throw
		//Exception
		if (pos < 0 || pos > numJobs) throw new IndexOutOfBoundsException();
		
		//Create duplicate reference
		Listnode<Job> curr = head;
		
		//Traverse to the position of interest
		for (int i = 0; i < pos; i++) {
			curr = curr.getNext();
		}
		
		//Return Job that curr's Listnode references
		return curr.getNext().getData();
	}
	
	/** This method returns a boolean value indicating whether the JobList
	 *  is empty or not
	 *  
	 *  @param none
	 *  @return if number of Jobs in JobList is zero or not
	 * 
	 */
	public boolean isEmpty() {
		return numJobs == 0;
	}
	
	/** Removes a Job from the JobList at a specified position
	 * 
	 * @param position where removal is desired
	 * @return Job at that position
	 * @throws IndexOutOfBoundsException when position is faulty
	 */
	public Job remove(int pos) {
		
		if (pos < 0 || pos > numJobs) {
			throw new IndexOutOfBoundsException();
		}
		
		//Initialize two place holder Listnodes
		Listnode<Job> curr = head;
		Listnode<Job> temp;
		
		//Traverse to the node right before the deisred node 
		for (int i = 0; i < pos; i++) {
			curr = curr.getNext();
		}
		
		temp = curr.getNext();
		
		//Set previous node's next reference to the node after the node to 
		//be removed.
		curr.setNext(curr.getNext().getNext());
		
		numJobs--;
		
		//Return the data within the 
		return temp.getData();
	}
	
	/** Returns the number of Jobs in the JobList
	 * 
	 * @param none
	 * @return number of jobs in the JobList
	 */
	public int size() {
		return numJobs;
	}
	
}