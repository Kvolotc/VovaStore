package store.web.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import store.persistence.entity.User;
import store.service.UserService;

@Component
@Async
public class UserScheduler {

	@Autowired
	private UserService service;

	@Scheduled(fixedDelay = 8640000)

	public void sheckUser() {

		List<User> users = service.findNotActiveUsers();

		for (User user : users) {
			if (System.currentTimeMillis() - user.getRegistrationDate().getTime() >= 8640000) {
				service.delete(user);
				System.out.println(user);
			}

		}
	}

}
