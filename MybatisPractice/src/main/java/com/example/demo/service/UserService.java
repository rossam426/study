package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserMapper;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * TODO ユーザーMapperクラス★
	 */
	@Autowired
	private UserMapper userMapper;

	/**
	 * ユーザー情報 全検索
	 * @return 検索結果
	 */
	public List<UserEntity> searchAll() {

		//★全検索の処理のみ既にMybatisのUserMapperクラスを使用して実装しています。

		return userMapper.findAll();
	}

	/**
	 * ユーザー情報 主キー検索
	 * @return 検索結果
	 */
	public UserEntity findById(Integer id) {

		//★TODO 課題1 MybatisのUserMapperクラスを使用して実装してみましょう

		return userMapper.findById(id);
	}

	/**
	 * ユーザー情報 新規登録
	 * @param user ユーザー情報
	 */
	public void create(UserRequest userRequest) {
		Date now = new Date();
		UserEntity user = new UserEntity();
		user.setName(userRequest.getName());
		user.setAddress(userRequest.getAddress());
		user.setPhone(userRequest.getPhone());
		user.setCreateDate(now);
		user.setUpdateDate(now);
		
		//★TODO 課題2 新規登録をMybatisのUserMapperクラスを使用して実装してみましょう

		userMapper.create(user);
	}

	/**
	 * ユーザー情報 更新
	 * @param user ユーザー情報
	 */
	public void update(UserUpdateRequest userUpdateRequest) {
		UserEntity user = new UserEntity();
		user.setId(userUpdateRequest.getId());
		user.setAddress(userUpdateRequest.getAddress());
		user.setName(userUpdateRequest.getName());
		user.setPhone(userUpdateRequest.getPhone());
		user.setUpdateDate(new Date());
		
		//★TODO 課題3 ユーザー編集の更新をMybatisのUserMapperクラスを使用して実装してみましょう
		//メソッド名はupdateにしてください
		
		userMapper.update(user);
	}

	/**
	 * ユーザー情報 物理削除
	 * @param id ユーザーID
	 */
	public void delete(Integer id) {
		UserEntity user = findById(id);
		userRepository.delete(user);
	}

}