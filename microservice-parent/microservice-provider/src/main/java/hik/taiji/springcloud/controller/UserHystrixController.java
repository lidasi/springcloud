package hik.taiji.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import hik.taiji.springcloud.entity.User;
import hik.taiji.springcloud.service.UserService;

@Controller
@RequestMapping(value="/provider-hystrix")
public class UserHystrixController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/getUser/lists")
	@ResponseBody
	public List<User> getUsers(){
		List<User> users = service.getUsers();
		return users;
	}
	
	@RequestMapping(value="/get/{id}")
	@HystrixCommand(fallbackMethod="hystrixGetUser") //一旦服务调用失败，就调用hystrixGetUser方法
	@ResponseBody
	public User getUser(@PathVariable("id") int id){
		User user = service.getUser(id);
		if(user == null){
			throw new RuntimeException("不存在id=" + id + "对应的用户信息");
		}
		return user;
	}
	
	public User hystrixGetUser(@PathVariable("id") int id){
		User user = new User(id, "不存在该用户", 0);
		return user;
	}
}
