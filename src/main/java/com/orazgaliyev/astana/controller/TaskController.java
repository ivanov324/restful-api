package com.orazgaliyev.astana.controller;

import com.orazgaliyev.astana.model.task.TaskDTO;
import com.orazgaliyev.astana.model.user.UserDTO;
import com.orazgaliyev.astana.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;

//  Список API и функционал:
//•	Создание, редактирование, поиск, выдача списка и удаление выше описанных объектов
//•	Аутентификация принимать логин и пароль возвращать токен
//•	Профиль пользователя
//•	Смена статуса задачи
//•	Смена пароля пользователя (забыли пароль) проверять по email отправлять на почту 4 значный код
//•	Проверка кода и смена пароля (новый пароль также вернуть пользователю на почту)
//  Все API, работающие с объектами не должны быть доступны, если токен неверный или он не существует
//  кроме создание нового пользователя.


    @GetMapping("/tasks")
    public String allTasks() {
        taskService.getAll();
        return "taskList";
    }

    @GetMapping("/tasks/id")
    public String getTask(String login) {
        taskService.getTaskByLogin(login);
        return "task";
    }

    @PostMapping("/tasks/id")
    public String createTask(TaskDTO taskDTO) {
        taskService.createTask(taskDTO);
        return "taskCreated";
    }

    @DeleteMapping("/tasks/id")
    public String deleteTask(String taskName) {
        taskService.deleteTask(taskName);
        return "taskDeleted";
    }


}
