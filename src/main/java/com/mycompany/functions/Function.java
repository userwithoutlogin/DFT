/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.functions;

import com.mycompany.fouriert.complex.Complex;
import java.util.Iterator;

/**
 *
 * @author andrey_pushkarniy
 */
public interface Function {
    public Double calcPoint(double t);
    public Iterator getIterator();
}