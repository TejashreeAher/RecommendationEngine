/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.com.home.test.processor;

import java.util.List;

/**
 *
 * @author tejashree.aher
 * @param <T>
 */
public interface RecommendationEngine<T extends Object> {
    public List<T> recommend(String s);
    public void process();
    public void processInput(T object);
}
