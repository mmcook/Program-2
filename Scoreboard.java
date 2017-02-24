
public class Scoreboard implements ScoreboardADT {
	
	private JobList board;
	
	private int numComplete;
	
	public Scoreboard() {
		this.board = new JobList();
		//this.board = new Listnode<Job>(null);
		numComplete = 0;
	}
	
	@Override
	/** This method adds up the points each job in the Scoreboard list is worth
	 *  and returns the total amount of points
	 *  
	 * @param none
	 * @return total score of all the completed jobs on the Scoreboard list
	 */
	public int getTotalScore() {
		// TODO Auto-generated method stub
		int totalPoints = 0;
		
		for (int i = 0; i < numComplete; i++) {
			totalPoints += board.get(i).getPoints();
			
		}
		
		return totalPoints;
	}

	@Override
	/** Method adds a completed job to the end of the Scoreboard JobList
	 * 
	 * @param completed job to be added
	 * @return none
	 * @throws IllegalArgumentException if job is null
	 */
	public void updateScoreBoard(Job job) {
		// TODO Auto-generated method stub
		if (job == null) {
			throw new IllegalArgumentException();
		}
		
		if (job.isCompleted()) {
			board.add(job);
		}
		numComplete++;
	}

	@Override
	/** Prints out a summary of all jobs currently stored in the scoreboard.
	 *  Most likely going to need an iterator to go through every job in the
	 *  Scoreboard JobList
	 * 
	 * @param none
	 * @return none
	 */
	public void displayScoreBoard() {
		// TODO Auto-generated method stub
		
	}

}
