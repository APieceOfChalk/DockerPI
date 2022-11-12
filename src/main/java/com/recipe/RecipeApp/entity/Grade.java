package com.recipe.RecipeApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @OneToMany (mappedBy="grade", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Job> jobList;

    @OneToMany(mappedBy = "grade", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    @JsonIgnore
    private List<Job> jobList;
}
