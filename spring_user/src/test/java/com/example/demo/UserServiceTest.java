package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;
	
	@Test
	void findById_モックを使ってDB依存を回避() {
		UserEntity user = new UserEntity();
		user.setId(1);
		user.setName("衣織");
		
		when(userRepository.getOne(1)).thenReturn(user);
		UserEntity result = userService.findById(1);
		assertEquals("衣織", result.getName());
	}

}
