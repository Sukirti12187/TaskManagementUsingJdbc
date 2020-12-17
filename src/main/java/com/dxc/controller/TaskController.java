package com.dxc.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.dao.TaskDAO;
import com.dxc.model.Task;
//import com.dxc.service.TaskService;

@RestController
@RequestMapping("/web")
public class TaskController {

	TaskDAO service=new TaskDAO();
	
	@GetMapping("/tasks")
	public List<Task> getTasks(){
		return service.getAllTasks();
		
	}
	
	@GetMapping("/tasks/{id}")
	public Task getTaskById(@PathVariable int id) {
		return service.getTaskById(id);
	 
	}
	
	@PutMapping("/tasks") 
	public Task addTask(@RequestBody Task task) { 
		return service.addTask(task);
	 
	}
	 
	@PostMapping("/tasks") 
	public Task updateTask(@RequestBody Task t) { 
		return service.updateTask(t);
	 
	}
	
	@DeleteMapping("/tasks/delete/{id}")
	public Task deleteTask(@PathVariable int id) {
		return service.deleteTask(id);
		 
	}
		 
	
}



