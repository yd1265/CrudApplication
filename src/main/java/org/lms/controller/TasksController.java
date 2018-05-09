package org.lms.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.lms.models.Tasks;
import org.lms.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TasksController {

	@Autowired
	private TasksService tasksService;
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "HOME");
		return "task";
	}
	
	
	
	@GetMapping("/All-tasks")
	public String allTasks(HttpServletRequest request){
		request.setAttribute("allTasks", tasksService.findTasks());
		request.setAttribute("mode", "TASKS");

		return "task";
	}
	
	@GetMapping("/New-task")
	public String newTask(HttpServletRequest request){
		request.setAttribute("mode", "NEW");
		return "task";
	}
	
	
	@PostMapping("/Save-task")
	public String saveTask(@ModelAttribute Tasks task,BindingResult bindingResult, HttpServletRequest request){
		task.setDuedate(new Date());
		tasksService.saveTasks(task);
		request.setAttribute("allTasks", tasksService.findTasks());
		request.setAttribute("mode", "TASKS");
		return "task";
	}
	
	
	
	@GetMapping("/Update-tasks")
	public String updateTasks(@RequestParam long id, HttpServletRequest request){
		request.setAttribute("allTasks", tasksService.findTasks());

		request.setAttribute("task", tasksService.getTasks(id).get());
		request.setAttribute("mode", "UPDATE");
		return "task";
	}
	
	@GetMapping("/Delete-task")
	public String deleteTasks(@RequestParam long id, HttpServletRequest request){
		tasksService.deleteTasks(id);
		request.setAttribute("allTasks", tasksService.findTasks());
		request.setAttribute("mode", "TASKS");
		return "task";
	}
	

}
