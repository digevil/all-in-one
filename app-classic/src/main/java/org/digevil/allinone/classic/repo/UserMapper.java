package org.digevil.allinone.classic.repo;

import org.apache.ibatis.annotations.*;
import org.digevil.allinone.core.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM all_user")
    List<User> findAll();

    @Select("SELECT * FROM all_user")
    List<User> findAllPaged(@Param("pageable") Pageable pageable);

    @Select("SELECT * FROM all_user WHERE id = #{id}")
    User findById(@Param("id") UUID id);

    /**
     * 参考:
     * https://stackoverflow.com/questions/2944297/postgresql-function-for-last-inserted-id
     * https://stackoverflow.com/questions/49589028/mybatis-returning-id-on-upsert
     *
     * @param user
     * @return
     */
    @Select({"INSERT INTO all_user (name) VALUES (#{name}) RETURNING id"})
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    UUID insert(User user);

    @Update("UPDATE all_user SET name = #{name} WHERE id = #{id}")
    void update(User user);

    @Delete("DELETE FROM all_user WHERE id = #{id}")
    void delete(UUID id);
}
