package com.soebes.medium.stream.question;

import java.util.List;

public class Employee {

  private String id;
  private String firstName;
  private String lastName;
  private int salary;
  private int totalLaptopsAssigned;
  // OneToMany
  private List<Project> projects;

  Employee(){
  }

  public Employee(String id, String firstName, String lastName, int salary, int totalLaptopsAssigned,
                  List<Project> projects) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.salary = salary;
    this.totalLaptopsAssigned = totalLaptopsAssigned;
    this.projects = projects;
  }

  @Override
  public String toString() {
    return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", projects="
           + projects + "]";
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
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
  public int getSalary() {
    return salary;
  }
  public void setSalary(int salary) {
    this.salary = salary;
  }
  public List<Project> getProjects() {
    return projects;
  }
  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }
  public int getTotalLaptopsAssigned() {
    return totalLaptopsAssigned;
  }
  public void setTotalLaptopsAssigned(int totalLaptopsAssigned) {
    this.totalLaptopsAssigned = totalLaptopsAssigned;
  }
}
