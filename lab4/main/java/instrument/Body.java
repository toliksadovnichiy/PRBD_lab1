package instrument;

public class Body {
    private Color color;
    private Strings strings;

    private class Strings{
        private int stringsNumber;
        private Material material;

        public Strings(Head head){
            this.stringsNumber = head.getTuners().getQuantity();
            this.material = Material.METAL;
        }

        public int getStringsNumber() { return stringsNumber; }

        public Material getMaterial() { return material; }
    }

    public Body(Head head){
        this.color = Guitar.randomColor();
        this.strings = new Strings(head);
    }

    public void display() {
        System.out.println("-------------Body-------------");
        System.out.println("Color: " + color);
        System.out.println("Strings number: " + strings.getStringsNumber());
        System.out.println("Strings material: " + strings.getMaterial() + '\n');
    }

    public Color getColor() { return color; }

    public Strings getStrings() { return strings; }

    public void setColor(Color color) { this.color = color; }
}
