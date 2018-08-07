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
        private final Double frequency;
        private final Double phase;
     

    public SineFunction(Double frequency, Double phase) {
        this.frequency = frequency;
        this.phase = phase;
    }
    
    
    
    @Override
    public Double calcPoint(double t) {
        return 2*Math.sin(120*Math.PI*t +phase);
    }

    @Override
    public Iterator getIterator() {
        return new FunctionIterator();
    }
      
    
    private class FunctionIterator implements Iterator{
         
        private Double t = 0.0;
        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object next() {
            t += 1/frequency;
            return calcPoint(t);
        }
        
    }
    
    
}
