package OOP_Task.complexNumber;

import java.util.Arrays;

public class ComplexNumberImpl implements ComplexNumber {

    private double re;
    private double im;

    //OK
    @Override
    public double getRe() {
        return this.re;
    }

    //OK
    @Override
    public double getIm() {
        return this.im;
    }

    //OK
    @Override
    public boolean isReal() {
        if (this.im == 0.0) {
            return true;
        } else {
            return false;
        }
    }

    //OK
    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }


    @Override
    public void set(String value) throws NumberFormatException {

    }

    //OK
    @Override
    public ComplexNumber copy() {
        ComplexNumberImpl co = new ComplexNumberImpl();
        co.set(this.re, this.im);
        return co;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        ComplexNumberImpl co = new ComplexNumberImpl();
        co.set(this.re, this.im);
        return co;
    }

    //OK
    @Override
    public int compareTo(ComplexNumber other) {
        double modThis, modOther;
        modThis = this.getRe()*this.getRe() + this.getIm()*this.getIm();
        modOther = other.getRe()*other.getRe() + other.getIm()*other.getIm();
        if (modThis > modOther) {
            return 1;
        } else if (modThis < modOther) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array);
    }

    //OK
    @Override
    public ComplexNumber negate() {
        if (this.re != 0) {
            this.re = this.re * (-1);
        }
        if (this.im != 0) {
            this.im = this.im * (-1);
        }
        return this;
    }

    //OK
    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        this.re = this.re + arg2.getRe();
        this.im = this.im + arg2.getIm();
        return this;
    }

    //OK
    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        double a, b, c, d;
        a = this.getRe();
        b = this.getIm();
        c = arg2.getRe();
        d = arg2.getIm();
        this.set((a*c-b*d),(b*c+a*d));
        return this;
    }

    //OK
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplexNumberImpl that = (ComplexNumberImpl) o;

        if (Double.compare(that.re, re) != 0) return false;
        return Double.compare(that.im, im) == 0;
    }

    //OK
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(re);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(im);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //OK
    @Override
    public String toString() {
        String str = "";
        if (this.re != 0) {
            str = str + this.re;
        }
        if (this.im > 0) {
            if (this.re != 0) {
                str = str + "+" + this.im + "i";
            } else {
                str = str + this.im + "i";
            }
        }
        if (this.im < 0) {
            str = str + this.im + "i";
        }

        return str;
    }
}
