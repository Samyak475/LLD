package Objects;

public class Person {
   public String name;
    public PlayingPiece pieceType;

    public Person(String name, PlayingPiece pieceType) {
        this.name = name;
        this.pieceType = pieceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayingPiece getPieceType() {
        return pieceType;
    }

    public void setPieceType(PlayingPiece pieceType) {
        this.pieceType = pieceType;
    }
}
