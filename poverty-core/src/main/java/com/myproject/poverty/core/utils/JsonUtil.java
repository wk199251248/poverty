package com.myproject.poverty.core.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yf_meng on 2016/05/30.
 */
public class JsonUtil {

    /**
     * json转list
     * @param jsonStr
     * @return
     */
    public static List<?> json2List(String jsonStr){
       List<?> list = JSON.parseArray(jsonStr);
        return list;
    }

    /**
     * json转list（实体）
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> json2List(String jsonStr, Class<T> clazz){
        List<T> list = JSON.parseArray(jsonStr, clazz);
        return list;
    }


    /**
     * list转json
     * @param list
     * @return
     */
    public static String list2Json(List<?> list) {
        String json= JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
        return json;
    }

    /**
     * json转map
     * @param json
     * @return
     */
    public static Map<String,String> json2Map(String json){
        Map<String,String> map = (Map<String,String>)JSON.parse(json);
        return map;
    }

    /**
     * map转json
     * @param map
     * @return
     */
    public static String map2Json(Map<?,?> map){
        String json = JSON.toJSONString(map,true);
       return json;
    }

    /**
     * json转jsonObject
     * @param json
     * @return
     */
    public static JSONObject json2Obj(String json){
        JSONObject obj = JSON.parseObject(json);
        return obj;
    }

    public static <T> T json2Obj(String json, Class<T> cls){
        return JSON.parseObject(json, cls);
    }

    public static Object obj2Json(Object obj){
        return JSON.toJSON(obj);
    }

    public static String obj2JsonStr(Object obj){
        return JSON.toJSONString(obj);
    }
}
