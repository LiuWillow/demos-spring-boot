package com.redis.tpl;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author liuweilong
 * date 2019/7/25 10:52
 * desc
 */
public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(5);
        queue.add(4);
        queue.add(9);
        queue.add(2);

        queue.contains(4);

        ArrayList<Integer> integers = Lists.newArrayList(1, 3, 5, 2);
        Collections.sort(integers);

    }
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static int sizeForCap(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
