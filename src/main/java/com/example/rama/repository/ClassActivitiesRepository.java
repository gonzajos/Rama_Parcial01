package com.example.rama.repository;

import com.example.rama.model.ClassActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassActivitiesRepository extends JpaRepository<ClassActivities, Long> {
}
