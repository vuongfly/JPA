package vn.techmaster.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.User;
import vn.techmaster.blog.repository.PostRepository;
import vn.techmaster.blog.repository.UserRepository;
import vn.techmaster.blog.security.CookieManager;

@Service
public class PostService implements iPostService {

  @Autowired
  UserRepository userRepository;
  @Autowired
  PostRepository postRepository;
  @Autowired
  CookieManager cm;

  @Override
  public void addPost(User user, Post post) {
    user.addPost(post);
    userRepository.save(user);
    userRepository.flush();
  }

  @Override
  public void removePost(Post post) {
    // user.getPosts().remove(post);
  }

  @Override
  public void updatePost(Long postId, Post newPost) {
    // TODO cannot convert long to int => cannot get post by postId

  }

  @Override
  public Post findPostById(Long id) {
    return postRepository.findPostById(id).get();
  }

  @Override
  public List<Post> getAllPostOfUser(User user) {
    return user.getPosts();
  }

  @Override
  public void addComment(Post post, Comment comment) {
    post.addComment(comment);
    postRepository.save(post);
    postRepository.flush();
  }

}
