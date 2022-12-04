package instrument;

public class Head {
    private Color color;
    private Tuners tuners;

    public Head(){
        this.color = Guitar.randomColor();
        this.tuners = new Tuners();
    }
    public Head(Tuners tuners){
        this.color = Guitar.randomColor();
        this.tuners = tuners;
    }

    public String tuneTheGuitar(){
        System.out.println("Now the guitar will be tuned.\n");
        return tuners.turnTuners();
    }

    public void display() {
        System.out.println("-------------Head-------------");
        System.out.println("Color: " + color);
        tuners.display();
    }

    public Color getColor() { return color; }

    public Tuners getTuners() { return tuners; }

    public void setColor(Color color) { this.color = color; }

    public void setTuners(Tuners tuners) { this.tuners = tuners; }
}
