/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tujia.front.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author huangwei
 */
@Configuration
public class RestfulConfig {
    @Bean(name="devRestfulConfig")
    @Profile("dev")
    public RestfulConfigBean devRestfulConfig() {
//        return new RestfulConfigBean("www1.fvt.tujia.com");
        return new RestfulConfigBean("www.baidu.com");
    }
}
