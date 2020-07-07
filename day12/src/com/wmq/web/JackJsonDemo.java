package com.wmq.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月07日 20:35:00
 * @Description: TODO
 */
public class JackJsonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        //获取转换对象
        ObjectMapper objectMapper = new ObjectMapper();
        String[] str = {"貂蝉", "杨贵妃", "西施", "王昭君"};
        /**
         * 数组转换json
         */
        String s = objectMapper.writeValueAsString(str);
        System.out.println(s);

        /**
         * list集合转为json
         */
        List<String> list = new ArrayList<String>();
        list.add("宝强");
        list.add("乃亮");
        list.add("羽凡");
        list.add("大郎");
        String s1 = objectMapper.writeValueAsString(list);
        System.out.println("list = " + s1);

        /**
         * map集合转换为json
         */
        Map<String, Object> map = new HashMap<>();
        map.put("name","柳岩");
        map.put("age",38);
        String s2 = objectMapper.writeValueAsString(map);
        System.out.println("s2 = " + s2);
    }
}
