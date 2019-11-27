package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    private MyPredicate pr;
    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.pr = pr;
    }
    private Object[] Decorate(MyPredicate pr) {
        Object[] oldArray = smartArray.toArray();
        Object[] newArray = new Object[smartArray.size()];
        int c = 0;
        for(int i = 0; i < oldArray.length; i++) {
            if (pr.test(oldArray[i])) {
            newArray[c] = oldArray[i];
            c++;
            }
        }
        newArray = Arrays.copyOf(newArray, c );
        return newArray;
    }
    @Override
    public Object[] toArray() {
        Object[] newArray = Decorate(pr);
        return newArray;
    }

    @Override
    public String operationDescription() {
        return "Filter Decorator - tests every element and removes it if it doesn't satisfy MyPredicate";
    }

    @Override
    public int size() {
        Object[] newArray = Decorate(pr);
        return newArray.length;
    }
}
