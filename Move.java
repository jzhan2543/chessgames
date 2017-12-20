/**
 * Represents a move
 *
 * @author jzhan30
 * @version 1.0
 */
public class Move {

    private Ply whitePly;
    private Ply blackPly;

    /**
     * Creates a new Move of two Players
     * @param  ply1          First Player Object
     * @param  ply2          Second Player Object
     */
    public Move(Ply ply1, Ply ply2) {
        this.whitePly = ply1;
        this.blackPly = ply2;
    }

    /**
     * Getter method for White Player
     * @return Player Object
     */
    public Ply getWhitePly() {
        return whitePly;
    }

    /**
     * Getter method for Black Player
     * @return Player Object
     */
    public Ply getBlackPly() {
        return blackPly;
    }
}
