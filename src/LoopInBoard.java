public class LoopInBoard extends Square {

    public LoopInBoard(String nameOfSquare) {
        super(nameOfSquare, 0, 0);
    }

    public void doAction(Player player, Board board) {
        System.out.println("You earned 200 TL!");
    }
}