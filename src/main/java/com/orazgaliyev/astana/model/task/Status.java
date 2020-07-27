package com.orazgaliyev.astana.model.task;

import com.orazgaliyev.astana.model.user.Role;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

//•	Статус (в процессе, завершено и просрочено)

@RequiredArgsConstructor
public enum Status {
    IN_PROGRESS(0),
    RESOLVED(1),
    EXPIRED(2);


    private static final Status[] statuses = values();
    private final int statusId;

    @Nullable
    public static Status byId(int roleId) {
        for (Status status : statuses) {
            if (status.statusId == roleId) {
                return status;
            }
        }
        return null;
    }

    @NonNull
    public static Integer byStatus(Status status) {
        return status.statusId;
    }

}