import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        Parser parse = new Parser();

        parse.parse(output);
        parse.printMap();


    }

    public static String readRawDataToString() throws Exception{
        ClassLoader classLoader = Main.class.getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));

        return result;
    }




}
