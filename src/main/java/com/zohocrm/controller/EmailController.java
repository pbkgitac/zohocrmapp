package com.zohocrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.utils.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value="/composeEmail" , method = RequestMethod.POST)
	public String composeEmail(@RequestParam("email") String email , Model model) {
    model.addAttribute("email",email);
		return "compose_email";
		
		
	}
	@RequestMapping("/sendEmail")
	public String sendEmail(@RequestParam("to") String to ,@RequestParam("sub") String sub,Model model ) {
		model.addAttribute("msg","Email sent");
		return "compose_email" ;
	}

}
