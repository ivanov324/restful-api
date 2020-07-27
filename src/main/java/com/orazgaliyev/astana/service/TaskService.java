package com.orazgaliyev.astana.service;

import com.orazgaliyev.astana.model.task.TaskDTO;
import com.orazgaliyev.astana.model.user.UserDTO;

import java.util.List;

public interface TaskService {

    public List<TaskDTO> getAll();

    public TaskDTO getTaskByLogin(String login);

    public void createTask(TaskDTO taskDTO);

    public void deleteTask(String login);

}