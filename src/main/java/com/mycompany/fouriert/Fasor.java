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
public interface Fasor {
    public void shift();
    public Complex getSample();
    
    public Fasor initTimeSamples(List<Double> timeSamples);
    public Fasor initWidth(int width);
    public Fasor initBuffer();
}
