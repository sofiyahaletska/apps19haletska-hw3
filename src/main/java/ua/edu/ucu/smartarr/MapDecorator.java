package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private MyFunction func;
    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.func = func;
    }
    private Object[] Decorate(MyFunction func){
        Object[] oldArray = smartArray.toArray();
        Object[] newArray = new Object[smartArray.size()];
        for(int i = 0; i < oldArray.length; i++) {
            newArray[i] = func.apply(oldArray[i]);
        }
        return newArray;
    }
    @Override
    public Object[] toArray() {
        Object[] newArray = Decorate(func);
        return newArray;
    }

    @Override
    public String operationDescription() {
        return "Map Decorator - map every element to another object using MyFunction";
    }

    @Override
    public int size() {
        Object[] newArray = Decorate(func);
        return newArray.length;
    }
}
