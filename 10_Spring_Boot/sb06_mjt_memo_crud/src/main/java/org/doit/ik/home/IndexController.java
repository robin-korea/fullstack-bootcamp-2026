package org.doit.ik.home;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Log4j2
public class IndexController {
	
	@GetMapping( value = { "/" , "/index"})
	public String index() {
		return "index";
	}
	
}
