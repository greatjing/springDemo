package com.testPlatform.demo.tools;/**
 * Created by guojingjing on 14/9/17.
 */

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 ** @description $
 ** Created by guojingjing on 14/9/17. 
 **/
public class ServletUtil {

    //响应contenttype内容
    private static final String RESPONSE_CONTENTTYPE = "application/json";

    //响应编码
    private static final String RESPONSE_CHARACTERENCODING = "utf-8";

    //日志
    private static Logger log = Logger.getLogger(ServletUtil.class);


    public static String createSuccessResponse(Integer httpCode, Object result, HttpServletResponse response){
        return createSuccessResponse(httpCode, result, SerializerFeature.WriteMapNullValue, null, response);
    }

    public static String createSuccessResponse(Integer httpCode, Object result, SerializerFeature serializerFeature, SerializeFilter filter, HttpServletResponse response){
        PrintWriter printWriter = null;
        String jsonString = "";

        try {
            response.setCharacterEncoding(RESPONSE_CHARACTERENCODING);
            response.setContentType(RESPONSE_CONTENTTYPE);
            response.setStatus(httpCode);
            printWriter = response.getWriter();
            if (null != result){
                if(null != filter){
                    jsonString = JSONObject.toJSONString(result, filter, serializerFeature);
                }else {
                    jsonString = JSONObject.toJSONString(result, serializerFeature);
                    //jsonString = JSONObject.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:ss:mm", serializerFeature);
                }
                printWriter.write(jsonString);
            }
            printWriter.flush();
        }catch (Exception e){
            log.error("cteateResponse failed", e);
        }finally {
            if(null != printWriter) printWriter.close();
        }
        return jsonString ;
    }
}
