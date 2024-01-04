package com.spring.hospitalPortal;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class Controller {

//    @GetMapping()
//    public Map<String, Object> patientHomePage(OAuth2AuthenticationToken oAuth2AuthenticationToken){
//    return oAuth2AuthenticationToken.getPrincipal().getAttributes();
//    }

//    @GetMapping()
//    public Object patientHomePage(OAuth2AuthenticationToken oAuth2AuthenticationToken){
//        Map<String, Object> attributes = oAuth2AuthenticationToken.getPrincipal().getAttributes();
//        UserDetails userDetails= new UserDetails(attributes);
//
//        // Display user details
//        return userDetails;
//    }

    @GetMapping()
    public Object patientHomePage(OAuth2AuthenticationToken oAuth2AuthenticationToken){
        //Map<String, Object> attributes = oAuth2AuthenticationToken.getPrincipal().getAttributes();
        //UserDetails userDetails= new UserDetails(attributes);

        // Display user details
        return oAuth2AuthenticationToken;
    }

//    @GetMapping("/github/login")
//    public String patientHomePage_github(OAuth2AuthenticationToken oAuth2AuthenticationToken){
//        Map<String, Object> attributes = oAuth2AuthenticationToken.getPrincipal().getAttributes();
//        String email = attributes.get("email").toString();
//        String name = attributes.get("name").toString();
//        String picture = attributes.get("picture").toString();
//
//        // Display user details
//        return "Welcome, " + name + "<br>Email: " + email + "<br>Picture: " + picture;
//    }

    @GetMapping("/google/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "You have been logged out";
    }

    @GetMapping("test")
    public String test(){
        return ("Test");
    }

}
