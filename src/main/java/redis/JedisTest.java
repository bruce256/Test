package redis;


import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.util.Hashing;

import java.util.Arrays;
import java.util.List;

/**
 * @auther: LvSheng
 * @date: 2024/11/20
 * @description:
 */
public class JedisTest {
    public static void main(String[] args) {
        //设置连接池的相关配置
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(2);
        poolConfig.setMaxIdle(1);
        poolConfig.setMaxWaitMillis(2000);
        poolConfig.setTestOnBorrow(false);
        poolConfig.setTestOnReturn(false);

        //设置Redis信息
        String         host       = "127.0.0.1";
        JedisShardInfo shardInfo1 = new JedisShardInfo(host, 6379, 500);
        JedisShardInfo shardInfo2 = new JedisShardInfo(host, 6379, 500);
//        shardInfo1.setPassword("test123");

        //初始化ShardedJedisPool
        List<JedisShardInfo> infoList  = Arrays.asList(shardInfo1, shardInfo2);
        ShardedJedisPool     jedisPool = new ShardedJedisPool(poolConfig, infoList, Hashing.MURMUR_HASH);
        ShardedJedis         jedis     = jedisPool.getResource();
        jedis.set("lvsheng", "lvsheng");

    }
}
