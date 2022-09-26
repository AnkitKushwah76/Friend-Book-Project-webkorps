package com.webkorps.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.webkorps.serviceImpl.CaptchaServicImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("captcha")
public class CaptchaController {

	@Autowired
	private CaptchaServicImpl captchaServicImpl;

	@RequestMapping(method = RequestMethod.GET)
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		HttpSession session = request.getSession();
		session.setAttribute("captcha_security", captchaServicImpl.chapcha(response));
	}

}