package xyz.test.controller;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.test.pojo.Person;
import xyz.test.pojo.Role;
import xyz.test.pojo.User;
import xyz.test.service.RoleService;
import xyz.test.service.UserService;

@Controller
@CrossOrigin
public class JSONController {
    
    private final String SUCCESS= "Success";
    private final String FAIL= "Fail";

    @Autowired
    private UserService userService;
    
    @Autowired 
    private RoleService roleService;
    
    
    @RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
    public @ResponseBody Person getPersonInJSON(@PathVariable String name, HttpServletResponse response) {

	Person person = new Person();
	person.setName(name);

	return person;
    }
    
    
    // USER OBJECT
    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public @ResponseBody User getUserInJSON(@PathVariable String name, HttpServletResponse response) {

	User user = userService.findByUsername(name);
	if (user == null)
	    response.setStatus(HttpStatus.NO_CONTENT.value());

	return user;
    }
    
    @RequestMapping(value = "/user", method= RequestMethod.POST, consumes= "application/json")
    public @ResponseBody String putUserJSON(@RequestBody User user, HttpServletResponse response){
	
	Set<ConstraintViolation<User>> errors =  userService.isValidForCreate(user);
	
	if (errors.size() != 0){
	    response.setStatus(HttpStatus.BAD_REQUEST.value());
	    return FAIL;
	}
	
	userService.create(user);
	
	return SUCCESS;
    }
    
    // ROLE OBJECT
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public @ResponseBody Role getRoleInJSON(@PathVariable Integer id, HttpServletResponse response) {

	Role role = roleService.findByPrimaryKey(id);
	if (role == null)
	    response.setStatus(HttpStatus.NO_CONTENT.value());

	return role;
    }
    
    @RequestMapping(value = "/role", method= RequestMethod.POST, consumes= "application/json")
    public @ResponseBody String putRoleJSON(@RequestBody Role role, HttpServletResponse response){
	
	Set<ConstraintViolation<Role>> errors =  roleService.isValidForCreate(role);
	
	if (errors.size() != 0){
	    response.setStatus(HttpStatus.BAD_REQUEST.value());
	    return FAIL;
	}
	
	roleService.create(role);
	
	return SUCCESS;
    }

}