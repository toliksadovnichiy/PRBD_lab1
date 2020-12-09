package instrument;

public class Neck {
    private Color color;
    private int fretsNumber;
    private Material fretsMaterial;

    public Neck(){
        this.color = Guitar.randomColor();
        this.fretsNumber = Guitar.randomNumber(8, 16, 1);
        this.fretsMaterial = Guitar.randomMaterial();
    }

    public void display() {
        System.out.println("-------------Neck-------------");
        System.out.println("Color: " + color);
        System.out.println("Frets number: " + fretsNumber);
        System.out.println("Frets material: " + fretsMaterial);
    }


    public Color getColor() { return color; }

    public int getFretsNumber() { return fretsNumber; }

    public Material getFretsMaterial() { return fretsMaterial; }

    public void setColor(Color color) { this.color = color; }

    public void setFretsMaterial(Material fretsMaterial) { this.fretsMaterial = fretsMaterial; }

    public void setFretsNumber(int fretsNumber) { this.fretsNumber = fretsNumber; }
}

