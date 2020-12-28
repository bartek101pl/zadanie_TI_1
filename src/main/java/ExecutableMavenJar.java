/*
 * Copyright (c) 2020. Bartosz Śnieg
 */

public class ExecutableMavenJar {

    double z1Re,z1Im,z2Re,z2Im;
    //init
    public static void main(String[] args) {
        methFunc();
        typeComplex();
    }
    /**
      Example mathematical functions show complex number in Exponential form
     */
    public static void  methFunc(){
        System.out.println("Mathematical functions example for : -3+1.3i and 3+1.3i");
        complexNumber z1 = new complexNumber("-3+1.3i");
        complexNumber z2 = new complexNumber("3+1.3i");
        System.out.println("+ "+ complexNumber.add(z1,z2).getExponential());
        System.out.println("- "+ complexNumber.subtract(z1,z2).getExponential());
        System.out.println("* "+ complexNumber.multiply(z1,z2).getExponential());
        System.out.println("/ "+ complexNumber.division(z1,z2).getExponential());
    }

    /**
     Show all characters of a complex number
     */
    public static void  typeComplex(){
        System.out.println("Show all characters of a complex number for -3+1.3i");
        complexNumber z1 = new complexNumber("-3+1.3i");
        System.out.println(z1.getArithmetic());
        System.out.println(z1.getTrigonometric());
        System.out.println(z1.getExponential());
    }
}

