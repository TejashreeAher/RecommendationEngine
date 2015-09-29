/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.com.home.test.processor.impl;

import main.com.home.test.object.Attribute;
import main.com.home.test.processor.InputProcessor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.com.home.test.factory.RecommendationFactory;
import main.com.home.test.object.Sku;
import main.com.home.test.processor.RecommendationEngine;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *
 * @author tejashree.aher
 */
public class FileInputProcessor implements InputProcessor<String>{
    private static FileInputProcessor instance;
    private static RecommendationEngine engine;
    private static Properties weightageProps = new Properties();
    private static Properties fileProps = new Properties();
    private static Sku s = null;

    public static FileInputProcessor getInstance() {
        if (instance == null) {
            instance = new FileInputProcessor();
        }
        return instance;
    }

    private FileInputProcessor() {
        engine = RecommendationFactory.getEngine("sameAttr");
        weightageProps = new Properties();
        try {
            weightageProps.load(FileInputProcessor.class.getClassLoader().getResourceAsStream("attrWeightage.properties"));
            fileProps.load(FileInputProcessor.class.getClassLoader().getResourceAsStream("inputFile.properties"));
          
        } catch (IOException ex) {
            Logger.getLogger(FileInputProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void processInput(String filePath) {
        String file;
        if(filePath == null){
            file = fileProps.getProperty("filePath");
        }else{
            file = filePath;
        }
        StringBuilder sb = new StringBuilder();
        try {
            String sCurrentLine;
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((sCurrentLine = br.readLine())!= null){
                sb.append(sCurrentLine);
            }
            JSONObject json = new JSONObject(sb.toString());
            Iterator i = json.keys();
            while(i.hasNext()){
                String sku = (String) i.next();
                Sku skuObject = new Sku();
                skuObject.setCode(sku);
                String attrStr = json.getString(sku);
                Map<Attribute, String> attrToVal = new HashMap<Attribute, String>();
                if(attrStr != null){
                    JSONObject attrJson = new JSONObject(attrStr);
                    Iterator attrIter = attrJson.keys();
                    while(attrIter.hasNext()){
                        String attr = (String) attrIter.next();
                        int wt;
                        if(weightageProps.containsKey(attr)){
                            wt = Integer.valueOf((String)weightageProps.get(attr));
                        }else{
                            wt = 1;
                        }
                        Attribute attrObject = new Attribute(attr, wt);
                        String attrVal = attrJson.getString(attr);
                        attrToVal.put(attrObject, attrVal);
                    }
                }
                
                skuObject.setAttrToValMap(attrToVal);
                engine.processInput(skuObject);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException ex) {
            Logger.getLogger(FileInputProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args){
//        engine = RecommendationFactory.getEngine("sameAttr");
//        weightageProps = new Properties();
//        try {
//            weightageProps.load(FileInputProcessor.class.getClassLoader().getResourceAsStream("attrWeightage.properties"));
//            fileProps.load(FileInputProcessor.class.getClassLoader().getResourceAsStream("inputFile.properties"));
//        } catch (IOException ex) {
//            Logger.getLogger(FileInputProcessor.class.getName()).log(Level.SEVERE, null, ex);
//        }
////        processInput1(fileProps.getProperty("filePath"));
//        System.out.println("Input : "+ s.getCode() +": "+ s.getAttrToValMap().toString());
//        List<Sku> skus = engine.recommend(s);
//        System.out.println("_____________________________");
//        for(int i=0; i<skus.size(); i++){
//            System.out.println(skus.get(i).getCode() +"((((((   "+ skus.get(i).getAttrToValMap().toString());
//        }
        
    }

}
