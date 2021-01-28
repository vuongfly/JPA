package vn.techmaster.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.User;

public interface iPostService {
  Post findPostById(Long id);

  List<Post> getAllPostOfUser(User user);

  void addPost(User user, Post post);

  void removePost(Post post);

  void updatePost(Long postId, Post newPost);

  void addComment(Post post, Comment comment);
}
