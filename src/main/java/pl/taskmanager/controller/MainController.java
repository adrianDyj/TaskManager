package pl.taskmanager.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.taskmanager.model.Task;
import pl.taskmanager.service.impl.TaskServiceImpl;

@Controller
public class MainController {

	@Autowired
	private TaskServiceImpl taskServiceImpl;

	@GetMapping("/")
	public String home(Model model){
		model.addAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/all-tasks")
	public String allTasks(Model model){
		model.addAttribute("tasks", taskServiceImpl.findAll());
		model.addAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/new-task")
	public String newTask(Model model){
		model.addAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, Model model){
		task.setDateCreated(new Date());
		taskServiceImpl.save(task);
		model.addAttribute("tasks", taskServiceImpl.findAll());
		model.addAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/update-task")
	public String updateTask(@RequestParam long id, Model model){
		model.addAttribute("task", taskServiceImpl.findTask(id));
		model.addAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam long id, Model model){
		taskServiceImpl.delete(id);
		model.addAttribute("tasks", taskServiceImpl.findAll());
		model.addAttribute("mode", "MODE_TASKS");
		return "index";
	}
}
