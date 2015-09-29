/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.com.home.test.factory;

import main.com.home.test.processor.RecommendationEngine;
import main.com.home.test.processor.impl.SameAttributeValueRecommendation;

/**
 *
 * @author tejashree.aher
 */
public class RecommendationFactory {
        public static RecommendationEngine getEngine(String type) {
        if (("sameAttr").equalsIgnoreCase(type)) {
            return SameAttributeValueRecommendation.getInstance();
        }else{
            return null;
        }
    }
}
