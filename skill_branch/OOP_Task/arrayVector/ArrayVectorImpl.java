package OOP_Task.arrayVector;

import java.util.Arrays;

public class ArrayVectorImpl implements ArrayVector {
    private double[] vector;

    //OK
    @Override
    public void set(double... elements) {
        vector = new double[elements.length];
        System.arraycopy(elements, 0, vector, 0, elements.length);
    }

    //OK
    @Override
    public double[] get() {
        return vector;
    }

    //-
    @Override
    public ArrayVector clone() {
        ArrayVectorImpl a = new ArrayVectorImpl();
        double[] ab = new double[this.getSize()];
        System.arraycopy(this.vector, 0, ab, 0, this.getSize());
        a.set(ab);
        return (ArrayVector) a;
    }

    //OK
    @Override
    public int getSize() {
        return vector.length;
    }

    //OK
    @Override
    public void set(int index, double value) {
        if (index >= 0) {
            if (index + 1 > vector.length) {
                double[] d = new double[vector.length];
                System.arraycopy(vector, 0, d, 0, vector.length);
                vector = new double[index+1];
                System.arraycopy(d, 0, vector, 0, d.length);
                vector[index] = value;
            } else {
                vector[index] = value;
            }
        }

    }

    //OK
    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < vector.length) {
            return vector[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы вектора; vertor.length: " + vector.length);
        }
    }

    //Ok
    @Override
    public double getMax() {
        double max = vector[0];
        for (int i = 1; i < vector.length; i++){
            if (max < vector[i]){
                max = vector[i];
            }
        }
        return max;
    }

    //OK
    @Override
    public double getMin() {
        double min = vector[0];
        for (int i = 1; i < vector.length; i++){
            if (min > vector[i]){
                min = vector[i];
            }
        }
        return min;
    }

    //OK
    @Override
    public void sortAscending() {
        Arrays.sort(vector);
    }

    //OK
    @Override
    public void mult(double factor) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = vector[i]*factor;
        }
    }

    //OK
    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        int min;

        if (anotherVector.getSize() <= vector.length) {
             min = anotherVector.getSize();
        } else {
            min = vector.length;
        }

        for (int i = 0; i < min; i++) {
            vector[i] = vector[i] + anotherVector.get(i);
        }

        return this;
    }

    //OK
    @Override
    public double scalarMult(ArrayVector anotherVector) {
        int min;
        double scalar = 0;
        if (anotherVector.getSize() > vector.length) {
            min = vector.length;
        } else {
            min = anotherVector.getSize();
        }

        for (int i = 0; i < min; i++) {
            scalar = scalar + vector[i]*anotherVector.get(i);
        }

        return scalar;
    }

    //OK
    @Override
    public double getNorm() {
        double norm = 0;
        for (int i = 0; i < vector.length; i++) {
            norm = norm + vector[i]*vector[i];
        }
        return Math.sqrt(norm);
    }
}
