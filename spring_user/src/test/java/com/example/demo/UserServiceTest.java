package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

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
	void searchAll_モックを使ってDB依存を回避() {
		UserEntity user = new UserEntity();
		user.setId(1);
		user.setName("衣織");
		
		List<UserEntity> list = new ArrayList<>();
		list.add(user);
		
		when(userRepository.findAll()).thenReturn(list);
		List<UserEntity> result = userService.searchAll();
		
		UserEntity testUser = result.get(0);
		String name = testUser.getName();
		assertEquals("衣織", name);
	}

}
