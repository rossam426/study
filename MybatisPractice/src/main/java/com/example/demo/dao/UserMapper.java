package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.UserEntity;

@Mapper
public interface UserMapper {
	
	/**
	 * ユーザー情報の全検索
	 * 
	 * @return
	 */
	List<UserEntity> findAll();
	
	/**
	 *  
	 * ユーザー情報の主キー検索
	 */
	// TODO 課題1 下記に記載
	//※メソッドの戻り値の型はServiceクラスの呼び出し元と同じにする
	UserEntity findById(@Param("id") Integer id);
	
	/**
	 * 
	 * ユーザー情報 新規登録
	 */
	// TODO 課題2 下記に記載
	//※メソッドの戻り値の型はServiceクラスの呼び出し元と同じにする
	void create(UserEntity user);
	
	/**
	 * ユーザー情報 更新
	 * 
	 */
	// TODO 課題3 下記に記載
	//※メソッドの戻り値の型はint型にします
	int update(UserEntity user);
}
