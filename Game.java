import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private ArrayList<Results> playerResults;
	private ArrayList<Throws> playerThrows;
	
	public Game() {
		this.playerResults = new ArrayList<Results>();
		this.playerThrows = new ArrayList<Throws>();
	}
	
	public Game(ArrayList<Results> playerResults, ArrayList<Throws> playerThrows) {
		if (playerResults.size() != playerThrows.size()) {
			throw new IllegalArgumentException("Given lists must be equal size");
		}
		
		this.playerResults = playerResults;
		this.playerThrows = playerThrows;
	}
	
	private static String promptUser(Scanner sc) {
		System.out.println("Please choose rock, paper, or scissors:");
		String answer = sc.next().toLowerCase();
		return answer;
	}
	
	private static Throws readResponse(String answer, Scanner sc) {
		if (answer.equals("r") || answer.equals("rock")) {
			return Throws.ROCK;
		}
		
		else if (answer.equals("p") || answer.equals("paper")) {
			return Throws.PAPER;
		}
		
		else if (answer.equals("s") || answer.equals("scissor") || answer.equals("scissors")) {
			return Throws.SCISSOR;
		}
		
		else {
			System.out.println("Invalid input. Please try again.");
			String newAnswer = promptUser(sc);
			return readResponse(newAnswer, sc);
		}
	}
	
	
	public static void main(String[] args) {
		Game g = new Game();
		Scanner sc = new Scanner(System.in);
		
		String answer = promptUser(sc);
		Throws playerThrow = readResponse(answer, sc);
		Throws computerThrow = g.calculateThrow();
		Results result = g.play(playerThrow, computerThrow);
		
		switch(result) {
		
		case WIN:
			System.out.println("Congrats! You've won.");
			break;
			
		case LOSS:
			System.out.println("Sorry! You've lost.");
			break;
			
		case TIE:
			System.out.println("You've tied. Try again!");
		}
		
	}
	
	private Throws calculateThrow() {
		return Throws.ROCK;
	}
	
	public Results play(Throws player, Throws computer) {
		this.playerThrows.add(player);
		if (this.playerThrows.size() != this.playerResults.size() + 1) {
			throw new IllegalStateException("Error occurred. Player data out unsychronized.");
		}
		
		int playerNum = 3;
		int computerNum = 3;
		
		switch(player) {
		
		case ROCK:
			playerNum = 0;
			break;
			
		case PAPER:
			playerNum = 1;
			break;
			
		case SCISSOR:
			playerNum = 2;
			break;
		} 
		
		switch(computer) {
		
		case ROCK:
			computerNum = 0;
			break;
			
		case PAPER:
			computerNum = 1;
			break;
			
		case SCISSOR:
			computerNum = 2;
			break;
		}
		
		if (playerNum == 3 || computerNum == 3) {
			throw new IllegalArgumentException("Invalid throw.");
		}
		
		else if(playerNum == computerNum) {
			this.playerResults.add(Results.TIE);
			return Results.TIE;
		}
		
		else if (playerNum == 3 && computerNum == 1) {
			this.playerResults.add(Results.LOSS);
			return Results.LOSS;
		}
		
		else if (playerNum == 1 && computerNum == 3) {
			this.playerResults.add(Results.WIN);
			return Results.WIN;
		}
		
		else if (playerNum > computerNum){
			this.playerResults.add(Results.WIN);
			return Results.WIN;
		}
		else {
			this.playerResults.add(Results.LOSS);
			return Results.LOSS;
		}
	}

}
