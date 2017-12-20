/**
 * Creates a Pawn, a type of Piece
 *
 * @author jzhan30
 * @version 2.0
 */
public class Pawn extends Piece {

    /**
    * Creates a private color for each piece
    */
    private Color color;

    /**
    * Creates a new Pawn from its color
    *
    *@param color the color of the new Piece
    */
    public Pawn(Color color) {
        super(color);
        this.color = color;
    }

    /**
    * Method for a pawn's algebraicName;
    */
    @Override
    public String algebraicName() {
        return "";
    }

    /**
    * Method for a pawn's fenName Notation;
    */
    @Override
    public String fenName() {
        String str = "";
        if (color.equals(color.WHITE)) {
            str = "P";
        } else {
            str = "p";
        }
        return str;
    }

    /**
    * Method which returns an array of Squares containing all the squares
    * the pawn could move to
    *
    *@param square, the current square the piece is located
    */
    @Override
    public Square[] movesFrom(Square square) {
        String sq = square.toString();
        char file = square.getFile();
        char rankchar = square.getRank();
        int rank = Integer.parseInt(sq.substring(1 , 2));
        int newrank = 0;
        int count = 0;
        if (color.equals(color.WHITE)) {
            if (rank < 8) {
                count++;
            }
            if (rank == 2) {
                count++;
            }
        } else {
            if (rank > 1) {
                count++;
            }
            if (rank == 7) {
                count++;
            }
        }
        Square[] possible = new Square[count];
        if (color.equals(color.WHITE)) {
            if (rank < 8) {
                newrank = rank + 1;
                rankchar = Character.forDigit(newrank , 10);
                possible[0] = new Square(file , rankchar);
            }
            if (rank == 2) {
                newrank = rank + 2;
                rankchar = Character.forDigit(newrank , 10);
                possible[1] = new Square(file , rankchar);
            }
        } else {
            if (rank > 1) {
                newrank = rank - 1;
                rankchar = Character.forDigit(newrank , 10);
                possible[0] = new Square(file , rankchar);
            }
            if (rank == 7) {
                newrank = rank - 2;
                rankchar = Character.forDigit(newrank , 10);
                possible[1] = new Square(file , rankchar);
            }
        }
        return possible;
    }
}
