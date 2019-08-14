package hik.taiji.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import hik.taiji.springcloud.entity.User;

@Component
public class ConsumerServiceFallbackFactory implements FallbackFactory<ConsumerService> {

	@Override
	public ConsumerService create(Throwable arg0) {
		return new ConsumerService() {

			@Override
			public User get(int id) {
				User user = new User(id, "该用户不存在", 0);
				return user;
			}

			@Override
			public boolean add(User user) {
				return false;
			}

			@Override
			public List<User> getAll() {
				return null;
			}

			@Override
			public List<User> getAlls() {
				return null;
			}

			@Override
			public User getId(int id) {
				User user = new User(id, "该用户不存在", 0);
				return user;
			}

			@Override
			public List<User> getAlls1() {
				return null;
			}

			@Override
			public User getId1(int id) {
				User user = new User(id, "该用户不存在", 0);
				return user;
			}
			
			
		};

	}

}
