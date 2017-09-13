package com.testPlatform.demo.tools;/**
 * Created by guojingjing on 13/9/17.
 */

/**
 ** @description 字符串工具$
 ** Created by guojingjing on 13/9/17. 
 **/
public class StringUtil {

//    判断字符串是否为null
    public static boolean isNull( String obj ){
        if (obj == null){
            return true;
        }else if (obj.toString().trim().equals("")){
            return true;
        }else if (obj.toString().trim().toLowerCase().equals("null")){
            return true;
        }
        return false;
    }
}
