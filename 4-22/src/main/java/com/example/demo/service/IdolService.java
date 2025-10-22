package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.IdolEntity;
import com.example.demo.form.IdolForm;
import com.example.demo.repository.IdolRepository;

/**
 * アイドル情報 Service
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class IdolService {
	/**
	 * アイドル情報 Repository
	 */
	@Autowired
	private IdolRepository idolRepository;

	/**
	 * アイドル情報 全検索
	 * @return 検索結果
	 */
	public List<IdolEntity> searchAll() {
		return idolRepository.findAllByOrderByIdAsc();
	}

	/**
	 * アイドル情報 新規登録
	 * @param idol アイドル情報
	 */
	public void create(IdolForm idolRequest) {
		IdolEntity idol = new IdolEntity();
		idol.setName(idolRequest.getName());
		idol.setGroup_name(idolRequest.getGroup_name());
		idol.setBirth_day(idolRequest.getBirth_day());
		idol.setBirth_place(idolRequest.getBirth_place());
		idolRepository.save(idol);
	}
	/**
	 * アイドル情報　主キー検索
	 * @return 検索結果
	 */
	public IdolEntity findById(Integer id) {
		return idolRepository.getOne(id);
	}
	
	/**
	 * アイドル情報　更新
	 * @param idol アイドル情報
	 */
	public void update(IdolForm idolUpdateRequest) {
		IdolEntity idol = findById(idolUpdateRequest.getId());
		idol.setName(idolUpdateRequest.getName());
		idol.setGroup_name(idolUpdateRequest.getGroup_name());
		idol.setBirth_day(idolUpdateRequest.getBirth_day());
		idol.setBirth_place(idolUpdateRequest.getBirth_place());
		idolRepository.save(idol);
	}
 
	/**
	 * アイドル情報　物理削除
	 * @param id ID
	 */
	public void delete(Integer id) {
		IdolEntity idol = findById(id);
		idolRepository.delete(idol);
	}
}
