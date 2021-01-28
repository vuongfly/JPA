package vn.techmaster.blog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findPostById(Long id);


}
