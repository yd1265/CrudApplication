package org.lms.repository;

import org.lms.models.Tasks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TasksRepository extends CrudRepository<Tasks, Long> {

}
