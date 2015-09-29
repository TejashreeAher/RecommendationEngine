/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.com.home.test.factory;

import main.com.home.test.processor.InputProcessor;
import main.com.home.test.processor.impl.FileInputProcessor;

/**
 *
 * @author tejashree.aher
 */
public class InputFactory {

    public static InputProcessor getProcessor(String source) {
        if (("file").equalsIgnoreCase(source)) {
            return FileInputProcessor.getInstance();
        }else{
            return null;
        }
    }
    
    

}
