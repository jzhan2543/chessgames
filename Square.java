/**
 * Represents a Square on a Chess Board e.g. e5, h8 etc.
 *
 * @author jzhan30
 * @version 3.0
 */
public class Square {

    /**
    * Creates instance variables: file, rank, and a string
    */
    private char f;
    private char r;
    private StringBuilder s;
    private String str;

    /**
    * Creates a Square with all required parameters
    *
    *@param file the file of the new Square: a,b,c,d,e,f,g,h
    *@param rank the rank of the new Square: 1,2,3,4,5,6,7,8
    */
    public Square(char file, char rank) throws InvalidSquareException {
        f = file;
        r = rank;
        int rankNum = Character.getNumericValue(r);
        s = new StringBuilder().append(f).append(r);
        str = s.toString();
        boolean fileInRange = false;
        boolean rankInRange = false;
        if (f >= 'a' && f <= 'h') {
            fileInRange = true;
        }
        if (rankNum >= 1 && rankNum <= 8) {
            rankInRange = true;
        }
        if (!(fileInRange && rankInRange)) {
            throw new InvalidSquareException(str);
        }
    }
    /**
    * Creates a Square with all required parameters
    *
    *@param name contains both the file and rank of a new Square
    */
    public Square(String name) throws InvalidSquareException {
        f = name.charAt(0);
        String rankStr = name.substring(1, name.length());
        int rank = 0;
        boolean nameLength = false;
        boolean fileInRange = false;
        boolean rankInRange = false;
        if (rankStr.length() == 1) {
            rank = Character.getNumericValue(name.charAt(1));
            nameLength = true;
            if (rank >= 1 && rank <= 8) {
                rankInRange = true;
            }
        }
        s = new StringBuilder().append(f).append(rankStr);
        str = s.toString();
        if (f >= 'a' && f <= 'h') {
            fileInRange = true;
        }
        if (!(fileInRange && rankInRange && nameLength)) {
            throw new InvalidSquareException(str);
        }
    }

    @Override
    public String toString() {
        return this.str;
    }

    /**
     * getter method for file
     * @return char file
     */
    public char getFile() {
        return this.f;
    }

    /**
     * getter method for rank
     * @return char rank
     */
    public char getRank() {
        return this.r;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Square) {
            return ((Square) obj).toString().equals(this.toString());
        } else {
            return false;
        }
    }

    /**
     * hashCode Representation for a Square
     * @return returns a numeric value for a Square's hashCode
     */
    @Override
    public int hashCode() {
        int file = Character.getNumericValue(f);
        int rank = Character.getNumericValue(r);
        return file * 10 + rank;
    }

    /**
    * Converts an int file to its respective char letter
    *
    *@param file the file of the new Square: a,b,c,d,e,f,g,h
    *       where 1 = a, 2 = b, etc.
    *@return char file
    */
    public char convertFile(int file) {
        char newfile = 'a';
        if (file == 1) {
            newfile = 'a';
        }
        if (file == 2) {
            newfile = 'b';
        }
        if (file == 3) {
            newfile = 'c';
        }
        if (file == 4) {
            newfile = 'd';
        }
        if (file == 5) {
            newfile = 'e';
        }
        if (file == 6) {
            newfile = 'f';
        }
        if (file == 7) {
            newfile = 'g';
        }
        if (file == 8) {
            newfile = 'h';
        }
        return newfile;
    }

}
