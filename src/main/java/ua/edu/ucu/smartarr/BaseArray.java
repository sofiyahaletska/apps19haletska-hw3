package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray{
    private final Object[] array;

    public BaseArray(Object[] array) {
        this.array = array;
    }
    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public String operationDescription() {
        return "Base array for decorators";
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
