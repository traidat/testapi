package com.testAPI.Repository;

import com.testAPI.Entity.TestEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TestEntityRepository extends CrudRepository<TestEntity, UUID> {
}

