/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tujia.front.controller;

import com.alibaba.fastjson.JSONObject;
import com.tujia.front.config.RestfulConfigBean;
import com.tujia.front.model.House;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author huangwei
 */
@Controller
public class ListController {
    
    @RequestMapping(value="/list.htm", method=RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("api", restfulConf.getApiUrl("/searchUnit"));
        return "unitlist";
    }
    
    @RequestMapping(value="/list/add.htm", method=RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("secure_id", Math.random());
        List<String> houseTypes = new ArrayList<>();
        houseTypes.add("Bussniess House");
        houseTypes.add("Econo House");
        houseTypes.add("Classic House");
        model.addAttribute("houseTypes", houseTypes);
        
        List<House> houses = new ArrayList<>();
        houses.add(new House("Shark House"));
        model.addAttribute("houses", houses);
        
        String json = "{\"hello\":\"world\",\"error\":0}";
        JSONObject respJSON = JSONObject.parseObject(json);
        model.addAttribute("json", respJSON);
        
        model.addAttribute("json_str", json);
        
        model.addAttribute("host", restfulConf.getHost());
        
        return "add_house";
    }
    
    @Autowired
    private RestfulConfigBean restfulConf;
}
