package instrument;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MusicalInstrument {

    private static int streamSize = 10; //Size of guitar stream (use in All tasks)
    private static int sumOfPrices = 0; //Sum of prices in guitar stream (use in 1 task)
    private static int maxPrice = 0; // Max price in guitar stream (use in 2 task)
    private static String needClsfc = "Electric"; //Condition of classification (use in 3 task)
    private static Material needMtrl = Material.WOOD; //Condition of material (use in 3 task)
    private static int validationFlag = 0; //Indicator of validation ending (use in 4 task)
    private static Map <Color, Integer> colorCounter = new HashMap<>(); //HashMap for counting colors (use in 5 task)

    public static void main(String[] args){
        Guitar[] instruments = new Guitar[streamSize];
        for(int i=0; i<streamSize; i++){
            instruments[i] = new Guitar();
        }
        Stream<Guitar> streamInstruments = Arrays.stream(instruments);
        findGuitarByClassification(streamInstruments, "Acoustic"); //1) Find Acoustic guitars and count sum of prices
        findMostExpensive(streamInstruments); //2) Find most expensive guitar
        findAveragePrice(streamInstruments); //3) Find average price
        splitByCondition(streamInstruments); //4) Find guitars fits to default condition (needClsfc, needMtrl)
        getAndParseChildLists(streamInstruments); //5)Get child list (Colors) and find most popular color

    }
    //1) Find Acoustic guitars and count sum of prices
    public static void findGuitarByClassification(Stream<Guitar> insts, String comparator) {
        insts.filter(inst -> inst.getClassification() == comparator)
                .peek(inst -> incrementSumOfPrices(inst.getPrice()))
                .forEach(Guitar::display);

        System.out.println("\n------------------------\nSum of prises: " + sumOfPrices);
    }
    public static void incrementSumOfPrices(int a){ sumOfPrices += a; }

    //2) Find most expensive guitar
    public static void findMostExpensive(Stream<Guitar> insts){
        System.out.println("\n---------------------------\nGuitar with max price\n---------------------------\n");
        insts.peek(inst -> findMaxPrice(inst.getPrice()))
                .filter(inst -> inst.getPrice() == maxPrice)
                .forEach(Guitar::display);
    }

    public static void findMaxPrice(int price){
        if(price > maxPrice) maxPrice = price;
    }

    //3) Find average price
    public static void findAveragePrice(Stream<Guitar> insts){
       OptionalDouble average = insts.mapToInt(inst -> inst.getPrice()).average();
       System.out.println("\n---------------------------\nAverage price: "+
               average.getAsDouble() + "\n---------------------------\n");
    }

    //4)Find guitars fits to default condition (needClsfc, needMtrl)
    public static void splitByCondition(Stream<Guitar> insts){
        insts.peek(inst -> validationCheck(inst, inst.getClassification(), inst.getNeck().getFretsMaterial()))
                .filter(inst -> inst.getClassification() != needClsfc && inst.getNeck().getFretsMaterial() != needMtrl)
                .forEach(Guitar::display);
    }

    public static void validationCheck( Guitar inst, String classification, Material material){
        if(classification == needClsfc && material == needMtrl)
            inst.display();
        if(validationFlag == 0)
            System.out.println("\n--------------------------\nAre fit to condition:\n--------------------------\n");
        if(validationFlag == streamSize)
            System.out.println("\n--------------------------\nAre not fit to condition:\n--------------------------\n");
        validationFlag++;
    }

    //5)Get child list (Colors) and find most popular color
    public static void getAndParseChildLists(Stream<Guitar> insts){
        fillColorCounter();
        List<Color> colors = insts.flatMap(inst -> Stream.of(inst.getBody().getColor())).collect(Collectors.toList());

        System.out.println("\n--------------------------\nGuitar body colors list:\n--------------------------\n");
        colors.forEach(color -> System.out.println(color.toString()));

        System.out.println("\nCounted colors: \n");
        countColors(colors);
        for(Map.Entry <Color, Integer> entry : colorCounter.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("\nThe most popular color is:\n");
        int maxCountOfColors = (Collections.max(colorCounter.values()));
        for (Map.Entry<Color, Integer> entry : colorCounter.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxCountOfColors) {
                System.out.println(entry.getKey());     // Print the key with max value
            }
        }
    }
    public static void fillColorCounter(){
        Arrays.asList(Color.values()).forEach(color -> colorCounter.put(color, 0));
    }
    public static void countColors(List <Color> list){
        for(int i = 0; i < list.size(); i++){
            if(colorCounter.containsKey(list.get(i))){
                colorCounter.put(list.get(i), colorCounter.get(list.get(i)) + 1);
            } else {
                colorCounter.put(list.get(i), 1);
            }
        }
    }
}
