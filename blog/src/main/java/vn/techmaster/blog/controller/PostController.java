package vn.techmaster.blog.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.User;
import vn.techmaster.blog.repository.PostRepository;
import vn.techmaster.blog.repository.UserRepository;
import vn.techmaster.blog.security.CookieManager;
import vn.techmaster.blog.service.PostService;

@Controller
public class PostController {

  @Autowired
  private CookieManager cookieManager;

  @Autowired
  private UserRepository userRepository;
  

  @Autowired
  PostService postService;

  @GetMapping("/posts")
  public String getAllPosts(HttpServletRequest request, Model model) {
    String loginEmail = cookieManager.getAuthenticatedEmail(request);
    model.addAttribute("email", loginEmail);
    if (loginEmail != null) {
      User user = userRepository.findByEmail(loginEmail).get();
      model.addAttribute("posts", user.getPosts());
      return Route.ALLPOSTS;
    } else {
      return Route.REDIRECT_HOME;
    }
    // return "posts";
  }

  @GetMapping("/posts/add")
  public String getCreatePostsForm(HttpServletRequest request, Model model) {
    String loginEmail = cookieManager.getAuthenticatedEmail(request);
    if (loginEmail != null) {
      User user = userRepository.findByEmail(loginEmail).get();
      model.addAttribute("post", new Post());
      return Route.CREATE_POSTS_FORM;
    } else {
      return Route.REDIRECT_HOME;
    }
  }

  @PostMapping("/posts/add")
  public String getCreatePosts(@ModelAttribute Post post, HttpServletRequest request, Model model) {
    String loginEmail = cookieManager.getAuthenticatedEmail(request);
    if (loginEmail != null) {
      User user = userRepository.findByEmail(loginEmail).get();
      postService.addPost(user, post);
      model.addAttribute("posts", user.getPosts());
      return Route.REDIRECT_POSTS;
    } else {
      return Route.REDIRECT_HOME;
    }
  }

  @GetMapping(value = "/post/{id}")
  public String getAPost(@PathVariable("id") long id, Model model, HttpServletResponse response) {
    Post post = postService.findPostById(id);
    cookieManager.selectedPost(response, post);
    model.addAttribute("post", post);
    return "post";
  }

}
