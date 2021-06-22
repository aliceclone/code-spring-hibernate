package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.demo.dto.UserForm;
import com.spring.demo.entity.User;
import com.spring.demo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    // ❗ /users GET -> list
    // /users POST -> save OR update
    // /users/update/{id} -> update form

    @Autowired
    private UserService userService;

    @ModelAttribute(name = "userForm")
    public UserForm setUp() {
	return new UserForm();
    }

    @GetMapping
    public String list(Model model) {
	// fetch users
	List<User> users = userService.getUsers();
	// add to model
	model.addAttribute("users", users);
	// view
	return "user-list";
    }

    @PostMapping
    public String saveOrUpdate(@ModelAttribute("userForm") UserForm userForm) {
	// bean mapping
	User user = mapUserFormToUser(userForm);
	userService.saveOrUpdate(user);
	// ❗PRG flow implemented
	return "redirect:/users";
    }

    @GetMapping("/add")
    public String formAdd() {
	// @ModelAttribute Customer no need to bind
	return "user-form";
    }

    @GetMapping(path = "/{id}/update")
    public String formUpdate(@PathVariable("id") Long id, Model model) {
	// @RequestParam("customerId") can also use with c:url
	User user = userService.findbyUserId(id);
	UserForm userForm = mapUserToUserForm(user);
	// TODO: user.getRoles();
	model.addAttribute("userForm", userForm);
	return "user-form";
    }

    @GetMapping(path = "/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
	userService.deleteUser(id);
	// ❗PRG flow implemented
	return "redirect:/users";
    }

    private User mapUserFormToUser(UserForm userForm) {
	User user = new User();
	user.setId(userForm.getId());
	user.setUserName(userForm.getUserName());
	user.setFirstName(userForm.getFirstName());
	user.setLastName(userForm.getLastName());
	user.setEmail(userForm.getEmail());
	// skip encoding here
	user.setPassword(userForm.getPassword());
	// skip set up EMPLOYEE as default
	// user.setRoles(null);
	return user;
    }

    private UserForm mapUserToUserForm(User user) {
	UserForm userForm = new UserForm();
	userForm.setId(user.getId());
	userForm.setUserName(user.getUserName());
	userForm.setFirstName(user.getFirstName());
	userForm.setLastName(user.getLastName());
	userForm.setEmail(user.getEmail());
	userForm.setPassword(user.getPassword());
	// TODO: roles
	return userForm;
    }
}
