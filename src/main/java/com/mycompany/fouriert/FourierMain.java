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
public class FourierMain {
      public static void main(String[] args) {
          FourierTransform ft = new DiscreteFourierTransformation(new SampleGenerator());
          
          List<Double> samples = getDiscreteTimeSamples(30,1,Math.PI/2);
          
          List<Complex> spectreSamples = ft.direct(samples);;
          List<Double> newSamples      = ft.reverse(spectreSamples);
          
          
          display(samples, spectreSamples, newSamples);
          
          Fasor fasor = new RecoursiveFasor( );
          FourierTransform recFourierTransform = new RecoursiveDiscreteTransform(fasor, 4);
          List<Complex> recSpectreSamples = recFourierTransform.direct(samples);
          
         
    }
 
    
    private static List<Double> getDiscreteTimeSamples(int N,double amplitude,double phase){
        List<Double> samples = new  ArrayList();
        IntStream.range(0, N).forEach((x)->{
            samples.add( f(x));             
        });
        return samples;
    }
    private static double f(double x){
        return 2*Math.sin((2*Math.PI*x)/100);
    } 
    private static void display(List<Double> samples,List<Complex> spectreSamples ,List<Double> newSamples ){
         System.out.println("initial                     DDFT              RDFT");
          IntStream.range(0, samples.size()).forEach(i->{
              System.out.println(samples.get(i)+"\t"+spectreSamples.get(i)+"\t"+newSamples.get(i));
             
          });
    } 
}
