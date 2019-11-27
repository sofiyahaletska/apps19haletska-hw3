package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }
    private Object[] Decorate(){
        int c = 0;
        Object[] oldArray = smartArray.toArray();
        Object[] newArray = new Object[smartArray.size()];
        for (int i = 0; i < smartArray.size(); i++){
            Object oldEl = oldArray[i];
            if (incl(oldEl, newArray)){
                continue;
            }
            else{
                newArray[c] = oldEl;
                c++;
            }
        }
        newArray = Arrays.copyOf(newArray, c);
        return newArray;
    }
    private boolean incl(Object oldEl, Object[] newArray) {
        for (Object newEl : newArray) {
            if (oldEl.equals(newEl)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Object[] toArray() {
        Object[] newArray = Decorate();
        return newArray;
    }

    @Override
    public String operationDescription() {
        return "Distinct Decorator - remove duplicates from SmartArray. Use method equals() to compare objects";
    }

    @Override
    public int size() {
        Object[] newArray = Decorate();
        return newArray.length;
    }
}
