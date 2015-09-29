/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.home.test.processor;

/**
 *
 * @author tejashree.aher
 * @param <E>
 */
public interface Processor<E extends Object, T extends Object> {
    public void process(E input);
    public T giveOutput();
}
