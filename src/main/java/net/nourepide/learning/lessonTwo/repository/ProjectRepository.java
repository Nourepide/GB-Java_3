package net.nourepide.learning.lessonTwo.repository;

import net.nourepide.learning.lessonTwo.enity.Project;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProjectRepository {
    @Select("SELECT * FROM `users`")
    List<Project> findAll();

    @Select("SELECT id FROM `users`")
    List<String> ids();

    @Select("SELECT * FROM `users` WHERE id = #{id}")
    Project findOne(String id);

    // Don't work
    @Insert("INSERT INTO `users` (`id`, `name`, `password`) VALUES (#{id}, #{name}, #{password})")
    void insert(Project project);

    // Crash - "UPDATE `users` (`name`, `password`) <-...
    @Update("UPDATE `users` SET `name` = #{name}, `password` = #{password} WHERE `id` = #{id}")
    void update(Project project);

    @Delete("DELETE FROM `users`")
    void clear();
}
