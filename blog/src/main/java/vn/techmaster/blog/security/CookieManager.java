package vn.techmaster.blog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import org.springframework.stereotype.Component;

import vn.techmaster.blog.model.Post;

@Component
public class CookieManager {
  private final String LOGIN_COOKIE = "loginsuccess";
  private final String POST_COOKIE = "postId";

  public String getAuthenticatedEmail(HttpServletRequest request) {
    // return email saved in cookie
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (var cookie : cookies) {
        if (cookie.getName().equals(LOGIN_COOKIE)) {
          return cookie.getValue();
        }
      }
    }
    return null;
  }

  public void setAuthenticated(HttpServletResponse response, String email) {
    Cookie loginCookie = new Cookie(LOGIN_COOKIE, email);
    loginCookie.setMaxAge(30 * 60);
    loginCookie.setPath("/");
    response.addCookie(loginCookie);
  }

  public void setNotAuthenticated(HttpServletResponse response) {
    Cookie loginCookie = new Cookie(LOGIN_COOKIE, null);
    loginCookie.setMaxAge(0);
    loginCookie.setHttpOnly(true);
    loginCookie.setPath("/");
    // add cookie to response
    response.addCookie(loginCookie);
  }

  public void selectedPost(HttpServletResponse response, Post post) {
    Cookie postCookie = new Cookie(POST_COOKIE, String.valueOf(post.getId()));
    postCookie.setMaxAge(30 * 60);
    postCookie.setPath("/");
    response.addCookie(postCookie);
  }

  public String getSelectedPostId(HttpServletRequest request) {
    // return email saved in cookie
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (var cookie : cookies) {
        System.out.println(cookie.getName() + "=" + cookie.getValue());
        if (cookie.getName().equals(POST_COOKIE)) {
          return cookie.getValue();
        }
      }
    }
    return null;
  }

}
