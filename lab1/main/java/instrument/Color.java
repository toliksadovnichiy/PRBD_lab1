package instrument;

public enum Color {
    BLACK("#000000"),
    WHITE("#FFFFFF"),
    RED("#FF0000"),
    BLUE("#0000FF"),
    YELLOW("#FFFF00"),
    GREEN("#008000"),
    BROWN("#A52A2A"),
    ORANGE("#FFA500");

    private String hex;

    Color(String hex){ this.hex = hex; }

    public boolean isEqual(Color color){
        return this.equals(color);         //--------------- USING OF .equals()
    }

    @Override
    public String toString() {
        return  this.name() + " Color{" +
                "hex='" + hex + '\'' +
                '}';
    }
}

