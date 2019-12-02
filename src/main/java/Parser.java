import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Map<String, Item> map = new HashMap<String, Item>();
    HashMap<String, Integer> priceAndOccurences;

    Errors errors = new Errors();



    public void parse(String raw) throws Exception {

        String[] array = stringToArray(raw);

        for (int i = 0; i < array.length; i++) {
            String[] item = array[i].split("[^a-zA-Z0-9:./]");
            addItemToMap(checkItemName(item[0]), checkItemPrice(item[1]));
        }
    }

    //pass text to array
    public String[] stringToArray(String s) {

        String[] temp = s.split("##");

        return temp;
    }


    //check name and price
    public String checkItemName(String itemName){

        Pattern pattern = Pattern.compile("name:", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(itemName);

       return allLetters(matcher.replaceAll("")).toLowerCase();
    }

    public String allLetters(String itemName){

        Pattern pattern = Pattern.compile("0", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(itemName);

        return matcher.replaceAll("o");
    }

    public String checkItemPrice(String itemPrice){

        Pattern pattern = Pattern.compile("price:", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(itemPrice);

        return matcher.replaceAll("");
    }


    public void addItemToMap(String itemName, String itemPrice) throws Exception {

        priceAndOccurences = new HashMap<String, Integer>();


        if (!itemName.equals("") && !itemPrice.equals("")) {

            if (!map.containsKey(itemName)) {
                priceAndOccurences.put(itemPrice, 0);
                Item newItem = new Item(itemName, priceAndOccurences);
                map.put(itemName, newItem);
            }

            incrementOccurrence(itemName, itemPrice);

        } else {
                errors.increment();
        }

    }


    public void incrementOccurrence(String itemName, String itemPrice) {

        if (!itemPrice.equals("") && !itemName.equals("")) {

            if (map.get(itemName).checkPriceExists(itemPrice))
                map.get(itemName).incrementCount(itemPrice);

            else
                map.get(itemName).addPrice(itemPrice);
        }
    }

    public void printMap() {

        for(HashMap.Entry<String,Item> entry : map.entrySet()){
                entry.getValue().itemToString();
        }
    }

}
