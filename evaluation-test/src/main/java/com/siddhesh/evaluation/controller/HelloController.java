package com.siddhesh.evaluation.controller;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siddhesh.evaluation.persistance.Number;
import com.siddhesh.evaluation.persistance.NumberDao;

/**
* The HelloController program, which have method for 
* 1. increment int type field in table Number and return
* value of field.
* 2. reset zero int type in table Number. 
* 
*
* @author  Siddhesh Mani
* @version 1.0
* @since   2019-02-09 
*/

@RestController
public class HelloController {
	
	@Autowired
    NumberDao dao;

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    
    /**
    * The incrementData() method  increment int type field in table Number
    * and return value of field .
    */
    @RequestMapping("/increment")
    public Number incremetData() throws InterruptedException, ExecutionException {
    	LOGGER.info("Request for increment field of table by 1");
    	return dao.incrementNumbers().get();
    }
    
    /**
     * The resetData() method  set  to zero int type field in table Number
     * and return number of updated rows.
     */
    @RequestMapping("/reset")
    public Number resetData() {
    	int n=dao.resetNumber();
    	LOGGER.info("Table field is set to zero");
    	return new Number(n);
    }
    
}



