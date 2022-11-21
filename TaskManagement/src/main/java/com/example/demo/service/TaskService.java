package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Task;
import com.example.demo.repo.TaskRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	@Autowired
	private TaskRepo repository;
	
    //Get all tasks
    public List<Task> getTasks(){
   	 return repository.findAll();
    }
    
    //Get tasks by using task id
    public Optional<Task> getTaskById(int id){
   	 return repository.findById(id);
    }
    
    //Add task
    public Task addTask(Task task)
    {
    	return repository.save(task);
    }
    
//    public void addTask(int taskid,String taskName,String startTime,String endTime,String taskdec,Date Date) {
//    	Task task=new Task();
//    	task.setTaskid(taskid);
//    	task.setTaskName(taskName);
//    	task.setStartTime(startTime);
//    	task.setEndTime(endTime);
//    	task.setTaskdec(taskdec);
//    	task.setDate(Date);
//    	repository.save(task);
//    }
    
    public String deleteTask(int id) {
		repository.deleteById(id);
		return "Task Deleted";
	}
    //Get task by profile id
    public List<Task> getTaskByProfileId(int pid){
    	List<Task> list=repository.findByProfileId(pid);
    	return list;
    	
    }
    //Update task
    public Task updateTask(int id,Task task) {
    	Task updateTask=repository.findById(id).orElse(null);
    	updateTask.setTaskName(task.getTaskName());
    	updateTask.setTaskdec(task.getTaskdec());
    	return repository.save(updateTask);
    }
    
}
