/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fouriert;

import java.util.List;

/**
 *
 * @author root
 */
public interface FourierTransform {
    public List<Double> reverse(List<Complex>  spectrumSamples);
    public List<Complex> direct(List<Double> timeSamples);
}
