package com.ziumlight.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ziumlight.dao.UserDAO;
import com.ziumlight.helper.RestPreconditions;
import com.ziumlight.to.UserTO;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	private UserDAO userDAO;
	
	@Autowired
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<UserTO> allUser() {
		List<UserTO> userTOList = userDAO.findAll();
		return RestPreconditions.checkFound(userTOList);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public UserTO getUser(@PathVariable("id") Integer id) {
		List<UserTO> userTO = userDAO.findAll();
		UserTO userObj = userTO.get(0);
		Link selfLink = ControllerLinkBuilder.linkTo(UserController.class).slash(userObj.getUserId()).withSelfRel();
		userObj.add(selfLink);
		return userObj;
	}

}
