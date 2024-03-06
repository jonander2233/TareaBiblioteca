
package librerias;


import java.util.Arrays;

public class GenericDynamicArray<T> {
    private static final float GROW_FACTOR = 2f;
    private static final int DEFAULT_CAPACITY = 20;
    private Object[] data;
    private int elementCount;

    //Constructor
    public GenericDynamicArray(int capacidadInicial) {
        data = new Object[capacidadInicial];
        elementCount = 0;
    }

    public GenericDynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public boolean add(T value) {
        if(isFull()) {
            expandArray();
        }
        data[elementCount++] = value;
        return true;
    }

    public boolean add(int index, T value) {
        if(index >= elementCount || index < 0) {
            return false;
        }
        if(isFull()) {
            expandArray();
        }
        moveToRight(index);
        data[index] = value;
        return true;
    }

    private void moveToRight(int index) {
        for(int i = elementCount; i > index; i--) {
            data[i] = data[i - 1];
        }
        elementCount++;
    }

    private void moveToLeft(int index) {
        for(int i = index; i < elementCount - 1; i++) {
            data[i] = data[i + 1];
        }
        elementCount--;
    }

    public T remove(int index) {
        if(index >= elementCount || index < 0) {
            return null;
        }
        T removedValueFromIndex = (T) data[index];
        moveToLeft(index);
        return removedValueFromIndex;
    }

    public T remove(T value) {
        T removedValue = null;
        for(int i = 0; i < elementCount; i++) {
            if(data[i] == value) {
                removedValue = (T) data[i];
                moveToLeft(i);
                return removedValue;
            }
        }
        return removedValue;
    }

    public T get(int index) {
        if(index >= elementCount || index < 0) {
            return null;
        }
        return (T) data[index];
    }

    public boolean set(int index, T value) {
        if(index >= elementCount || index < 0) {
            return false;
        }
        data[index] = value;
        return true;
    }

    private boolean isFull() {
        return elementCount == data.length;
    }

    public int size() {
        return elementCount;
    }

    private void expandArray() {
        Object[] arrayExpanded = new Object[Math.round(data.length * GROW_FACTOR)];
        for(int i = 0; i < elementCount; i++) {
            arrayExpanded[i] = data[i];
        }
        data = arrayExpanded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenericDynamicArray that = (GenericDynamicArray) o;

        if (elementCount != that.elementCount) return false;
        for(int i = 0; i < elementCount; i++) {
            if(data[i] != that.data[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        Object[] effectiveArray = new Object[elementCount];
        for(int i = 0; i < effectiveArray.length; i++) {
            effectiveArray[i] = data[i];
        }
        int result = Arrays.hashCode(effectiveArray);
        result = 31 * result + elementCount;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(int i = 0; i < elementCount; i++) {
            sb.append(data[i]).append("\n");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
