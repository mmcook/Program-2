/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          p2
// FILE:             JobListIterator.java
//
// Authors: Meggie Cook
// Author1: Meggie Cook, mcook24@wisc.edu, mcook24, lecture 002
//
/////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * This class is a direct access iterator, which will traverse through the
 * items in Listnode<Job>. It has the methods specified by the java.util.Iterator
 * interface, which is hasNext(), which shows if there is a next node in the list,
 * and next(), which if there is a next node returns the data item of type Job. 
 * This iterator will assume that the linked list will have a header node.
 * @author Margaret Cook
 *
 */
public class JobListIterator implements java.util.Iterator<Job>{
	
	//The listnode that we will iterate through
	private Listnode<Job> curr;
	
	/**
	 * In this constructor, we will initialize the listnode with 
	 * @param node is the header node of the linked list that
	 * will be traversed by the iterator.
	 */
	public JobListIterator(Listnode<Job> node)
	{
		//Assign the header node of linked list to the curr
		curr = node;
	}
	/**
	 * This method indicates if there is a next node in the linked list.
	 * @return true if there is a next node, false otherwise
	 */
	public boolean hasNext()
	{
		//If there is a next node, return true
		if(curr.getNext() != null)
		{
			return true;
		}
		
		//Otherwise, return false
		else
		{
			return false;
		}
	}
	
	/**
	 * This method return the next job item in the linked list. If there 
	 * are no more job items remaining, throw a NoSuchElementsException.
	 * @return the next data item (of the data typeJob) in the linked list
	 */
	public Job next()
	{	
		//If there is no nodes left but the method is called, throw an 
		//NoSuchElementsException
		if(curr.getNext() == null )
		{
			throw new NoSuchElementException();
		}
		
		//Set the current node to the next node in the list
		curr = curr.getNext();
		
		//Return the job item in node
		return curr.getData();
	}
}
