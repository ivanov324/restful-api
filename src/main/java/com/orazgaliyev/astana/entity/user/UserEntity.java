package com.orazgaliyev.astana.entity.user;

import com.orazgaliyev.astana.entity.task.TaskEntity;
import com.orazgaliyev.astana.model.user.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<TaskEntity> tasks;

    @Column(name = "last_name")
    private String lastName;
    private String email;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(nullable = false)
    private Integer role;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;
    private Byte[] photo;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;
}
