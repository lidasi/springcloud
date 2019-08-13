package hik.taiji.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hik.taiji.springcloud.entity.User;
import hik.taiji.springcloud.service.ConsumerService;

@Controller
@RequestMapping(value="consumer-hystrix")
public class UserHystrixController {

	@Autowired
	ConsumerService consumerService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/lists")
	@ResponseBody
	public List<User> getUserInfo(){
		@SuppressWarnings("rawtypes")
		List list = consumerService.getAlls1();
		return list;
	}
	
	@RequestMapping(value="/consumer/get/{id}")
	@ResponseBody
	public User get(@PathVariable("id") int id){
		User user = consumerService.getId1(id);
		return user;
	}
}
