import java.util.Scanner;

public class Avenue extends Square {

    private Scanner scan = new Scanner(System.in);
    private String choice;
    private int price;
    private int rent;

    public Avenue(String nameOfSquare, int price, int rent) {
        super(nameOfSquare, price, rent);
        this.price = price;
        this.rent = rent;
    }

    public void doAction(Player player) {
        if (player.getMoney().getMoney() >= price) {
            if (this.hasOwner() == 0) {
                System.out.println("Do you want to buy? (Y/N)");
                System.out.println("The price is " + this.getPrice() + "!");
                choice = scan.nextLine();
                if (choice.contains("y") || choice.contains("Y")) {
                    System.out.println(player.getName() + " have bought " + this.getName() + "!");
                    this.setOwner(player);
                } else {
                    System.out.println(player.getName() + " have not bought " + this.getName() + "!");
                }
            } else if (this.getOwner() == player) {
                System.out.println("It's your avenue, welcome!");
            } else {
                System.out.println("There is an owner, you have to pay rent! The rent is: " + rent);
                if (player.getMoney().getMoney() >= rent) {
                    player.getMoney().reduceMoney(rent);
                    this.getOwner().getMoney().increaseMoney(rent);
                } else {
                    System.out.println(player.getName() + " is lost!");
                }
            }
        } else {
            System.out.println("Your money is not enough to buy!");
        }
    }
}
