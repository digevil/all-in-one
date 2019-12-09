package org.digevil.allinone.classic.service;

public interface IRedisService {

    String get(String key);

    void set(String key, String value);
}
