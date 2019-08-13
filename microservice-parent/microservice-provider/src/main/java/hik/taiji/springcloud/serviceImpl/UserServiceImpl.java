package hik.taiji.springcloud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hik.taiji.springcloud.dao.UserDao;
import hik.taiji.springcloud.entity.User;
import hik.taiji.springcloud.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean addUser(User user) {
		boolean flag;
		flag = userDao.addUser(user);
		return flag;
	}

	@Override
	public User getUser(int id) {
		System.out.println("id" + id);
		User user = userDao.getUser(id);
		System.out.println("microservice-provider微服务在响应客户端请求……");
		System.out.println("user : " + user);
		return user;
	}

	@Override
	public List<User> getUsers() {
		List<User> users = userDao.getUsers();
		System.out.println("microservice-provider微服务在响应客户端请求……");
		System.out.println("user : " + users.toString());
		return users;
	}

}
