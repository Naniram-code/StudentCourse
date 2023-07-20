package com.scm.model;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STUDENT")
public class Student {
@Id
@Column(name = "SID")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer sid;
@NotEmpty
@Size(min = 2,message = "first name should have  at least 2 Characters")
@JsonProperty("sname")
@Column(name = "SNAME")
private String sname;
@NotEmpty
@JsonProperty("sadd")
@Size(min = 2,message = "Address should have  at least 2 Characters")
@Column(name = "SADD")
private String sadd;
@Email
@NotEmpty
@Size(min = 2,message = "Email should have  at least 2 Characters")
@JsonProperty("email")
@Column(name = "EMAIL")
private String email;
@ManyToOne
@JoinColumn(name="course_ID")
private Course course;

}

