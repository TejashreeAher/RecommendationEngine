/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.com.home.test.object;

import java.util.List;
import java.util.Map;

/**
 *
 * @author tejashree.aher
 */
public class Sku {
    private String code;
    private List<Attribute> attributes; //this is an ordered list of attributes, always sorted
    private Map<Attribute, String> attrToValMap;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Map<Attribute, String> getAttrToValMap() {
        return attrToValMap;
    }

    public void setAttrToValMap(Map<Attribute, String> attrToValMap) {
        this.attrToValMap = attrToValMap;
    }
    
}
