/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fouriert;

import com.mycompany.fouriert.complex.Complex;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author root
 */
public class DiscreteFourierTransformation  {
     SampleGenerator sampleGenerator ;

    public DiscreteFourierTransformation(SampleGenerator sampleGenerator) {
        this.sampleGenerator = sampleGenerator;
    }
    
     
    
    
   public List<Double> reverse(List<Complex> samples){
        int samplesCount = samples.size();
        List<Double> timeSamples = new ArrayList(); ;
         
        IntStream.range(0,samplesCount).forEach(n->{
            double timeSample = 0.0;
            timeSamples.add( 
                    generateTimeSample(samplesCount, n,   samples)/samplesCount
            );
        });
        
       return timeSamples;
    }

     
    public List<Complex> direct(List<Double> samples) {
        int samplesCount = samples.size();
        List<Complex> spectrumSamples = new ArrayList();
        
        IntStream.range(0, samplesCount).forEach(n->{
             
            spectrumSamples.add(generateSpectrumSample(samplesCount, n,   samples));            
        });
        
        return spectrumSamples;
    }
    
    private double generateTimeSample(int samplesCount,int n, List<Complex> samples){
        return sampleGenerator.timeSample(samplesCount, n,   samples);
    }
    private Complex generateSpectrumSample(int samplesCount,int n, List<Double> samples){
       return sampleGenerator.spectrumSample(samplesCount, n,  samples);
    }
}
