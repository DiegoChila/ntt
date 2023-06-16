package com.ntt.demo.persistence.cruds;

import com.ntt.demo.persistence.entities.ConfigEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ConfigCrudRepository extends CrudRepository<ConfigEntity, Integer> {

    Optional<ConfigEntity> findFirstByOrderByIdDesc();
}
