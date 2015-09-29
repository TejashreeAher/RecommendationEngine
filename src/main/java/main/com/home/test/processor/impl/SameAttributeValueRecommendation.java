/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.com.home.test.processor.impl;

import main.com.home.test.object.Attribute;
import main.com.home.test.processor.RecommendationEngine;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.com.home.test.object.Sku;

/**
 *
 * @author tejashree.aher
 */
public class SameAttributeValueRecommendation implements RecommendationEngine<Sku>{
    private static SameAttributeValueRecommendation instance;
    private static final Map<String, List<Sku>> attributeValToSkuListMap = new HashMap<String, List<Sku>>();
    private static final Map<String, Sku> skuCodeToSkuMap = new  HashMap<String, Sku>();
    private static final int maxSimilarSkus= 10;
    
    public static SameAttributeValueRecommendation getInstance() {
        if (instance == null) {
            instance = new SameAttributeValueRecommendation();
        }
        return instance;
    }

    private SameAttributeValueRecommendation() {
    }

    @Override
    public List<Sku> recommend(String skuCode) {
        if(skuCode == null){
            return new ArrayList<Sku>();
        }
        Sku sku = skuCodeToSkuMap.get(skuCode);
        List<Sku> recommendedSkus = new ArrayList<Sku>();
        if(sku.getAttrToValMap() == null)
            return recommendedSkus;
        List<Attribute> attributes = new ArrayList<Attribute>();
        for(Attribute attr : sku.getAttrToValMap().keySet()){
            attributes.add(attr);
        }
        //This is somehow not working. This step is needed to get result as per weightage to attribute
//        Collections.sort(attributes, Attribute.Comparators.WEIGHTAGE);
        for(Attribute attr : attributes){
            String attrName = attr.getName();
            String attrValue = sku.getAttrToValMap().get(attr);
            String attrNameVal = attrName+":"+ attrValue;
            List<Sku> skus = attributeValToSkuListMap.get(attrNameVal);
            if(skus != null){
                for(Sku eachSku: skus){
                    recommendedSkus.add(eachSku);
                    if(recommendedSkus.size()>=maxSimilarSkus){
                        return recommendedSkus;
                    }
                }
            }
        }
        return recommendedSkus;
    }

    @Override
    public void process() {
    }
    
    public void processInput(Sku sku){
        if(sku == null){
            return;
        }
        skuCodeToSkuMap.put(sku.getCode(), sku);
        if(sku.getAttrToValMap() == null)
            return;
        for(Attribute attr : sku.getAttrToValMap().keySet()){
            String attrName = attr.getName();
            String attrValue = sku.getAttrToValMap().get(attr);
            String attrNameVal = attrName+":"+attrValue;
            List<Sku> skus = attributeValToSkuListMap.get(attrNameVal);
            if(skus == null){
                skus = new ArrayList<Sku>();
            }
            skus.add(sku);
            attributeValToSkuListMap.put(attrNameVal, skus);
        }
        
    }
   
    
}
