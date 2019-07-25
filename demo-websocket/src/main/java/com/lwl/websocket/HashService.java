package com.lwl.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.SortedMap;

/**
 * author liuweilong
 * date 2019/7/24 18:46
 * desc
 */
@Service
public class HashService {
    public static final int RING_SIZE = 300;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    public static final String KEY_RING = "hash:ring";

    public int hash(String key) {
        return key.hashCode() % RING_SIZE;
    }

    //得到应当路由到的结点（示例代码用String代表的节点）
//    public String getServer(String key) {
//        //得到该key的hash值
//        int hash = hash(key);
//        //得到大于该Hash值的所有Map
//        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
//        if (subMap.isEmpty()) {
//            //如果没有比该key的hash值大的，则从第一个node开始
//            Integer i = sortedMap.firstKey();
//            //返回对应的服务器
//            return sortedMap.get(i);
//        } else {
//            //第一个Key就是顺时针过去离node最近的那个结点
//            Integer i = subMap.firstKey();
//            //返回对应的服务器
//            return subMap.get(i);
//        }
//    }

    /**
     * 把值放入哈希环，找到属于哪个节点，并返回哈希值
     *
     * @param key
     * @return
     */
    public int putInRing(String key) {
        int hash = hash(key);
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        //TODO 这里要用原子操作
        Set<String> nodes = zSetOperations.rangeByScore(KEY_RING, hash, RING_SIZE);
        String targetNode;
//        if (CollectionUtils.isEmpty(nodes)) {
//            zSetOperations.
//        }
        zSetOperations.add(KEY_RING, key, hash);
        return hash;
    }

    /**
     * 把节点放入哈希环
     *
     * @param node
     * @return
     */
    public int putNode(String node) {
        int hash = hash(node);
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add(KEY_RING, node, hash);
        return hash;
    }

    /**
     * 删除哈希环上的某个节点
     *
     * @param key
     * @return
     */
    public int removeRing(String key) {
        int hash = hash(key);
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.remove(KEY_RING, key);
        return hash;
    }


}
