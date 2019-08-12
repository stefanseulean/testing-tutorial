package com.tutorial.testing.repository;

import com.tutorial.testing.entitites.BlueprintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlueprintRepository extends JpaRepository<BlueprintEntity, Long> {

}
