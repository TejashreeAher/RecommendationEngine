/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.com.home.test.object;

import java.util.Comparator;

/**
 *
 * @author tejashree.aher
 */

public class Attribute{

    String name;
    int weightage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeightage() {
        return weightage;
    }

    public void setWeightage(int weightage) {
        this.weightage = weightage;
    }

    public Attribute(String name, int weightage) {
       this.name = name;
       this.weightage = weightage;
    }

    @Override
    public String toString() {
        return name +":"+ weightage;
    }

//    @Override
//    public int compareTo(Attribute o) {
//        return Comparators.WEIGHTAGE.compare(this, o);
//    }

    public static class Comparators {
        public static Comparator<Attribute> WEIGHTAGE = new Comparator<Attribute>() {
            @Override
            public int compare(Attribute o1, Attribute o2) {
                return o2.weightage - o1.weightage;
            }
        };
    }
}