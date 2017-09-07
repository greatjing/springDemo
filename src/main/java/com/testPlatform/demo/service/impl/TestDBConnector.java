package com.testPlatform.demo.service.impl;/**
 * Created by guojingjing on 7/9/17.
 */

import com.testPlatform.demo.service.DBConnectorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 ** @description $
 ** Created by guojingjing on 7/9/17. 
 **/


/**
 * 测试环境
 */
@Component
@Profile("testdb")
public class TestDBConnector implements DBConnectorService{
    @Override
    public void config(){
        System.out.print("testdb");
    }
}

@Component
@Profile("devdb")
 class DevDBConnector implements DBConnectorService{
    @Override
    public void config(){
        System.out.print("devdb");
    }
}






