package challenges.complexoperations;

public class ComplexNumber {
    // a is real, b is imaginary (bi)
    private double real, imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add(double real, double imaginary) {
        this.real += real;
        this.imaginary += imaginary;
    }

    public void add(ComplexNumber anotherComplexNumber) {
         real += anotherComplexNumber.getReal();
         imaginary += anotherComplexNumber.getImaginary();
//         add(anotherComplexNumber.getReal(), anotherComplexNumber.getImaginary());
    }

    public void subtract(double real, double imaginary) {
        this.real -= real;
        this.imaginary -= imaginary;
    }

    public void subtract(ComplexNumber anotherComplexNumber) {
         real -= anotherComplexNumber.getReal();
         imaginary -= anotherComplexNumber.getImaginary();
//         subtract(anotherComplexNumber.getReal(), anotherComplexNumber.getImaginary());
    }
}
