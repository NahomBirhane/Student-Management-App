package com.edu.miu.cs.cs425.studenmgmt.model.Repositories;

import com.edu.miu.cs.cs425.studenmgmt.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course ,Long> {
}
