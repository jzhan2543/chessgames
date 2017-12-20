/**
 * Creates a Knight, a type of Piece
 *
 * @author jzhan30
 * @version 2.0
 */
public class Knight extends Piece {

    /**
    * Creates a private color for each piece
    */
    private Color color;

    /**
    * Creates a new Knight from its color
    *
    *@param color the color of the new Piece
    */
    public Knight(Color color) {
        super(color);
        this.color = color;
    }

    /**
    * Method for a Knight's algebraicName;
    */
    @Override
    public String algebraicName() {
        return "N";
    }

    /**
    * Method for a knight's fenName Notation;
    */
    @Override
    public String fenName() {
        String str = "";
        if (color.equals(color.WHITE)) {
            str = "N";
        } else {
            str = "n";
        }
        return str;
    }

    /**
    * Method which returns an array of Squares containing all the squares
    * the Knight could move to
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
        if ((rank + 1 < 9) && (file + 2 < 9)) {
            count++;
        }
        if ((rank - 1 > 0) && (file + 2 < 9)) {
            count++;
        }
        if ((rank + 1 < 9) && (file - 2 > 0)) {
            count++;
        }
        if ((rank - 1 > 0) && (file - 2 > 0)) {
            count++;
        }
        if ((rank + 2 < 9) && (file + 1 < 9)) {
            count++;
        }
        if ((rank - 2 > 0) && (file + 1 < 9)) {
            count++;
        }
        if ((rank + 2 < 9) && (file - 1 > 0)) {
            count++;
        }
        if ((rank - 2 > 0) && (file - 1 > 0)) {
            count++;
        }
        Square[] possible = new Square[count];
        int i = 0;
        if ((rank + 1 < 9) && (file + 2 < 9)) {
            newfile = file + 2;
            newrank = rank + 1;
            filechar = square.convertFile(newfile);
            rankchar = Character.forDigit(newrank, 10);
            possible[i] = new Square(filechar, rankchar);
            i++;
        }
        if ((rank - 1 > 0) && (file + 2 < 9)) {
            newfile = file + 2;
            newrank = rank - 1;
            filechar = square.convertFile(newfile);
            rankchar = Character.forDigit(newrank, 10);
            possible[i] = new Square(filechar, rankchar);
            i++;
        }
        if ((rank + 1 < 9) && (file - 2 > 0)) {
            newfile = file - 2;
            newrank = rank + 1;
            filechar = square.convertFile(newfile);
            rankchar = Character.forDigit(newrank, 10);
            possible[i] = new Square(filechar, rankchar);
            i++;
        }
        if ((rank - 1 > 0) && (file - 2 > 0)) {
            newfile = file - 2;
            newrank = rank - 1;
            filechar = square.convertFile(newfile);
            rankchar = Character.forDigit(newrank, 10);
            possible[i] = new Square(filechar, rankchar);
            i++;
        }
        if ((rank + 2 < 9) && (file + 1 < 9)) {
            newfile = file + 1;
            newrank = rank + 2;
            filechar = square.convertFile(newfile);
            rankchar = Character.forDigit(newrank, 10);
            possible[i] = new Square(filechar, rankchar);
            i++;
        }
        if ((rank - 2 > 0) && (file + 1 < 9)) {
            newfile = file + 1;
            newrank = rank - 2;
            filechar = square.convertFile(newfile);
            rankchar = Character.forDigit(newrank, 10);
            possible[i] = new Square(filechar, rankchar);
            i++;
        }
        if ((rank + 2 < 9) && (file - 1 > 0)) {
            newfile = file - 1;
            newrank = rank + 2;
            filechar = square.convertFile(newfile);
            rankchar = Character.forDigit(newrank, 10);
            possible[i] = new Square(filechar, rankchar);
            i++;
        }
        if ((rank - 2 > 0) && (file - 1 > 0)) {
            newfile = file - 1;
            newrank = rank - 2;
            filechar = square.convertFile(newfile);
            rankchar = Character.forDigit(newrank, 10);
            possible[i] = new Square(filechar, rankchar);
            i++;
        }
        return possible;
    }
}
