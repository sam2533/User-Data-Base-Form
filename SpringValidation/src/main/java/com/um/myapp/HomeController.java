package com.um.myapp;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.um.myapp.model.Employee;
import com.um.myapp.service.EmployeeValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private Map<String, Employee> employee;
	@Autowired
	@Qualifier("employeeValidator")
	private Validator validator;
	
	public HomeController(){
		employee = new HashMap<String,Employee>();
	}
	/*
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}
	*/
	public Employee createEmployee(){
		return new Employee();
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome to the Login Page");
		model.addAttribute("employee", new Employee());	
		return "employeeLogin";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") @Valid Employee emp, 
								BindingResult result,  Model model){
		
		new EmployeeValidator().validate(emp, result);
		if(result.hasErrors()){
			logger.info("Return to the Login Page");
			return "employeeLogin";
		}else
			logger.info("Login is successfully done");
			model.addAttribute("employee", emp);
			employee.put(emp.getUserName(), emp);
		return "employeeSuccess";	
	}
	
}
