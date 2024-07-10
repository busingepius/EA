package jms;

public class Calculator {
    private int value;

    public void add(int x){
        value=value+x;
    }
    public void subtract(int x){
        value=value-x;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "value=" + value +
                '}';
    }
}
