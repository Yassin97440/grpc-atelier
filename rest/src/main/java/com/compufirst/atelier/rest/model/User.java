package com.compufirst.atelier.rest.model;

public class User {
  private String FirstName;
  private String LastName;
  private String email;
  private int age;

  
  public String getFirstName() {
    return FirstName;
  }
  public void setFirstName(String firstName) {
    FirstName = firstName;
  }
  public String getLastName() {
    return LastName;
  }
  public void setLastName(String lastName) {
    LastName = lastName;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  
}
