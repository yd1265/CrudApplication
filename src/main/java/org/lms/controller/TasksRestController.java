package org.lms.controller;
import java.util.Date;
import org.lms.models.Tasks;
import org.lms.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TasksRestController {
 @Autowired
 private TasksService tasksService;
 
	@GetMapping("/hello")
	public String hello(){
		return "hello Word !";
	}
	
	
	@GetMapping("/all-tasks")
	public String allTasks(){
		return tasksService.findTasks().toString();
	}
	
	
	@GetMapping("/save-task")
	public String savaTask(@RequestParam String name,@RequestParam String dec){
	  Tasks task=new Tasks(name, dec, new Date(), false);
	   tasksService.saveTasks(task);
		    
	   return "task saved";	
		
	}
	
	@GetMapping("/delete-task")
	
	public String deleteTask( @RequestParam long id){
		tasksService.deleteTasks(id);
		return "task deleted ";
	}
		
	@GetMapping("/get-task")
	public String getTask(@RequestParam long id){
		Tasks t=tasksService.getTasks(id).get();
		  t.toString();
		  return "task getted";
	}
	
}
