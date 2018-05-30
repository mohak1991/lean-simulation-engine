package com.lean.repositories;

import org.springframework.data.repository.CrudRepository;
import com.lean.models.Process;

public interface ProcessRepository extends CrudRepository<Process, Integer> {

}
