package com.example.mongotest.auth.role;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("roles")
public class Role {

    private String id;
    private String name;
    private String[] permissions;

    public Role(String name, String[] permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getPermissions() {
        return permissions;
    }
}
