package org.lms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.lms.models.Tasks;
import org.lms.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TasksService {

	@Autowired
	private TasksRepository tasksRepository;
	
	public void saveTasks(Tasks task) {
     tasksRepository.save(task);		
	}

	public void deleteTasks(long id) {
      tasksRepository.deleteById(id);		
	}
	
	
	public Collection<Tasks> findTasks(){
		List<Tasks> tasks=new ArrayList<Tasks>();
		for(Tasks task: tasksRepository.findAll()){
			tasks.add(task);
		}
		return tasks;
	}

	public  Optional<Tasks> getTasks(long id) {
       return tasksRepository.findById(id)	;	
	}
}
