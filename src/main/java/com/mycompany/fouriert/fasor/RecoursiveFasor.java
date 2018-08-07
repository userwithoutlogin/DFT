/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fouriert.fasor;

import com.mycompany.fouriert.fasor.Fasor;
import com.mycompany.fouriert.complex.Complex;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class RecoursiveFasor implements Fasor{
     
    private List<Complex> buffer;
    private List<Double> timeSamples;
    //current spectrum sample number
    private Integer n;
    private Integer width;

    public RecoursiveFasor( ) {
        n = 0;
        buffer = new ArrayList();
    }
 
    
    
    @Override
    public void shift(double timeSample) {         
        buffer.remove(0);
        Complex temp = Complex.initByEuler(1,-2*Math.PI*(width-1)*n/width);
        buffer.add(temp.multiply(timeSample ));
        n++;         
    }
 
    @Override
    public Complex getSample(){
        Complex sample = new Complex(0.0,0.0);
        for (Complex b : buffer) 
            sample = sample.add(b);
        return sample;        
    }
    
    
    @Override
   public Fasor initBuffer(){
        Complex spectrumSample = new Complex(0.0,0.0);
        for(int k=0;k<width;k++){
           buffer.add(spectrumSample);                
        }
         
        return this;
    }

    
//    @Override
//    public Fasor initTimeSamples(List<Double> timeSamples) {
//        this.timeSamples = timeSamples;
//        return this;
//    }

    @Override
    public Fasor initWidth(int width) {
        this.width = width;
        return this;
    }
    
    
}
