package instrument;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Instrument {
    protected int price = 0;
    protected int weight = 0;

    public Instrument(){
        randomFillInstruments();
    }

    public void randomFillInstruments(){
        this.price = ThreadLocalRandom.current().nextInt(1000, 2001);
        this.weight = ThreadLocalRandom.current().nextInt(5, 15);
    }

    public abstract void display();

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }
}

