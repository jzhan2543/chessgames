/**
 * Creates a King, a type of Piece
 *
 * @author jzhan30
 * @version 2.0
 */
public class King extends Piece {

    /**
    * Creates a private color for each piece
    */
    private Color color;

    /**
    * Creates a new King from its color
    *
    *@param color the color of the new Piece
    */
    public King(Color color) {
        super(color);
        this.color = color;
    }

    /**
    * Method for a Queen's algebraicName;
    */
    @Override
    public String algebraicName() {
        return "K";
    }

    /**
    * Method for a King's fenName Notation;
    */
    @Override
    public String fenName() {
        String str = "";
        if (color.equals(color.WHITE)) {
            str = "K";
        } else {
            str = "k";
        }
        return str;
    }

    /**
    * Method which returns an array of Squares containing all the squares
    * the King could move to
    *
    *@param square, the current square the piece is located
    */
    @Override
    public Square[] movesFrom(Square square) {
        String sq = square.toString();
        char filechar = square.getFile();
        int file = Character.getNumericValue(filechar) - 9;
        int newfile = 0;
        char rankchar = square.getRank();
        int rank = Integer.parseInt(sq.substring(1 , 2));
        int newrank = 0;
        int count = 0;
        for (int i = 1; i < 2; i++) {
            if ((file + i) < 9 && (rank + i) < 9) {
                count++;
            }
            if ((file + i) < 9 && (rank - i) > 0) {
                count++;
            }
            if ((file - i) > 0 && (rank + i) < 9) {
                count++;
            }
            if ((file - i) > 0 && (rank - i) > 0) {
                count++;
            }
            if ((file + i) < 9) {
                count++;
            }
            if ((rank - i) > 0) {
                count++;
            }
            if ((rank + i) < 9) {
                count++;
            }
            if ((file - i) > 0) {
                count++;
            }
        }
        Square[] possible = new Square[count];
        int j = 0;
        for (int i = 1; i < 2; i++) {
            if ((file + i) < 9 && (rank + i) < 9) {
                newfile = file + i;
                newrank = rank + i;
                filechar = square.convertFile(newfile);
                rankchar = Character.forDigit(newrank, 10);
                possible[j] = new Square(filechar, rankchar);
                j++;
            }
            if ((file + i) < 9 && (rank - i) > 0) {
                newfile = file + i;
                newrank = rank - i;
                filechar = square.convertFile(newfile);
                rankchar = Character.forDigit(newrank, 10);
                possible[j] = new Square(filechar, rankchar);
                j++;
            }
            if ((file - i) > 0 && (rank + i) < 9) {
                newfile = file - i;
                newrank = rank + i;
                filechar = square.convertFile(newfile);
                rankchar = Character.forDigit(newrank, 10);
                possible[j] = new Square(filechar, rankchar);
                j++;
            }
            if ((file - i) > 0 && (rank - i) > 0) {
                newfile = file - i;
                newrank = rank - i;
                filechar = square.convertFile(newfile);
                rankchar = Character.forDigit(newrank, 10);
                possible[j] = new Square(filechar, rankchar);
                j++;
            }
            if ((file + i) < 9) {
                newfile = file + i;
                newrank = rank;
                filechar = square.convertFile(newfile);
                rankchar = Character.forDigit(newrank, 10);
                possible[j] = new Square(filechar, rankchar);
                j++;
            }
            if ((rank - i) > 0) {
                newfile = file;
                newrank = rank - i;
                filechar = square.convertFile(newfile);
                rankchar = Character.forDigit(newrank, 10);
                possible[j] = new Square(filechar, rankchar);
                j++;
            }
            if ((rank + i) < 9) {
                newfile = file;
                newrank = rank + i;
                filechar = square.convertFile(newfile);
                rankchar = Character.forDigit(newrank, 10);
                possible[j] = new Square(filechar, rankchar);
                j++;
            }
            if ((file - i) > 0) {
                newfile = file - i;
                newrank = rank;
                filechar = square.convertFile(newfile);
                rankchar = Character.forDigit(newrank, 10);
                possible[j] = new Square(filechar, rankchar);
                j++;
            }
        }
        return possible;
    }
}
