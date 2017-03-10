public class Test_JobList {

	public static void main(String[] args) {
		
		/**
		 * Create five arbitrary jobs to be utilized by JobList and 
		 * Scoreboard methods
		 */
		Job job1 = new Job("job1", 100, 300);
		Job job2 = new Job("job2", 200, 300);
		Job job3 = new Job("job3", 300, 300);
		Job job4 = new Job("job4", 400, 200);
		Job job5 = new Job("job5", 500, 399);
		
		/**
		 * Create a new JobList instance
		 */
		JobList list = new JobList();
		
		/**
		 * Add Job1, Job2, and Job3 to the end of the JobList and then print
		 * out the total size of the list to confirm they were added
		 */
		list.add(job1);
		list.add(job2);
		list.add(job3);
		System.out.println("JobList size should be 3: " + list.size());
		System.out.print("\n");
		
		/**
		 * Try to add a job at at a particular position in the JobList
		 * Print out size and use the Job.toString() method to print
		 * out the jobs in order to confirm job added at correct position 
		 */
		list.add(2, job4);
		System.out.println("JobList size should be 4: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Expected order: Job1, Job2, Job4, Job3");
			System.out.println(list.get(i).toString());
		}
		System.out.print("\n");
		
		/**
		 * Test whether IndexOutOfBoundsException and IllegalArgumentException
		 * correctly thrown within add(int pos) method
		 */
		for (int i = 0; i < 2; i++) {
			try {
				list.add(-1, job1);
				list.add(null);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("IndexOutOfBoundsException thrown "
						+ "and caught");
			} catch (IllegalArgumentException e) {
				System.out.println("IllegalArgumentException thrown "
						+ "and caught");
			}
		}
		
	}

}