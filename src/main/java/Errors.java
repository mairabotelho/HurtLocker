public class Errors {

    private int count;

    public Errors(){
        count = 0;
    }

    public void increment(){
        count++;
    }

    public int getErrors(){
        return count;
    }
}
