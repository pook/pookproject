package biz.evolix.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorizationController {
	@RequestMapping(method = RequestMethod.GET, value = "/login.do")
	public void login() {
	}
}
