package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	
	// 顧客一覧表示
	@GetMapping("/users")
	public String index(
			Model model) {

		// 顧客一覧情報の取得
		List<User> userList = userRepository.findAll();

		model.addAttribute("users", userList);

		return "users";
	}

	@GetMapping("/users/add")
	public String create() {
		return "addUser";
	}

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
	
	// 更新画面表示
		@GetMapping("/users/{id}/edit")
		public String edit(@PathVariable("id") Integer id, Model model) {

			// itemsテーブルをID（主キー）で検索
			User user = userRepository.findById(id).get();

			model.addAttribute("user", user);

			return "editUser";
		}

		// 更新処理
		@PostMapping("/users/{id}/edit")
		public String update(
				@PathVariable("id") Integer id,
				@RequestParam(value = "email", defaultValue = "") String email,
				@RequestParam(value = "name", defaultValue = "") String name,
				@RequestParam(value = "password", defaultValue = "") String password,
				Model model) {

			// Userオブジェクトの生成
			User user = new User(id, name, email, password);
			
			// itemsテーブルへの反映（UPDATE）
			userRepository.save(user);
			
			// 「/items」にGETでリクエストし直せ（リダイレクト）
			return "redirect:/users";
		}
		// 削除処理
		@PostMapping("/users/{id}/delete")
		public String delete(@PathVariable("id") Integer id, Model model) {

			// itemsテーブルから削除（DELETE）
			userRepository.deleteById(id);
			
			// 「/items」にGETでリクエストし直せ（リダイレクト）
			return "redirect:/users";
		}
}
