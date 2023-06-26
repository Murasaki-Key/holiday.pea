package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Data
@Component
@SessionScope
public class Account {
	//フィールド
	private String name;
	
	//コンストラクタ
	public Account() {
		
	}

	public Account(String name) {
		this.name = name;
	}
}
