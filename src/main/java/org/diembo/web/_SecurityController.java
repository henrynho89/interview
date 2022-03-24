package org.diembo.web;

import java.util.List;

import org.diembo.dao.PersonRepository;
import org.diembo.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class _SecurityController {
	
	@GetMapping(path = "/login")
	private String login() {
		return "Welcome !!!";
	}
	
	@GetMapping(path = "/users")
	private List<Person> users() {
		return personRepository.findAll();
	}
	@Autowired
	private PersonRepository personRepository;
}
