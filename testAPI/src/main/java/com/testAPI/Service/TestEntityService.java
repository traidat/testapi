package com.testAPI.Service;

import com.testAPI.Entity.TestEntity;
import com.testAPI.Repository.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TestEntityService {
    @Autowired
    TestEntityRepository testEntityRepository;

    public boolean saveTempLog(double temp, Long ts) {
        TestEntity testEntity = new TestEntity();
        testEntity.setId(UUID.randomUUID());
        testEntity.setTs(ts);
        testEntity.setAlert(temp + " is too hot!");
        try {
            testEntityRepository.save(testEntity);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveTempLog(double temp, Long ts, UUID id) {
        TestEntity testEntity = new TestEntity();
        testEntity.setId(id);
        testEntity.setTs(ts);
        testEntity.setAlert(temp + " is too hot!");
        try {
            testEntityRepository.save(testEntity);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<TestEntity> get() {
        return (List<TestEntity>) testEntityRepository.findAll();
    }
}
