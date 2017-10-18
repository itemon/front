/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tujia.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author huangwei
 */
@Controller
@RequestMapping("/pwa")
public class PWAGeneralController {
    @RequestMapping("/{module}/{page}.htm")
    @ResponseBody
    public String render(
            @PathVariable("module") String module, 
            @PathVariable("page") String page) {
        return "module:"+module+" ; page: "+page;
    }
}
