/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package skuprocessingengine;

import java.util.List;
import main.com.home.test.factory.InputFactory;
import main.com.home.test.factory.RecommendationFactory;
import main.com.home.test.object.Sku;
import main.com.home.test.processor.RecommendationEngine;

/**
 *
 * @author tejashree.aher
 */
public class SKUProcessingEngine {
    
    //takes an sku and outputs similar skus based on recommendation egine used
    private List<String> giveRecommendations(String sku){
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if(args.length <1){
            System.err.println("Expecting 1st parameter to be dbUsername, 2nd to be dbPassword  & 3rd as dbURL");
            return;
        }
        String skuCode = args[0];
        String filePath = null;
        if(args.length > 1){
            filePath = args[1];
        }
        InputFactory.getProcessor("file").processInput(filePath);
        RecommendationFactory.getEngine("sameAttr").recommend(skuCode);
        List<Sku> skus = RecommendationFactory.getEngine("sameAttr").recommend(skuCode);;
        System.out.println("");
        for(int i=0; i<skus.size(); i++){
            System.out.println(skus.get(i).getCode());
        }
    }
    
}
