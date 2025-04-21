package com.prac.pracproj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prac.pracproj.Domain.User;
import com.prac.pracproj.Repository.UserRepository;

@SpringBootTest
class PracprojApplicationTests {

	@Autowired
	UserRepository repo;

	@Test
	void testSuccessfulLogin() {
		User user = new User();
		user.setUsername("testuser");
		user.setPassword("testpassword");
		repo.save(user);

		User result = repo.findByUsernameAndPassword("testuser", "testpassword");

		assertNotNull(result);
		assertEquals("testuser", result.getUsername());
		assertEquals("testpassword", result.getPassword());
	}

	void testFailureLogin(){
		User result = repo.findByUsernameAndPassword("wronguser", "wrongpassword");

		assertNull(result);
	}

}
