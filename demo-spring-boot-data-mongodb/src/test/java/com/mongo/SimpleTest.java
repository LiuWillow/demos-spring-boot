package com.mongo;

import org.junit.Test;

/**
 * @author lwl
 * @date 2018/10/18 17:25
 * @description
 */
public class SimpleTest {
    @Test
    public void testUtil(){
        System.out.println(DateUtils.getSpecifiedTimeFromNow(DateUtils.TYPE_BEFORE, 10));
    }
}