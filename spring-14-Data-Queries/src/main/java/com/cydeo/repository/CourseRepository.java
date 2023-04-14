package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // Find all courses by category => SELECT * FROM COURSES WHERE CATEGORY = ....
    List<Course> findByCategory(String category);

    // Find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    // Checks if a course with the supplied name exists. Return true if exist, false otherwise
    boolean existsByName(String name);

    // Returns the count of courses for the given category
    int countByCategory(String category);

    // Finds all the courses that starts with the given course name string
    List<Course> findByNameStartsWith(String name);

    // Find all courses by category and returns a stream
    Stream<Course> streamAllByCategory(String category);

    @Query("SELECT c FROM Course c WHERE c.category = : category AND c.rating > : rating")
    List<Course> retrieveAllByCategoryAnrRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);






}
