package com.orazgaliyev.astana.model.task;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TaskDTO {

//•	Наименование
//•	Описание
//•	Дата и время начала
//•	Дата и время конца
//•	Статус (в процессе, завершено и просрочено)
//•	Файлы
//•	Связка с пользователем
//•	Дата создание
//• Дата обновление

    private String taskName;
    private String description;
    private Date taskStartTime;
    private Date taskEndTime;
    private Status status;
    private Byte[] file;
    private String personName;
    private Date createDate;
    private Date updateDate;

}
