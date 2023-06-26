package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	// 新規登録処理
	@PostMapping("/users/add")
	public String store(
			@RequestParam(value = "id", defaultValue = "") Integer id,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "password", defaultValue = "") String password,
			Model model) {
		
		// Userオブジェクトの生成
		User user = new User(id, name, email, password);
		
		// userテーブルへの反映（INSERT）
		userRepository.save(user);
		
		// 「/users」にGETでリクエストし直せ（リダイレクト）
		return "redirect:/users";
	}
	
	
}
