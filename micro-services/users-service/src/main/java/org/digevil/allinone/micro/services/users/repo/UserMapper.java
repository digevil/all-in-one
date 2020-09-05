package org.digevil.allinone.micro.services.users.repo;

import org.apache.ibatis.annotations.*;
import org.digevil.allinone.core.model.User;

import java.util.List;
import java.util.UUID;

/**
 * 通用参考:
 * https://www.cnblogs.com/caizhaokai/p/10982727.html
 * <p>
 * 增强注解:
 * https://www.jianshu.com/p/03642b807688
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM all_user")
    List<User> findAll();

    @Select("SELECT * FROM all_user")
    List<User> findAllPaged();

    @Select("SELECT * FROM all_user WHERE id = #{id}")
    User findById(@Param("id") int id);

    @Select({"<script>",
            "SELECT * FROM all_user",
            "WHERE 1=1",
            "<when test='example.id!=null'>",
            "AND \"id\" = #{example.id}",
            "</when>",
            "<when test='example.name!=null'>",
            "AND \"name\" = #{example.name}",
            "</when>",
            "</script>"})
    List<User> findByExample(@Param("example") User example);

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
