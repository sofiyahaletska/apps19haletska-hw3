package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator cmp;
    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.cmp = cmp;
    }

    private Object[] Decorate(MyComparator cmp){
        Object[] oldArray = smartArray.toArray();
        Object[] newArray = Arrays.copyOf(oldArray, smartArray.size());
        Arrays.sort(newArray, cmp);
        return newArray;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = Decorate(cmp);
        return newArray;
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator - sorts elements using MyComparator to compare them";
    }

    @Override
    public int size() {
        Object[] newArray = Decorate(cmp);
        return newArray.length;
    }
}
