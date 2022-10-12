package tech.getarrays.employeemanager.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity // Identifier cette classe comme Entity;
@Data // Générer les Getters and Setters et Constructeur;
public class Employee implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // PrimaryKey and Auto-Incrimetation;
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;

    @Column(nullable = false, updatable = false)
    private String employeeCode;

    @Override
    public String toString(){
        return "Employee{" +
                "id=" + id +
                ", name=' " + name +'\'' +
                ", email' " + email +'\'' +
                ", jobTitle' " + jobTitle +'\'' +
                ", phone' " + phone +'\'' +
                ", imageUrl' " + imageUrl +'\'' +
                '}';
    }

}
