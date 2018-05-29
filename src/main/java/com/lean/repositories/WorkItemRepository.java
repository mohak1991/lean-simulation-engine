package com.lean.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lean.models.WorkItem;

public interface WorkItemRepository extends CrudRepository<WorkItem, Integer> {

}
