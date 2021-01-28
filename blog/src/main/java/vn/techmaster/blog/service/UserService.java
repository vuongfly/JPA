package vn.techmaster.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.User;
import vn.techmaster.blog.repository.UserRepository;

@Service
public class UserService implements iUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addComment(User user, Comment comment) {
        user.addComment(comment);
        userRepository.save(user);
        userRepository.flush();
    }

    @Override
    public User findByEmail(String loginEmail) {
        return userRepository.findByEmail(loginEmail).get();
    }

}
