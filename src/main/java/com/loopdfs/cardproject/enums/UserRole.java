package com.loopdfs.cardproject.enums;

public enum UserRole {
    NORMAL ("normal"),
    ADMIN ("admin");

    private final String role;

    private UserRole(String role) {
        this.role = role;
    }

    public static UserRole convert(String status) {

        if (status.equals("newbie")) {
            return UserRole.NORMAL;
        } else if (status.equals("admin")) {
            return UserRole.ADMIN;
        }else {
            return null;
        }
    }

    @Override
    public String toString() {
        return role;
    }
}
