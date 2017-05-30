package com.demo.redis;

import org.junit.Test;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * https://github.com/xetorthio/jedis/wiki/Getting-started
 * Created by WangOld on 2017/4/24.
 */
public class RedisTest {
    @Test
    public void testConnection() {
        Jedis jedis = new Jedis("localhost");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println("value=" + value);
    }

    @Test
    public void testPoolConnection() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        JedisPool pool = new JedisPool(jedisPoolConfig, "localhost");
        /// Jedis implements Closeable. Hence, the jedis instance will be auto-closed after the last statement.
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            /// ... do stuff here ... for example
            jedis.set("foo", "bar");
            String foobar = jedis.get("foo");
            jedis.zadd("sose", 0, "car");
            jedis.zadd("sose", 0, "bike");
            Set<String> sose = jedis.zrange("sose", 0, -1);
            System.out.println("foobar=" + foobar + "sose=" + sose);
        } finally {
            assert jedis != null;
            jedis.close();
        }
        /// ... when closing your application:
        pool.destroy();
    }

    @Test
    public void testMoreConnection() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        List<JedisShardInfo> shardInfoList = new ArrayList<JedisShardInfo>();
//        shardInfoList.add(new JedisShardInfo("192.168.1.102", 6379));
        shardInfoList.add(new JedisShardInfo("127.0.0.1", 6379));

        //connect refused
        //error connection
//        shardInfoList.add(new JedisShardInfo("192.168.1.101",6379));
        //定义集群连接池
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(jedisPoolConfig, shardInfoList);
        ShardedJedis shardedJedis = null;
        //从连接池中获取jedis分片对象
        try {
            shardedJedis = shardedJedisPool.getResource();
            for(int i=0;i<100;i++){
                shardedJedis.set("key_"+i,"value_"+i);
            }
            System.out.println(shardedJedis.get("key_18"));
            System.out.println(shardedJedis.get("key_20"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            shardedJedis.close();
            shardedJedisPool.close();
        }


    }
}
