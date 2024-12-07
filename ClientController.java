package com.klef.jfsd.springboot.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController 
{
	List<Student> students = new ArrayList<Student>();
	
	@RequestMapping(path = "/",method = RequestMethod.GET)
	public String demo() {
		return "Hello Spring Boot";
	}
	
	@RequestMapping(path = "/demo1")
	public String demo1() {
		return "Page Not Found";
	}
	
	@GetMapping(path = "demo2")
	public String demo2() {
		return "Error Occurred";
	}
	
	@GetMapping("demo3")
	public int demo3()
	{
		return 73;
	}
	
	@GetMapping("demo4")
	public double demo4() {
		return 2400.0;
	}
	
	//Passing parameters to the URL 
	
	@GetMapping("demo5")
	public String demo5(@RequestParam("id")  int eid) {
		return "Employee ID:" + eid;
	}
	
	@GetMapping("demo6")
	public String demo6(@RequestParam("a")  int p,@RequestParam("b")  int q) {
		int r = p+q;
		return Integer.toString(r);
	}
	
	@GetMapping("demo7/{id}")
	public String demo7(@PathVariable("id")  int eid) {
		return "Employee ID:" + eid;
	
	}
	
	@GetMapping("demo8/{p}/{q}")
	public String demo8(@PathVariable("p")  int a ,@PathVariable("q") int b)
	{
		int r = a + b;
		return Integer.toString(r);
		
		
	}
	
	
	@PostMapping("addstudent")
	public String addstudent(@RequestBody  Student s)
	{
		students.add(s);
		return "Student Added successfully";
		
	}
	
	@GetMapping("viewallstudents")
	public List<Student> viewallstudents()
	{
		return students;
		
	}
	
	@GetMapping("studentcount")
	public String studentcount() {
		
		if(students.size() != 0) {
			int count = students.size();
			return Integer.toString(count);
		}else {
			return "Student Data Not Found";
		}
	}
	
	

}
