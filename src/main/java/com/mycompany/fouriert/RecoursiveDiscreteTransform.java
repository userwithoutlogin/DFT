/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fouriert;

import com.mycompany.fouriert.fasor.Fasor;
import com.mycompany.fouriert.complex.Complex;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author root
 */
public class RecoursiveDiscreteTransform implements FourierTransform{
     Fasor fasor ;
     Integer windowWidth;
     
    public RecoursiveDiscreteTransform( Fasor fasor, Integer windowWidth) {
        this.fasor = fasor;         
        this.windowWidth = windowWidth;
        fasor.initWidth(windowWidth).initBuffer();
    }
         
    
     @Override
    public Complex direct(Double timeSample) {
        Complex spectrumSample = new Complex(0.0,0.0);
       
        fasor.shift(timeSample);
        spectrumSample.add(fasor.getSample());  
        
        return spectrumSample;  
    }
    
}
