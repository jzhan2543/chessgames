/**
 * Abstract Class to create a new Piece
 *
 * @author jzhan30
 * @version 2.0
 */
abstract class Piece {

    /**
    * Creates a private color for each piece
    */
    private Color color;

    /**
    * Creates a new Piece from its color
    *
    *@param color the color of the new Piece
    */
    public Piece(Color color) {
        this.color = color;
    }

    /**
    * Returns the color of the Piece
    */
    public Color getColor() {
        return this.color;
    }

    /**
    * Method for a piece's algebraicName;
    */
    abstract String algebraicName();

    /**
    * Method for a piece's fenName Notation;
    */
    abstract String fenName();

    /**
    * Method which returns an array of Squares containing all the squares
    * the piece could move to
    *
    *@param square, the current square the piece is located
    */
    abstract Square[] movesFrom(Square square);

}
