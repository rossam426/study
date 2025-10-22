package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * アイドル情報　Entity
 */
@Data
@Entity
@Table(name="idol")
public class IdolEntity {
	
/**
 * ID
 */
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private Integer id;

/**
 * 名前
 */
@Column(name = "name")
private String name;

/**
 * 所属グループ
 */
@Column(name = "group_name")
private String group_name;

/**
 * 生年月日
 */
@Column(name = "birth_day")
private LocalDate birth_day;

/**
 * 出身
 */
@Column(name = "birth_place")
private String birth_place;
}
