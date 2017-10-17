/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tujia.front.model;

import org.springframework.stereotype.Component;

/**
 *
 * @author huangwei
 */
@Component
public class House {
    
    public House() {
        this(null);
    }
    
    public House(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "House " + name;
    }
    
    public String getName() {
        return name;
    }
    
    private String name;
}
