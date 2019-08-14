package hik.taiji.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hik.taiji.springcloud.entity.User;
import hik.taiji.springcloud.service.UserService;

@Controller
@RequestMapping(value="/provider-feign")
public class UserFeignController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/getUser/lists")
	@ResponseBody
	public List<User> getUsers(){
		List<User> users = service.getUsers();
		return users;
	}
	
	@RequestMapping(value="/get/{id}")
	@ResponseBody
	public User getUser(@PathVariable("id") int id){
		User user = service.getUser(id);
		return user;
	}
}
