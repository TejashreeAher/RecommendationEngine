/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.com.home.test.processor;

/**
 *
 * @author tejashree.aher
 */
public interface InputProcessor<T extends Object>{
    public void processInput(T input);
    
}
