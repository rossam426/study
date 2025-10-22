package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.IdolEntity;
import com.example.demo.form.IdolForm;
import com.example.demo.service.IdolService;

/**
 * アイドル情報 Controller
 */
@Controller
public class IdolController{

	/**
	 * アイドル情報 Service
	 */
	// 使用クラスのインスタンス化
	@Autowired
	IdolService idolService;

	/**
	 * 好きなアイドル一覧画面
	 * 
	 * @param model Model
	 * @return 好きなアイドル一覧画面のHTML
	 */
	@GetMapping("/idol/list")
	public String idolList(Model model) {
		// アイドルテーブルのデータを全て取得するメソッドを呼び出す
		List<IdolEntity> idollist = idolService.searchAll();
		// 取得したアイドルデータの情報を画面側で利用できるようにmodelに格納
		model.addAttribute("idollist", idollist);
		return "idol/list";
	}

	/**
	 * 好きなアイドル登録画面を表示
	 * 
	 * @param model Model
	 * @return アイドル一覧画面
	 */

	@GetMapping("/idol/add")
	public String idolRegister(Model model) {
		model.addAttribute("idolRequest", new IdolForm());
		return "idol/add";
	}

	/**
	 * アイドル新規登録
	 * 
	 * @param idolRequest リクエストデータ
	 * @param model       Model
	 * @return アイドル一覧画面
	 */
	@PostMapping("/idol/create")
	public String idolCreate(@Validated IdolForm idolRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 入力エラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("idolRequest", new IdolForm());
			model.addAttribute("validationError", errorList);
			return "idol/add";
		}
		// アイドル情報の登録
		idolService.create(idolRequest);
		return "redirect:/idol/list";
	}

	/**
	 * アイドル情報詳細画面を表示
	 * 
	 * @param id    表示するアイドルのID
	 * @param model MOdel
	 * @return アイドル情報詳細画面
	 */

	@GetMapping("/idol/{id}")
	public String idolDetail(@PathVariable Integer id, Model model) {
		IdolEntity idol = idolService.findById(id);
		model.addAttribute("idol", idol);
		return "idol/detail";
	}

	/**
	 * アイドル編集画面を表示
	 * 
	 * @param id    表示するアイドルのID
	 * @param model Model
	 * @return アイドル編集画面
	 */
	@GetMapping("/idol/{id}/edit")
	public String idolEdit(@PathVariable Integer id, Model model) {
		IdolEntity idol = idolService.findById(id);
		IdolForm idolUpdateRequest = new IdolForm();
		idolUpdateRequest.setId(idol.getId());
		idolUpdateRequest.setName(idol.getName());
		idolUpdateRequest.setGroup_name(idol.getGroup_name());
		idolUpdateRequest.setBirth_day(idol.getBirth_day());
		idolUpdateRequest.setBirth_place(idol.getBirth_place());
		model.addAttribute("idolUpdateRequest", idolUpdateRequest);
		return "idol/edit";
	}

/**
 * アイドル情報更新
 * @param idolRequest リクエストデータ
 * @param model Model
 * @return アイドル情報詳細画面
 */
@PostMapping("/idol/update")
 public String idolUpdate(@Validated @ModelAttribute IdolForm idolUpdateRequest,BindingResult result, Model model) {
	if (result.hasErrors()) {
		List<String> errorList = new ArrayList<String>();
		for(ObjectError error : result.getAllErrors()) {
			errorList.add(error.getDefaultMessage());
		}
		model.addAttribute("ValidationError",errorList);
		return "idol/edit";
	}
	//アイドル情報の更新
	idolService.update(idolUpdateRequest);
	return String.format("redirect:/idol/%d",idolUpdateRequest.getId());
	
 }

/**
 * アイドル情報削除
 * @param id 表示するID
 * @param model Model
 * @return アイドル情報詳細画面
 */
@GetMapping("/idol/{id}/delete")
 public String idolDelete(@PathVariable Integer id,Model model) {
	//アイドル情報の削除
	idolService.delete(id);
	return "redirect:/idol/list";
}
}
