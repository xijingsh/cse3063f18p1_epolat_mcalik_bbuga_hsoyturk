import java.util.Random;


public class Dice  {
	public int getDiceValue() {
        Random randomDice = new Random();
        return randomDice.nextInt(6) + 1;
    }
}
