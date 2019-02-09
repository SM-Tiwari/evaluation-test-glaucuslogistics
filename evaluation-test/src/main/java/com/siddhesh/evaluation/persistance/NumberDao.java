package com.siddhesh.evaluation.persistance;

import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

/**
* NumberDao class is responsible for connecting to database
* for updating and fetching data from table.
* 
* @author  Siddhesh Mani
* @version 1.0
* @since   2019-02-09 
*/

@Repository
public class NumberDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String FETCH = "select id from number";
    private static final String UPDATE = "update number set id=?";
    
    /**
     * This method access table to increment value in asynchronous way 
     * with the help of TaskExecutor through ThreadConfig class 
     * which is capable to multiple request.
    */
    @Async("specificTaskExecutor")
    @Transactional
    public CompletableFuture<Number> incrementNumbers() {
    	 Number num = new Number();
         int rows = jdbcTemplate.queryForObject(FETCH, Integer.class);
                    jdbcTemplate.update(UPDATE,rows+1);
              num.setId(jdbcTemplate.queryForObject(FETCH, Integer.class));
        return CompletableFuture.completedFuture(num);
    }
    
   
    
    /**
     * The resetNumber() method set zero int type field in table Number
     * and return number of updated rows.
     */
    public int resetNumber() {
    	return jdbcTemplate.update(UPDATE,0);
    	
    }

}
