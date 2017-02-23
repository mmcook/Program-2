import java.util.Scanner;

public class GameApp{
    /**
     * Scanner instance for reading input from console
     */
    private static final Scanner STDIN = new Scanner(System.in);

    /**
     * Constructor for instantiating game class
     * @param seed: Seed value as processed in command line
     * @param timeToPlay: Total time to play from command line
     */
    public GameApp(int seed, int timeToPlay){
    	Game game = new Game(seed, timeToPlay);
        //TODO: Create a new instance of Game class
    }

    /**
     * Main function which takes the command line arguments and instantiate the
     * GameApp class.
     * The main function terminates when the game ends.
     * Use the getIntegerInput function to read inputs from console
     *
     * @param args: Command line arguments <seed> <timeToPlay>
     */
    public static void main(String[] args){

    	int seed = 0;
    	int timeToPlay = 0;
    	
        System.out.println("Welcome to the Job Market!");
        
        try {
        	seed = Integer.parseInt(args[0]);
            timeToPlay = Integer.parseInt(args[1]);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        
        
        GameApp gA = new GameApp(seed, timeToPlay);
        
        gA.start();
        
    }

    /**
     * Add Comments as per implementation
     */
    private void start(){
        //TODO: The interactive game logic goes here
    }

    /**
     * Displays the prompt and returns the integer entered by the user
     * to the standard input stream.
     *
     * Does not return until the user enters an integer.
     * Does not check the integer value in any way.
     * @param prompt The user prompt to display before waiting for this integer.
     */
    public static int getIntegerInput(String prompt) {
        System.out.print(prompt);
        while ( ! STDIN.hasNextInt() ) {
            System.out.print(STDIN.next()+" is not an int.  Please enter an integer.");
        }
        return STDIN.nextInt();
    }
}