package vn.techmaster.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.User;
import vn.techmaster.blog.repository.UserRepository;
import vn.techmaster.blog.security.CookieManager;
import vn.techmaster.blog.service.PostService;
import vn.techmaster.blog.service.UserService;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CookieManager cm;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addComment(@RequestParam("comment") String comment, Model model, HttpServletRequest request) {
        String loginEmail = cm.getAuthenticatedEmail(request);
        User user = userService.findByEmail(loginEmail);
        Long postId = Long.parseLong(cm.getSelectedPostId(request));
        Post post = postService.findPostById(postId);
        Comment cmt = new Comment(comment);
        postService.addComment(post, cmt);
        userService.addComment(user, cmt);
        return Route.REDIRECT_POSTS;
    }

}
