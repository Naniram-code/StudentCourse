package com.scm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="COURSE")
public class Course {
    @Id
    @Column(name = "CID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer cid;
    @NotEmpty
    @Size(min = 2,message = "Course name should have  at least 2 Characters")
    @Column(name = "CNAME")
    private String cname;

    @NotEmpty
    @Size(min = 2,message = "Course duration should have  at least 2 Characters")
    @Column(name="CDURATION")
    private String cduration;
    @NotEmpty
    @Size(min = 2,message = "Last name should have  at least 2 number")
    @Column(name="CFEE")
    private Double cfee;
    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Student> student;

}
