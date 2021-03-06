/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fouriert.complex;

/**
 *
 * @author root
 */
public class Complex {
    private final Double re;
    private final Double im;
   private Integer precision = 2;
   
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public Double arg(){
        return calculateArgOnQuarter();
     }
    public Double amplitude(){
        return Math.sqrt(Math.pow(re,2)+Math.pow(im,2));
    }
    public Complex multiply(double constant){
       return new Complex(re*constant,im*constant);
    }
    public Complex multiply(Complex multiplier){
        
        return new Complex(amplitude()*multiplier.amplitude()*Math.cos(arg()+multiplier.arg()),
                            amplitude()*multiplier.amplitude()*Math.sin(arg()+multiplier.arg())
        );
    }
    public Complex add(Complex added){
        return new Complex(re+added.getRe(),im+added.getIm());
    }
   
    //инициализция и возврат комлексного числа по формуле Эйлера
    public static Complex initByEuler(double module,double arg){
        return new Complex(module*Math.cos(arg),module*Math.sin(arg));
    }
    
    
    public Double getRe() {
        return re;
    }
    public Double getIm() {
        return im;
    }
    //подсчет аргумента компексного числа в зависимости от того,
//    в какой четверти координатной плоскости находится комплексное число
    private Double calculateArgOnQuarter(){
        if(re>0 && im==0)
            return 0.0; 
        else if(re>0&&im>0)
            return   Math.atan(im/re); 
        else if(re==0&&im>0)
            return Math.PI/2.0; 
        else if(re<0&&im>0)
            return Math.atan(im/re)+Math.PI; 
        else if(re<0&&im==0)
            return Math.PI; 
        else if(re<0&&im<0)
            return Math.atan(im/re)-Math.PI; 
        else if(re==0&&im<0)
            return Math.PI+Math.PI/2; 
        else if(re>0&&im<0)
            return Math.atan(im/re); 
         return null;
    }
    
    @Override
    public String toString() {
        String sign = im<0? " - ":" + ";
        return     String.format("%."+precision+"f",re) + 
                sign +"j"+  String.format("%."+precision+"f",Math.abs(im))  ;
    } 
}
