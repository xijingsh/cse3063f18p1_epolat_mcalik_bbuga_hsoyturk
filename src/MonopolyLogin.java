import java.util.Scanner;

public class MonopolyLogin {
	
	private Board board;
	private static Scanner scan = new Scanner(System.in);
	
	public MonopolyLogin(int playerNumber, String[] playerName, int startingMoney) {
		System.out.println("                                        ______________________");
		System.out.println("                                       |                      |");
        System.out.println("                                       |     GAME STARTS!     |");
        System.out.println("                                       |______________________|\n");
        board = new Board(playerNumber, playerName, startingMoney);
    }

	public static void main(String[] args) {
		System.out.println("                                        ______________________");
		System.out.println("                                       |                      |");
        System.out.println("                                       | Welcome to Monopoly! |");
        System.out.println("                                       |______________________|\n");
        System.out.println("                                How many players will play the Monopoly?");
        System.out.print("                                (You must enter minimum 2 and maximum 8): ");
        int playerNumber = getWantedPlayerNumber();
        System.out.println("\n                                Give the player names, please:");
        String[] playerName = getPlayerName(playerNumber);
        System.out.print("\n                                How much money should players start with? ");
        int startingMoney = getStartingMoney();
        MonopolyLogin monopoly = new MonopolyLogin(playerNumber, playerName, startingMoney);   
	}
	
	private static int getWantedPlayerNumber() {
		
		String input;
        int number;
        do {
            input = scan.next();
            while (!isInteger(input,10)) {
                System.err.println("                                You must enter only integer numbers!");
                System.out.print("                                How many people are playing?\n");
                System.out.print("                                Between 2 and 8: ");
                input = scan.next();
            }
            number = Integer.parseInt(input);
            if (number > 8 || number < 2) {
                System.err.println("\n                                You must enter a number between 2 - 8!");
                System.out.print("                                How many people are playing?\n");
                System.out.print("                                Between 2 and 8: ");
            }
        } while (number > 8 || number < 2);
        return number;
	}
	
	private static String[] getPlayerName(int playerNumber) {
		String[] name = new String[playerNumber];
		for (int i = 0; i < playerNumber; i++) {
            do {
            	if(i==0) {
                	System.out.print("                                1st ");
            	}
                else if(i == 1) {
                    System.out.print("                                2nd ");
                }
                else if (i == 2){
                    System.out.print("                                3rd ");
                }
                else {
                    System.out.print("                                "+(i+1) + "th ");
                }
                System.out.print("Player's name: ");
                name[i] = scan.next();
                if (name[i].equalsIgnoreCase("")) {
                    System.err.println("                                You did not enter any name! Please give a name!\n");
                }
            } while (name[i].equalsIgnoreCase(""));
        }
        return name;
	}
	
	private static int getStartingMoney() {
		String input;
        int number;
        input = scan.next();
            while (!isInteger(input,10)) {
                System.out.println("                                You must enter only integer numbers!\n");
                System.out.println("                                How much money should players start with? ");
                input = scan.next();
            }
            number = Integer.parseInt(input);
        return number;
	}
	
	public static boolean isInteger(String s, int radix) {
		if(s.isEmpty()){
			return false;
		}
		for(int i = 0; i < s.length(); i++) {
			if(i == 0 && s.charAt(i) == '-') {
				if(s.length() == 1){
					return false;
				}
            else continue;
        }
        if(Character.digit(s.charAt(i),radix) < 0) return false;
    }
    return true;
	}
}