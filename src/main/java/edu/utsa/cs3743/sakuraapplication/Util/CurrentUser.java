package edu.utsa.cs3743.sakuraapplication.Util;

public class CurrentUser {
    private static int userId;
    private static String username;
    private static String email;

    private CurrentUser() {
    }

    public static void setUser(int id, String uname, String mail) {
        userId = id;
        username = uname;
        email = mail;
    }

    public static int getUserId() {
        return userId;
    }

    public static String getUsername() {
        return username;
    }

    public static String getEmail() {
        return email;
    }

    public static boolean isLoggedIn() {
        return userId > 0;
    }

    public static void logout() {
        userId = 0;
        username = null;
        email = null;
    }
}

