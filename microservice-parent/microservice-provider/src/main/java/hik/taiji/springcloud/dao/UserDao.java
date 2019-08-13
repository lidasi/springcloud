package hik.taiji.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hik.taiji.springcloud.entity.User;

@Mapper
public interface UserDao {
	public boolean addUser(User user);
	
	public User getUser(int id);
	
	public List<User> getUsers();
}
