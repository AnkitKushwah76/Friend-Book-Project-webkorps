package com.webkorps.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import com.webkorps.serviceImpl.DeletePostImp;
@Controller
public class DeletePostController {
	@Autowired
	private DeletePostImp deletePostImp;
	@PostMapping("/deletePost")
	public RedirectView deletePost(@RequestParam("postId") int postId) {
		RedirectView redirectView = new RedirectView();
		this.deletePostImp.userDeletePost(postId);
		redirectView.setUrl("showUserProfile");
		return redirectView;

	}
}
