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
@RequestMapping(value="consumer-feign")
public class UserFeignController {

	@Autowired
	ConsumerService consumerService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/lists")
	@ResponseBody
	public List<User> getUserInfo(){
		@SuppressWarnings("rawtypes")
		List list = consumerService.getAlls();
		return list;
	}
	
	@RequestMapping(value="/consumer/get/{id}")
	@ResponseBody
	public User get(@PathVariable("id") int id){
		User user = consumerService.getId(id);
		return user;
	}
}
