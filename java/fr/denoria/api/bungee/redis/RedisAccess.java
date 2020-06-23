package fr.denoria.api.bungee.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;

public class RedisAccess {
    private final RedissonClient redissonClient;
    public static RedisAccess INSTANCE;

    public RedisAccess(RedisCredentials redisCredentials){
        INSTANCE = this;
        this.redissonClient = initRedisson(redisCredentials);
    }

    public static void init(){

        new RedisAccess(new RedisCredentials("127.0.0.1", "''", 6379));
    }
    public static void close(){
        RedisAccess.INSTANCE.getRedissonClient().shutdown();
    }

    public RedissonClient initRedisson(RedisCredentials redisCredentials){
        final Config config = new Config();

        config.setCodec(new JsonJacksonCodec());
        config.setUseLinuxNativeEpoll(true);
        config.setThreads(4);
        config.setNettyThreads(4);
        config.useSingleServer()
                .setAddress(redisCredentials.toRedisURL())
                .setPassword(redisCredentials.getPassword())
                .setDatabase(3)
                .setClientName(redisCredentials.getClientName());

        return Redisson.create(config);
    }

    public RedissonClient getRedissonClient() {
        return redissonClient;
    }
}
