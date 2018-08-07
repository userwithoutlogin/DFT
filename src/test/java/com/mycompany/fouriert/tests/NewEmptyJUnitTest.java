/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fouriert.tests;

import com.mycompany.fouriert.complex.Complex;
import com.mycompany.fouriert.ft.FourierTransform;
import com.mycompany.fouriert.ft.RecoursiveDiscreteTransform;
import com.mycompany.fouriert.functions.Function;
import com.mycompany.fouriert.functions.Generator;
import com.mycompany.fouriert.functions.SineFunction;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrey_pushkarniy
 */
public class NewEmptyJUnitTest {
     FourierTransform fourierTransform;
     List<Complex> spectrumSamples;
     Function sine ;
      Generator generator;
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        fourierTransform =  new RecoursiveDiscreteTransform(  4);
        sine = new SineFunction( 2.0,60.0,Math.PI);
        spectrumSamples = new ArrayList();
        generator = new Generator(fourierTransform,sine);
        generator.start();
        spectrumSamples = generator.getSpectrumSamples();
        assertEquals(50, spectrumSamples.size());
    }
    
    @After
    public void tearDown() {
        
    }
     
     @Test
     public void hello() {
        generator.start();
     }
}
