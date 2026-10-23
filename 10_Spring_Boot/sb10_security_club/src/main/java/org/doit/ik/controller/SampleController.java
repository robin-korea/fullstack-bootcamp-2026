package org.doit.ik.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping( value = { "/all" })
	public void exAll() {
		log.info("😘😘 SampleController.exAll()...");
	}
	
	@GetMapping( value = { "/member" })
	public void exMember() {
		log.info("😘😘 SampleController.exMember()...");
	}
	
	@GetMapping( value = { "/admin" })
	public void exAdmin() {
		log.info("😘😘 SampleController.exAdmin()...");
	}
	
}
