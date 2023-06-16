package com.ntt.demo.persistence.cruds;

import com.ntt.demo.persistence.entities.DeviceEntity;
import org.springframework.data.repository.CrudRepository;

public interface DeviceCrudRepository extends CrudRepository<DeviceEntity, Long> {
}
