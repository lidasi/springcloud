package hik.taiji.springcloud.service;

import java.util.List;

import hik.taiji.springcloud.entity.User;

public interface UserService {
	public boolean addUser(User user);
	
	public User getUser(int id);
	
	public List<User> getUsers();
}
