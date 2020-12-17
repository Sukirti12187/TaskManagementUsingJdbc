package com.dxc.repository;

import java.util.List;

import com.dxc.model.Task;

public interface TaskRepository {

	public List<Task> getAllTasks();
	public Task getTaskById(int id);
	public Task addTask(Task task);
	public Task updateTask(Task task);
	public Task deleteTask(int id);
	
}
