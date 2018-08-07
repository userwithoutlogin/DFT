/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fouriert.main;

import com.mycompany.fouriert.ft.FourierTransform;
import com.mycompany.fouriert.ft.RecoursiveDiscreteTransform;
import com.mycompany.fouriert.complex.Complex;
import com.mycompany.fouriert.fasor.Fasor;
import com.mycompany.fouriert.fasor.RecoursiveFasor;
import com.mycompany.fouriert.functions.Function;
import com.mycompany.fouriert.functions.SineFunction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author root
 */
public class FourierMain {
      public static void main(String[] args) {
//          FourierTransform ft = new DiscreteFourierTransformation(new SampleGenerator());
//          
//          List<Double> samples = getDiscreteTimeSamples(30,1,Math.PI/2);
//          
//          List<Complex> spectreSamples = ft.direct(samples);
//          List<Double> newSamples      = ft.reverse(spectreSamples);
//          
//          
//          display(samples, spectreSamples, newSamples);
//          
         Fasor fasor = new RecoursiveFasor( );
         FourierTransform fourierTransform = new RecoursiveDiscreteTransform(fasor, 4);
          
         Function sine = new SineFunction(2000.0, Math.PI);
         Iterator sineIter = sine.getIterator();
         
         for(int i=0;i<100;i++){
              fourierTransform.direct((double)sineIter.next());
              
         }
             
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
