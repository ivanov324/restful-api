package com.orazgaliyev.astana.repo;

import com.orazgaliyev.astana.entity.task.TaskEntity;
import com.orazgaliyev.astana.model.task.TaskDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    Optional<TaskEntity> findByLogin(String userName);

    Optional<TaskEntity> deleteByLogin(String userName);
}
