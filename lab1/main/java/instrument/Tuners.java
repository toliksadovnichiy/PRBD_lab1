package instrument;

public class Tuners {
    private int quantity;
    private Material material;

    public Tuners(){
        this.quantity = Guitar.randomNumber(4, 12, 2);
        this.material = Guitar.randomMaterial();
    }

    public String turnTuners(){
        for(int i=0; i<quantity; i++){
            System.out.println("Turn " + i + " tuner.");
        }
        return "\nGuitar was tuned.";
    }

    public void display() {
        System.out.println("Tuners quantity: " + quantity);
        System.out.println("Tuners material: " + material);
    }

    public int getQuantity() {
        return quantity;
    }

    public Material getMaterial() {
        return material;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
