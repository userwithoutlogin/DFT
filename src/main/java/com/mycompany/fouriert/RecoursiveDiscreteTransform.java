/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fouriert;

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
    }
         
    
    
    @Override
    public List<Double> reverse(List<Complex> spectrumSamples) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Complex> direct(List<Double> timeSamples) {
        List<Complex> spectrumSamples = new ArrayList();
        
        fasor.initWidth(windowWidth).initTimeSamples(timeSamples).initBuffer();
       
        spectrumSamples.add(fasor.getSample());
        
        IntStream.range(0, timeSamples.size()-windowWidth).forEach(i->{
            System.out.println(timeSamples.size()-windowWidth);
            System.out.println(i);
            fasor.shift();
            spectrumSamples.add(fasor.getSample());
        });
        return spectrumSamples;  
    }
    
}
