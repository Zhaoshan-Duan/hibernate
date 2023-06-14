package org.example;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollment_id;

    private String firstName;
    private String lastName;
    private int marks;

    @Lob
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToMany(mappedBy = "student")
    private Set<Address> addressSet = new HashSet<>();

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Student(String firstName, String lastName, int marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = marks;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String generateUsername() {
        String username = "";
        username += firstName.charAt(0) + lastName.charAt(0) + enrollment_id;
        return username;
    }

    @Override
    public String toString() {
        return "Student{" +
                "enrollment_id=" + enrollment_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", marks=" + marks +
                ", description='" + description + '\'' +
                '}';
    }
}
