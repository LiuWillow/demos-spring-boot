package com.lwl.mybatis.origin.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * author liuweilong
 * date 2020/3/11 11:36 下午
 * desc
 */
@Service
public class ShitService {
    private static final List<String> SHITS = new ArrayList<>();

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void haha() {
        System.out.println("hah");
    }

    public String createShit() {
        return String.valueOf(new Random().nextInt(10000));
    }

    public void tryOOM() {
        for (int i = 0; i < Integer.MIN_VALUE; i++) {
            SHITS.add(createShit());
        }
        System.out.println(SHITS);
    }

    @Data
    private static class Node {
        public Node(Integer val) {
            this.val = val;
        }

        Node next;
        Integer val;
    }

    public void tryStackOverflow() {
        Node node = new Node();
        node.val = 1;

        addRecur(node);
        System.out.println(node);
    }

    public void addRecur(Node node) {
        node.next = new Node(new Random().nextInt(100));

        addRecur(node);
    }
}
