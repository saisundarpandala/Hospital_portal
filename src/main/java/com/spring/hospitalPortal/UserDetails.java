package com.spring.hospitalPortal;

import java.util.Map;

public class UserDetails {

    private String email;
    private String name;
    private String picture;

    public UserDetails(Map<String, Object> attributes) {
        if (attributes.containsKey("email")) {
            this.email = (String) attributes.get("email");
        } else {
            this.email = "";
        }

        if (attributes.containsKey("login")) {
            this.name = (String) attributes.get("login");
        } else {
            this.name = (String) attributes.get("name");
        }

        if (attributes.containsKey("picture")) {
            this.picture = (String) attributes.get("picture");
        } else {
            this.picture = "";
        }
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }
}
