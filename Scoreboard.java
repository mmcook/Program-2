import java.util.Iterator;

public class Scoreboard implements ScoreboardADT {
	
	private JobList board;
	
	private int numComplete;
	
	public Scoreboard() {
		this.board = new JobList();
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
		
		for (int i = 0; i < board.size(); i++) {
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
		
		if (job == null) {
			throw new IllegalArgumentException();
		}
		
			board.add(job);
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
		
		String complete = null;
		int points = 0;
		
		System.out.println("The jobs completed: ");
			
		for (int i = 0; i < numComplete; i++) {	
			complete = board.get(i).getJobName();	
			points = board.get(i).getPoints();
			System.out.println("Job name: " + complete);
			System.out.println("Points earned for this job: " + points);
			System.out.println("--------------------------------------------");
		}
		
	}

}
