/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fouriert.functions;

import com.mycompany.fouriert.complex.Complex;
import java.util.Iterator;

/**
 *
 * @author andrey_pushkarniy
 */
public class SineFunction implements Function {
        private final Double amplitude;
        private final Double frequency;
        private final Double phase;
        private Double timeArg = 0.0;

    public SineFunction(Double amplitude, Double frequency, Double phase) {
        this.amplitude = amplitude;
        this.frequency = frequency;
        this.phase = phase;
    }   
    
    
        @Override
    public Double calc( ) {
        double sin  = amplitude*Math.sin(Math.PI*getTimeArg()  +phase);
        timeArg+=1/frequency;
            
        return sin;
    }
    
    public double getTimeArg(){
          return  timeArg;
    }
    
//    @Override
//    public Iterator getIterator() {
//        return new FunctionIterator();
//    }
      
    
//    private class FunctionIterator implements Iterator{
//         
//        private Double t = 0.0;
//        @Override
//        public boolean hasNext() {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public Object next() {
//            t += 1/frequency;
//            return calcPoint(t);
//        }
//        
//    }

    public Double getFrequency() {
        return frequency;
    }
    
    
}
