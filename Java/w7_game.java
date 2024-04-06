class Color {
    public static final int BLACK = 2;
    public static final int WHITE = 1;
}
final class GamePiece {
    private int color;
    public GamePiece (int color) {
        this.color = color;
    }
    public int getColor() {
        return this.color;
    }
}
class GameBoard {
    private final int size;
    private int freeSpace;
    private Piece lastPiece;
    public GameBoard (int size) {
        this.size = size;
        this.freeSpace = size;
    }
    boolean addPieces(Piece piece, int number) {
        if (number > freeSpace) {
            return false;
        } else {
            this.freeSpace -= number;
            this.lastPiece = piece;
            return true;
        }
    }
    int freeSquares() {
        return this.freeSpace;
    }
    Piece lastAdded() {
        return this.lastPiece;
    }
    int getSize() {
        return this.size;
    }
}