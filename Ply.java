import java.util.Optional;
/**
 * Represents a Chess Player
 *
 * @author jzhan30
 * @version 1.0
 */
public class Ply {
    private Piece piece;
    private Square from;
    private Square to;
    private Optional<String> comment;

    /**
     * Creates a Player from a Move
     * @param  piece         Piece object to be moved
     * @param  from          Square the piece is located
     * @param  to            Square the piece is to be moved
     * @param  stuff         Optional Comment
     */
    public Ply(Piece piece, Square from, Square to, Optional<String> stuff) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.comment = stuff;
    }

    /**
     * returns a piece from a ply
     * @return piece object
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * returns Square where piece is located
     * @return Square object
     */
    public Square getFrom() {
        return from;
    }

    /**
     * returns Square where piece is to be moved
     * @return Square object
     */
    public Square getTo() {
        return to;
    }

    /**
     * return's Optional String attached to Player
     * @return Optional String Comment
     */
    public Optional<String> getComment() {
        return comment;
    }
}
