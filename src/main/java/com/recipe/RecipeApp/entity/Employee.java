package com.recipe.RecipeApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String secondName;

    private String patronymic;

    private String login;

    private String password;

    private String mobilePhone;

    private String email;

//    @ManyToOne(optional=false, cascade=CascadeType.ALL)
//    @JoinColumn(name="job_id")
//    @JsonIgnore
//    private Job job;
//    @Column(insertable = false, updatable = false)
//    private Long job_id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "job_id", referencedColumnName = "id", nullable = false)
    private Job job;
}