package com.orazgaliyev.astana.service;

import com.orazgaliyev.astana.entity.task.TaskEntity;
import com.orazgaliyev.astana.model.task.Status;
import com.orazgaliyev.astana.model.task.TaskDTO;
import com.orazgaliyev.astana.repo.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<TaskDTO> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTaskByLogin(String login) {
        return taskRepository.findByLogin(login)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public void createTask(TaskDTO taskDTO) {
        taskRepository.save(mapToEntity(taskDTO));
    }

    @Override
    public void deleteTask(String login) {
        taskRepository.deleteByLogin(login)
                .map(this::mapToDTO);
    }

    private TaskEntity mapToEntity(TaskDTO taskDTO) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskName(taskDTO.getTaskName());
        taskEntity.setDescription(taskDTO.getDescription());
        taskEntity.setStatus(Status.byStatus(taskDTO.getStatus()));
        taskEntity.setTaskStartTime(taskDTO.getTaskStartTime());
        taskEntity.setTaskEndTime(taskDTO.getTaskEndTime());
        taskEntity.setFile(taskDTO.getFile());
        taskEntity.setPersonName(taskDTO.getPersonName());
        taskEntity.setCreateDate(taskDTO.getCreateDate());
        taskEntity.setUpdateDate(taskDTO.getUpdateDate());
        return taskEntity;
    }

    private TaskDTO mapToDTO(TaskEntity entity) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskName(entity.getTaskName());
        taskDTO.setDescription(entity.getDescription());
        taskDTO.setStatus(Status.byId(entity.getStatus()));
        taskDTO.setTaskStartTime(entity.getTaskStartTime());
        taskDTO.setTaskEndTime(entity.getTaskEndTime());
        taskDTO.setFile(entity.getFile());
        taskDTO.setPersonName(entity.getPersonName());
        taskDTO.setCreateDate(entity.getCreateDate());
        taskDTO.setUpdateDate(entity.getUpdateDate());
        return taskDTO;
    }
}
