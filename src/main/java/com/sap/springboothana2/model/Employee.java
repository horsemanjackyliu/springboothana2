package com.sap.springboothana2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")

public class Employee {
    @Id
    @Column(name = "id",unique = true)
    private long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "secondName")
    private String secondName;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "contact",unique = true)
    private String contact;

}
