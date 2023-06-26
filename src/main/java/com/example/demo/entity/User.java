package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "Users") // 対応するテーブル名
public class User {

	// フィールド
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Integer id; // 顧客ID

	@Getter
	private String name; // 顧客名
	
	@Getter
	private String email; // メール
	
	@Getter
	private String password; //パスワード

	// コンストラクタ
	public User() {
		
	}

	public User(Integer id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
