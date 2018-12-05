import java.util.Scanner;

public class MonopolyLogin {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private Board board;
    private static Scanner scan = new Scanner(System.in);

    public MonopolyLogin(int playerNumber, String[] playerName, int startingMoney) {
        System.out.println(ANSI_RED + "     ______________________    " + ANSI_RESET);
        System.out.println(ANSI_RED + "    |                      |   " + ANSI_RESET);
        System.out.println(ANSI_RED + "    |     GAME STARTS!     |   " + ANSI_RESET);
        System.out.println(ANSI_RED + "    |______________________|  \n" + ANSI_RESET);
        board = new Board(playerNumber, playerName, startingMoney);
    }

    public static void main(String[] args) {
        System.out.println(ANSI_RED + "     ______________________    " + ANSI_RESET);
        System.out.println(ANSI_RED + "    |                      |   " + ANSI_RESET);
        System.out.println(ANSI_RED + "    | Welcome to Monopoly! |   " + ANSI_RESET);
        System.out.println(ANSI_RED + "    |______________________|  \n" + ANSI_RESET);
        System.out.println(ANSI_RED + "How many players will play the Monopoly?" + ANSI_RESET);
        System.out.print(ANSI_RED + "(You must enter minimum 2 and maximum 8): " + ANSI_RESET);
        int playerNumber = getWantedPlayerNumber();
        System.out.println(ANSI_BLUE + "\nGive the player names, please:" + ANSI_RESET);
        String[] playerName = getPlayerName(playerNumber);
        System.out.print(ANSI_BLUE + "\nHow much money should players start with? " + ANSI_RESET);
        int startingMoney = getStartingMoney();
        MonopolyLogin monopoly = new MonopolyLogin(playerNumber, playerName, startingMoney);
    }

    private static int getWantedPlayerNumber() {

        String input;
        int number;
        do {
            input = scan.next();
            while (!isInteger(input, 10)) {
                System.err.println(ANSI_BLUE + "You must enter only integer numbers!" + ANSI_RESET);
                System.out.print(ANSI_BLUE + "How many people are playing?\n" + ANSI_RESET);
                System.out.print(ANSI_BLUE + "Between 2 and 8: " + ANSI_RESET);
                input = scan.next();
            }
            number = Integer.parseInt(input);
            if (number > 8 || number < 2) {
                System.err.println(ANSI_BLUE + "\nYou must enter a number between 2 - 8!" + ANSI_RESET);
                System.out.print(ANSI_BLUE + "How many people are playing?\n" + ANSI_RESET);
                System.out.print(ANSI_BLUE + "Between 2 and 8: " + ANSI_RESET);
            }
        } while (number > 8 || number < 2);
        return number;
    }

    private static String[] getPlayerName(int playerNumber) {
        String[] name = new String[playerNumber];
        for (int i = 0; i < playerNumber; i++) {
            do {
                if (i == 0) {
                    System.out.print(ANSI_BLUE + "1st " + ANSI_RESET);
                } else if (i == 1) {
                    System.out.print(ANSI_BLUE + "2nd " + ANSI_RESET);
                } else if (i == 2) {
                    System.out.print(ANSI_BLUE + "3rd " + ANSI_RESET);
                } else {
                    System.out.print(" " + (i + 1) + ANSI_BLUE + "th " + ANSI_RESET);
                }
                System.out.print(ANSI_BLUE + "Player's name: " + ANSI_RESET);
                name[i] = scan.next();
                if (name[i].equalsIgnoreCase("")) {
                    System.err.println(ANSI_BLUE + "You did not enter any name! Please give a name!\n" + ANSI_RESET);
                }

            } while (name[i].equalsIgnoreCase(""));
        }
        return name;
    }

    private static int getStartingMoney() {
        String input;
        int number;
        input = scan.next();
        while (!isInteger(input, 10)) {
            System.out.println(ANSI_YELLOW + "You must enter only integer numbers!\n" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "How much money should players start with? " + ANSI_RESET);
            input = scan.next();
        }
        number = Integer.parseInt(input);
        return number;
    }

    public static boolean isInteger(String s, int radix) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) {
                    return false;
                } else continue;
            }
            if (Character.digit(s.charAt(i), radix) < 0) return false;
        }
        return true;
    }
}