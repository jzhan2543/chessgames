import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Representation of a Chess Game
 *
 * @author jzhan30
 * @version 1.0
 */
public class ChessGame {
    private List<Move> moves;

    /**
     * Creates a ChessGame from a List of Moves
     * @param  moves         List of Move Objects
     */
    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }

    /**
     * Getter method for a specific index
     * @param  n             desired index
     * @return     Move Object at desired index
     */
    public Move getMove(int n) {
        return moves.get(n);
    }

    /**
     * Getter method for the List of Moves for a Chess Game
     * @return List of Move Objects
     */
    public List<Move> getMoves() {
        return moves;
    }

    /**
     * Returns a list filtered by the predicate
     * @param  filter        Predicate of Move Objects
     * @return                 List of Move Objects following filter
     */
    public List<Move> filter(Predicate<Move> filter) {
        ArrayList<Move> result = new ArrayList<Move>();
        moves.stream().filter(filter).forEach(t -> result.add(t));
        return result;
    }

    /**
     * returns a list of moves with comments
     * @return List of Move Objects with comments
     */
    public List<Move> getMovesWithComment() {
        return filter(lol -> lol.getWhitePly().getComment().isPresent()
        || lol.getBlackPly().getComment().isPresent());
    }

    /**
     * returns a list of moves without comments
     * @return list of move objects without comments
     */
    public List<Move> getMovesWithoutComment() {
        Predicate<Move> c = new Predicate<Move>() {
            public boolean test(Move mov) {
                return (!mov.getWhitePly().getComment().isPresent())
                    && (!mov.getBlackPly().getComment().isPresent());
            }
        };
        return filter(c);
    }

    /**
     * returns a list of moves with a piece of this type
     * @param  p             Piece object to be filtered
     * @return       list of move objects
     */
    public List<Move> getMovesWithPiece(Piece p) {
        return filter(new Lol(p));
    }

    /**
     * Predicate Implementation for Move using an inner class
     */
    public class Lol implements Predicate<Move> {
        private Piece x;

        /**
         * Creates an instance of Lol
         * @param  pi            Piece Object
         */
        public Lol(Piece pi) {
            x = pi;
        }

        /**
         * returns true if either player     has the desired piece
         * @param  p             piece object
         * @return      true if either player has the desired piece
         */
        public boolean test(Move p) {
            return p.getWhitePly().getPiece().getClass().equals(x.getClass())
                || p.getBlackPly().getPiece().getClass().equals(x.getClass());
        }
    }
}
