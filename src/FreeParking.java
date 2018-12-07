
public class FreeParking extends Square {

    public FreeParking(String nameOfSquare) {
        super(nameOfSquare, 0, 0);
    }

    public void doAction(Player player) {
        System.out.println("Free Parking! You are just waiting..");
    }

}
