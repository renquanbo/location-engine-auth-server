package com.breadcrumbdata.auth_server.exception;

public class UsernameNotMatchException extends RuntimeException{
    private static final long serialVersionUID = 2444801375656772349L;

    private String username;

    private String queryUsername;

    public UsernameNotMatchException(String username, String queryUsername) {
        super("Username not match");
        this.username = username;
        this.queryUsername = queryUsername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQueryUsername() {
        return queryUsername;
    }

    public void setQueryUsername(String queryUsername) {
        this.queryUsername = queryUsername;
    }

}
