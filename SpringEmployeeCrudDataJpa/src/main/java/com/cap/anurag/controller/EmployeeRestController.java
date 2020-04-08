package com.cap.anurag.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.anurag.entity.Employee;
import com.cap.anurag.service.EmployeeService;


@RestController

@RequestMapping("/bank")
@CrossOrigin("http://localhost:4200")
public class EmployeeRestController {

	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="controller employeeid is not present")
	@ExceptionHandler({Exception.class})
	public void handleException()
	{
		
	}
	
	
	@Autowired
	EmployeeService empService;
	
	// creating account
	@PostMapping("/CreateAccount")
	public String createAccount(@RequestBody Employee emp)
	{
		Employee employee=empService.createEmployee(emp);
		if(employee==null)
		{
			return "Insertion Failed!!!!!";
		}
		else
		{
			return "Inserted the record Successfully!!!!!!";
		}
		
	}
	
	
	
	//list all employees
	@GetMapping("/ListAllEmployees")
	public List<Employee> findAllEmployees()
	{
		return empService.findAllEmployees();
	}
	
	
	//update employee
	@PutMapping("/updateEmp")
	public String updateEmp(@RequestBody Employee emp)
	{
		Employee emp1= empService.updateEmployee(emp);
		if(emp1!=null)
		{
			return "updated the records Successfully as "+emp.getEid()+" "+emp.getEname()+" "+emp.getEsal();
		}
		else
		{
			return "employee details not updated";
		}
	}
	
	//find employee by id
	@GetMapping("/findById/{empId}")
	public Optional<Employee> findEmployeeById(@PathVariable Integer empId)
	{
		return empService.findEmployeeById(empId);
		
	}
	
	//delete employee by id
	@DeleteMapping("/deleteById/{empId}")
    public void deleteEmployeeById(@PathVariable Integer empId)
    {
	   empService.deleteEmployeeById(empId); 
    }
	
    //delete all employees
	@DeleteMapping("/deleteAllEmployees")
	public void deleteAllEmployees()
	{
		empService.deleteAllEmployees();
		System.out.println("Deleted Successfully:");
	}
  }
