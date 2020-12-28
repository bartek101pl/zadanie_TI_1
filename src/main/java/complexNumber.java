/*
 * Copyright (c) 2020. Bartosz Śnieg
 */

public class complexNumber {

    private double re,im;

    /**
     Constructor with parser for complex number in arithmetic form in text format
     @param number complex number in arithmetic type as text
     */
    public complexNumber(String number){

        if (number.length() == 0) {
            this.re = 0;
            this.im = 0;
        }

        int iLocation = number.indexOf('i');
        int oLocation = number .indexOf('+');
        char oStatus = '+';
        if(oLocation < 0)
        {
            oLocation = number.indexOf('-');
            if(oLocation == 0)
            {
                oLocation = 1+number.substring(1).indexOf('-');
            }
            oStatus = '-';
        }

        if(iLocation<oLocation&& iLocation>0 && oLocation>0){

            im = Double.parseDouble(number.substring(0,iLocation));
            re = Double.parseDouble(number.substring((oStatus=='+')?1+oLocation:oLocation));

        }else if(iLocation>0&& oLocation>0)
        {
            re = Double.parseDouble(number.substring(0,oLocation));
            im = Double.parseDouble(number.substring(oLocation , iLocation));
        }else if (iLocation>0&& oLocation<0)
        {
           im = Double.parseDouble(number.substring(0 , iLocation));
        }else if(oLocation>0&& iLocation<0)
        {
            re = Double.parseDouble(number);
        }

    }

    /**
     Constructor complex number
     @param re real part
     @param im imaginary part
     */
    public complexNumber(double re, double im){
        this.im = im;
        this.re = re;
    }

    /**
     @return complex number module
     */
    public double getModulus(){
        return Math.sqrt((Math.pow(this.im,2)+Math.pow(this.re,2)));
    }


    /**
     @return complex number argument
     */
    public double getArgument(){
        double k = 0;
        if(this.im !=0 && this.re != 0)
            k= Math.atan((Math.abs(this.im)/Math.abs(this.re)))*180/Math.PI;
        if(this.im ==0)
        {
            k = (this.re >0)?0:180;
        }
        if(this.re == 0)
        {
            k = (this.im>0)?90:270;
        }
        if (this.im>0&&this.re<0)
            k = 180 -k;
        if(this.im<0&&this.re<0)
            k+=180;
        if(this.im<0&&this.re>0)
            k = 360-k;

        return  k;
    }


    /**
     @return complex number in arithmetic form as String
     */
    public String getArithmetic(){
        return String.valueOf((this.re!=0)?this.re:"")+((im>=0)?"+":"-")+String.valueOf(Math.abs(this.im))+"i";
    }

    /**
     @return complex number in trigonometric form as String
     */
    public String getTrigonometric(){
        double h =  this.getArgument();
        return this.getModulus()+"(cos("+h+")+i sin("+h+"))";
    }

    /**
     @return complex number in exponential form as String
     */
    public String getExponential(){
        return this.getModulus()+"e^i("+this.getArgument()+")";
    }

    /**
     The function of adding complex numbers
     @param z1 First complex number
     @param z2 Second complex number
     @return new complex number after adding z1 and z2
     */
    public static final complexNumber add(complexNumber z1, complexNumber z2){
        return new complexNumber(z1.re+ z2.re,z1.im+z2.im);
    }

    /**
     The function  of subtract complex number
     @param z1 First complex number
     @param z2 Second complex number
     @return new complex number after subtracting z1 from z2
     */
    public static final complexNumber subtract(complexNumber z1, complexNumber z2){
        return new complexNumber(z1.re - z2.re,z1.im - z2.im);
    }

    /**
     The function  of multiply complex number
     @param z1 First complex number
     @param z2 Second complex number
     @return new complex number after multiply z1 from z2
     */
    public static final complexNumber multiply(complexNumber z1, complexNumber z2){
        double Im = z1.getModulus()* z2.getModulus()*Math.sin((z1.getArgument()+z2.getArgument())/180*Math.PI);
        double Re = z1.getModulus()* z2.getModulus()*Math.cos((z1.getArgument()+z2.getArgument())/180*Math.PI);
        return new complexNumber(Re,Im);
    }


    /**
     The function  of division complex number
     @param z1 First complex number
     @param z2 Second complex number
     @return new complex number after dividing z1 by z2
     */
    public  static final complexNumber division(complexNumber z1 ,complexNumber z2){
        double Im = z1.getModulus()/ z2.getModulus()*Math.sin((z1.getArgument()-z2.getArgument())/180*Math.PI);
        double Re = z1.getModulus()/ z2.getModulus()*Math.cos((z1.getArgument()-z2.getArgument())/180*Math.PI);
        return new complexNumber(Re,Im);
    }

    /**
     @return real part
     */
    public double getRe() {
        return re;
    }

    /**
     @return imaginary part
     */
    public double getIm() {
        return im;
    }
}
