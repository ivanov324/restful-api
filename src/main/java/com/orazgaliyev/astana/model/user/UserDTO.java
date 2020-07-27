package com.orazgaliyev.astana.model.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDTO {

    //•	Имя
//•	Фамилия
//•	Email
//•	Телефон
//•	Роль (супер админ и пользователь )
//•	Логин
//•	Пароль (hash)
//•	Фото
//•	Дата создание
//•	Дата обновление

    private String name;
    private String lastName;
    private String email;
    private int phoneNumber;
    private Role role;
    private String login;
    private Byte[] photo;
    private Date createDate;
    private Date updateDate;
}
