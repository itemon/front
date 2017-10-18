/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tujia.front.test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author huangwei
 */
public class HttpClientJUnitTest {
    
    public HttpClientJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testHttpClient() throws InterruptedException, ExecutionException, IOException {
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        
        int statusCode = 0;
        String respText = null;
        
        try {
            client.start();

            HttpGet request = new HttpGet("https://www.tujia.com/bingo/pc/keyword/KeywordSearchSuggest");
            Future<HttpResponse> future = client.execute(request, null);
            HttpResponse resp = future.get();
            statusCode = resp.getStatusLine().getStatusCode();
            respText = EntityUtils.toString(resp.getEntity());
        } finally {
            client.close();
        }
        
        assertEquals("Http status is not 200, not work as expected", 200, statusCode);
        System.out.println(respText);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
