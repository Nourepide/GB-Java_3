package net.nourepide.learning.two.repository;

import net.nourepide.learning.two.enity.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UsersRepository {
    @Select("SELECT * FROM `users`")
    List<Users> findAll();

    @Select("SELECT id FROM `users`")
    List<String> ids();

    @Select("SELECT * FROM `users` WHERE id = #{id}")
    Users findOne(String id);

    // Don't work
    @Insert("INSERT INTO `users` (`id`, `name`, `password`) VALUES (#{id}, #{name}, #{password})")
    void insert(Users users);

    // Crash - "UPDATE `users` (`name`, `password`) <-...
    @Update("UPDATE `users` SET `name` = #{name}, `password` = #{password} WHERE `id` = #{id}")
    void update(Users users);

    @Delete("DELETE FROM `users`")
    void clear();
}
