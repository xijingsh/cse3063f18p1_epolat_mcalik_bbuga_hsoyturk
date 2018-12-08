import java.util.Scanner;

public class Utilities extends Square{
	
	private Scanner scan = new Scanner(System.in);
	private String choice;
	private int price;
	private int rent;
	private int theNewRent;

	public Utilities(String nameOfSquare, int price, int rent) {
		super(nameOfSquare, price, rent);
		this.price = price;
		this.rent = rent;
    }
	
	public  void doAction(Player player, Board board){
		if(this.getName().contains("Electric")) {
			if(player.getMoney().getMoney() >= price) {
				if(this.hasOwner() == 0){
					System.out.println("Do you want to buy? (Y/N)");
					System.out.println("The price is "+this.getPrice()+"TL!");
			        choice = scan.nextLine();
			        if(choice.contains("y") || choice.contains("Y")) {
			        	System.out.println(player.getName()+ " have bought "+this.getName()+"!");
			        	this.setOwner(player);
			        }
			        else {
			        	System.out.println(player.getName()+ " have not bought "+this.getName()+"!");
			        }
				}
				else {
					System.out.println("There is an owner"+this.getOwner().getName()+", you have to pay ");
					if(this.bothOfUtilityBelongsToSameOwner() == this.getName()) {
						theNewRent = 10*rent;
						System.out.print("10 times the rent of your dice, the owner have both utilities! ");
						System.out.println("The rent is: "+theNewRent+"TL");
					}
					else {
						theNewRent = 4*rent;
						System.out.print("4 times the rent of your dice! ");
						System.out.println("The rent is: 4 x "+rent + " = "+theNewRent+"TL");
					}
					if(player.getMoney().getMoney() >= theNewRent) {
						
						player.getMoney().reduceMoney(theNewRent);
						this.getOwner().getMoney().increaseMoney(theNewRent);
					}
					else {
						System.out.println(player.getName()+" is lost!");
					}
				}
			}
			else {
				System.out.println("Your money is not enough to buy!");
			}
		}
		
		if(this.getName().contains("Water")) {
			if(player.getMoney().getMoney() >= price) {
				if(this.hasOwner() == 0){
					System.out.println("Do you want to buy? (Y/N)");
					System.out.println("The price is "+this.getPrice()+"!");
			        choice = scan.nextLine();
			        if(choice.contains("y") || choice.contains("Y")) {
			        	System.out.println(player.getName()+ " have bought "+this.getName()+"!");
			        	this.setOwner(player);
			        }
			        else {
			        	System.out.println(player.getName()+ " have not bought "+this.getName()+"!");
			        }
				}
				else {
					System.out.println("There is an owner, you have to pay ");
					if(this.bothOfUtilityBelongsToSameOwner() == this.getName()) {
						theNewRent = 10*rent;
						System.out.print("10 times the rent of your dice, the owner have both utilities! ");
						System.out.println("The rent is: "+theNewRent);
					}
					else {
						theNewRent = 4*rent;
						System.out.print("4 times the rent of your dice! ");
						System.out.println("The rent is: "+theNewRent);
					}
					if(player.getMoney().getMoney() >= theNewRent) {
						
						player.getMoney().reduceMoney(theNewRent);
						this.getOwner().getMoney().increaseMoney(theNewRent);
					}
					else {
						System.out.println(player.getName()+" is lost!");
					}
				}
			}
			else {
				System.out.println("Your money is not enough to buy!");
			}
		}	
	}
}