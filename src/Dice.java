import java.util.Random;


public class Dice {
    public int getDiceValue() {
        Random randomDice = new Random();
        return randomDice.nextInt(6) + 1;
    }

    public int getDiceShape(int die_1, int die_2) {

        System.out.println("        _____           _____");
        System.out.println("       /     /|        /     /|");
        System.out.println("      /_____/ |       /_____/ |");

        for (int i = 0; i < 3; i++) {
            if (die_1 == 1) {
                if (i == 0) {
                    System.out.print("      |     | |       ");
                } else if (i == 1) {
                    System.out.print("      |  •  | /       ");
                } else if (i == 2) {
                    System.out.print("      |_____|/        ");
                }
            } else if (die_1 == 2) {
                if (i == 0) {
                    System.out.print("      |     | |       ");
                } else if (i == 1) {
                    System.out.print("      | • • | /       ");
                } else if (i == 2) {
                    System.out.print("      |_____|/        ");
                }
            } else if (die_1 == 3) {
                if (i == 0) {
                    System.out.print("      |  •  | |       ");
                } else if (i == 1) {
                    System.out.print("      | • • | /       ");
                } else if (i == 2) {
                    System.out.print("      |_____|/        ");
                }
            } else if (die_1 == 4) {
                if (i == 0) {
                    System.out.print("      | • • | |       ");
                } else if (i == 1) {
                    System.out.print("      | • • | /       ");
                } else if (i == 2) {
                    System.out.print("      |_____|/        ");
                }
            } else if (die_1 == 5) {
                if (i == 0) {
                    System.out.print("      | • • | |       ");
                } else if (i == 1) {
                    System.out.print("      |  •  | /       ");
                } else if (i == 2) {
                    System.out.print("      |_•_•_|/        ");
                }
            } else if (die_1 == 6) {
                if (i == 0) {
                    System.out.print("      |• • •| |       ");
                } else if (i == 1) {
                    System.out.print("      |     | /       ");
                } else if (i == 2) {
                    System.out.print("      |•_•_•|/        ");
                }
            }


            if (die_2 == 1) {
                if (i == 0) {
                    System.out.print("|     | |\n");
                } else if (i == 1) {
                    System.out.print("|  •  | /\n");
                } else if (i == 2) {
                    System.out.print("|_____|/\n");
                }
            } else if (die_2 == 2) {
                if (i == 0) {
                    System.out.print("|     | |\n");
                } else if (i == 1) {
                    System.out.print("| • • | /\n");
                } else if (i == 2) {
                    System.out.print("|_____|/\n");
                }
            } else if (die_2 == 3) {
                if (i == 0) {
                    System.out.print("|  •  | |\n");
                } else if (i == 1) {
                    System.out.print("| • • | /\n");
                } else if (i == 2) {
                    System.out.print("|_____|/\n");
                }
            } else if (die_2 == 4) {
                if (i == 0) {
                    System.out.print("| • • | |\n");
                } else if (i == 1) {
                    System.out.print("| • • | /\n");
                } else if (i == 2) {
                    System.out.print("|_____|/\n");
                }
            } else if (die_2 == 5) {
                if (i == 0) {
                    System.out.print("| • • | |\n");
                } else if (i == 1) {
                    System.out.print("|  •  | /\n");
                } else if (i == 2) {
                    System.out.print("|_•_•_|/\n");
                }
            } else if (die_2 == 6) {
                if (i == 0) {
                    System.out.print("|• • •| |\n");
                } else if (i == 1) {
                    System.out.print("|     | /\n");
                } else if (i == 2) {
                    System.out.print("|•_•_•|/\n");
                }
            }
        }
        return 0;
    }
}
