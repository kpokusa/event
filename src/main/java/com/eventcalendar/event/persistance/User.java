package com.eventcalendar.event.persistance;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long id;
    @NotBlank(message = "email is mandataory")
    private String email;
    private String password;
    private String city;
    @Column(name = "first_name")
    @NotBlank(message = "name is mandatory")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    private String role;



    @OneToMany
    private List<Event> eventList;

    public User() {
    }

//    public User(String email, String password, String city, String firstName, String lastName) {
//        this.email = email;
//        this.password = password;
//        this.city = city;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }



    public User(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.email=user.getEmail();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", city='" + city + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                '}';
//    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nfirstName: %s, ", firstName));
        sb.append(String.format("lastName: %s, ", lastName));
        sb.append(String.format("email: %s, ", email));
        sb.append(String.format("role: %s \n", role));

        return sb.toString();
    }
}