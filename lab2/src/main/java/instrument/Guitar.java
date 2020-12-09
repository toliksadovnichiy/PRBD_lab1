package instrument;

import java.util.ArrayList;
import java.util.Random;

public class Guitar extends Instrument {
    String classification;
    private Head head;
    private Neck neck;
    private Body body;

    public Guitar(){
        super();
        this.head = new Head();
        this.neck = new Neck();
        this.body = new Body(head);
    }

    @Override
    public void display() {
        System.out.println("Instrument: " + Guitar.class.getSimpleName());
        System.out.println("Classification: " + classification);
        System.out.println("Price: " + price + "  Weight: " + weight);
        head.display();
        neck.display();
        body.display();
        System.out.println(isSameColor());
    }
    public StringBuffer isSameColor(){
        StringBuffer str = new StringBuffer();             //---------------- USING OF StringBuffer
        if(head.getColor().isEqual(neck.getColor())){
            str.append("Head has the same color as Neck.\n");
        }
        else{
            str.append("Head has the different color as Neck.\n");
        }
        if(head.getColor().isEqual(body.getColor())){
            str.append("Head has the same color as Body.\n");
        }
        else{
            str.append("Head has the different color as Body.\n");
        }
        if(neck.getColor().isEqual(body.getColor())){
            str.append("Neck has the same color as Body\n");
        }
        else{
            str.append("Neck has the different color as Body.\n");
        }
        return str;
    }
    public static Color randomColor(){
        int pick = new Random().nextInt(Color.values().length);
        return Color.values()[pick];
    }

    public static Material randomMaterial(){
        int pick = new Random().nextInt(Material.values().length);
        return Material.values()[pick];
    }

    public static int randomNumber(int low, int high, int step){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = low; i<=high; i+=step){
            arr.add(i);
        }
        Random rand = new Random();
        return arr.get(rand.nextInt(arr.size()));
    }

    public Body getBody() {
        return body;
    }

    public Head getHead() {
        return head;
    }

    public Neck getNeck() {
        return neck;
    }

    public String getClassification() {
        return classification;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public void setNeck(Neck neck) {
        this.neck = neck;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}

