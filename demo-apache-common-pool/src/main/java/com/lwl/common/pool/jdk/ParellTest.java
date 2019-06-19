package com.lwl.common.pool.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/17 10:40
 */
public class ParellTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("sdf");
        list.add(";kdf");
        list.add("ffff");
        list.add("sdsss");
        list.parallelStream().forEach(System.out::println);
        System.out.println("-------------");
        list.stream().forEach(System.out::println);
    }
}
