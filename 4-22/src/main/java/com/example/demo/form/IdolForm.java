package com.example.demo.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * アイドル情報 リクエストデータ
 */
@Data
public class IdolForm {
	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 名前
	 */
	@NotEmpty(message="アイドルの名前を入力してください")
	@Size(max = 10,message = "アイドルの名前は10文字以内で入力してください")
	private String name;
	/**
	 * 所属グループ
	 */
	@NotEmpty(message = "グループ名を入力してください")
	@Size(max = 20,message = "グループ名は20文字以内で入力してください")
	private String group_name;
	/**
	 * 生年月日
	 */
	@NotNull(message = "アイドルの生年月日を入力してください")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birth_day;
	/**
	 * 出身
	 */
	@NotEmpty(message = "アイドルの出身を入力してください")
	@Size(max = 10,message = "アイドルの出身は10文字以内で入力してください")
	private String birth_place;

}
