package com.orazgaliyev.astana.model.user;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    USER(0), ADMIN(1);

    private static final Role[] roles = values();
    private final int roleId;

    @Nullable
    public static Role byId(int roleId) {
        for (Role role : roles) {
            if (role.roleId == roleId) {
                return role;
            }
        }
        return null;
    }

    @NonNull
    public static Integer byRole(Role role) {
        return role.roleId;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
