import java.util.HashMap;

public class Item {

    private HashMap<String, Integer> priceAndOccurrences;
    private int numberOccurrencesItem = 0;
    private String name;


    public Item(String name, HashMap<String, Integer> priceAndOccurrences){
        this.name = name;
        this.priceAndOccurrences = priceAndOccurrences;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean checkPriceExists(String itemPrice) {

        if(priceAndOccurrences.containsKey(itemPrice))
            return true;

        return false;
    }

    public void incrementCount(String itemPrice) {

        priceAndOccurrences.put(itemPrice, priceAndOccurrences.get(itemPrice)+1);
        numberOccurrencesItem ++;
    }

    public void addPrice(String itemPrice) {

        priceAndOccurrences.put(itemPrice, 1);
        numberOccurrencesItem++;
    }

    public void itemToString(){

        System.out.println(name + " seen : " + numberOccurrencesItem + " times\n");
        for(HashMap.Entry<String, Integer> entry : priceAndOccurrences.entrySet())
            System.out.println(entry.getKey() + " seen : " + entry.getValue() + " times\n");
    }
}
