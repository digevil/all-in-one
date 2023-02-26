package org.digevil.allinone.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.Map;

public class LettuceTest {
    public static void main(String[] args) {
        // connect
        RedisClient redisClient = RedisClient
                .create("redis://localhost:6379/");
        StatefulRedisConnection<String, String> connection
                = redisClient.connect();

        try {
            // create sync commands
            RedisCommands<String, String> syncCommands = connection.sync();

            String testLettuce = "test_lettuce";
            String helloWorld = "hello_world";

            // set
            syncCommands.set(testLettuce, helloWorld);
            // get
            String helloWorldValue = syncCommands.get(helloWorld);
            assert helloWorldValue.equals(helloWorld);

            String recordName = "recordName";
            syncCommands.hset(recordName, "FirstName", "John");
            syncCommands.hset(recordName, "LastName", "Smith");
            Map<String, String> record = syncCommands.hgetall(recordName);
            System.out.println("sync.hgetall: " + record);

            // create async commands
            RedisAsyncCommands<String, String> asyncCommands = connection.async();

            // async get
            RedisFuture<String> asyncRecord = asyncCommands.get(testLettuce);
            String asyncHelloWorldValue = asyncRecord.get();
            System.out.println("async.get: " + asyncHelloWorldValue);

            // async lists operation
            String tasks = "tasks";
            asyncCommands.lpush(tasks, "firstTask");
            asyncCommands.lpush(tasks, "secondTask");
            RedisFuture<String> firstTask = asyncCommands.rpop(tasks);

            String firstTaskValue = firstTask.get();
            System.out.println("async.rpop: " + firstTaskValue);

            // async sets operation

            // async hashes

            // async sorted sets

            // transactions

            // batching

            // publish/subscribe

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }
}
