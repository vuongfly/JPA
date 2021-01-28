package vn.techmaster.blog.service;

import java.util.Optional;

import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.User;

public interface iUserService {
    public void addComment(User user, Comment comment);
    User findByEmail(String loginEmail);
}
