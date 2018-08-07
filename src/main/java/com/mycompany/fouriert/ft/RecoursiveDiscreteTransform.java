/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fouriert.ft;

import com.mycompany.fouriert.complex.Complex;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
 
import java.util.LinkedList;

/**
 *
 * @author root
 */
public class RecoursiveDiscreteTransform implements FourierTransform{
      
     
     private List<Complex> buffer;
     private Integer n;
     private Integer width; 
     
    public RecoursiveDiscreteTransform(Integer width) {                  
        this.width = width;
        n=0;
        initBuffer() ;
    }
         
      public void shift(double timeSample) {         
        buffer.remove(0);
        Complex temp = Complex.initByEuler(1,-2*Math.PI*(width-1)*n/width);
        buffer.add(temp.multiply(timeSample ));
        n++;         
    }
 
    
    public Complex getSample(){
        Complex sample = new Complex(0.0,0.0);
        for (Complex b : buffer) 
            sample = sample.add(b);
        return sample;        
    }
    
    
     @Override
    public Complex direct(Double timeSample) {
        Complex spectrumSample = new Complex(0.0,0.0);
        shift(timeSample);
        return spectrumSample.add( getSample());  
    }
    
    public void initBuffer(){
        Complex spectrumSample = new Complex(0.0,0.0);
        buffer = new LinkedList();
        for(int k=0;k<width;k++){
           buffer.add(spectrumSample);                
        }
    }
}
