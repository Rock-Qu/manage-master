package com.common.util;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;


@Slf4j
public class MyJsonUtil {

    public static String objectToJsonString(Object object){
        if (null == object){
            return "";
        }

        JSONObject json = JSONObject.fromObject(object);
        String strJson=json.toString();
        log.debug("Object：{}",object);
        log.debug("String：{}",strJson);
        return strJson;
    }







}
