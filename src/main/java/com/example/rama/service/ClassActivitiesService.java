package com.example.rama.service;

import com.example.rama.model.ClassActivities;
import com.example.rama.repository.ClassActivitiesRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassActivitiesService {

    private final ClassActivitiesRepository repository;

    public ClassActivitiesService(ClassActivitiesRepository repository) {
        this.repository = repository;
    }

    public List<ClassActivities> findAll() {
        return repository.findAll();
    }

    public void save(ClassActivities activity) {
        repository.save(activity);
    }

    public void delete(ClassActivities activity) {
        repository.delete(activity);
    }
}
