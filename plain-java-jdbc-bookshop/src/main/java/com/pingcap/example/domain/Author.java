package com.pingcap.example.domain;

public class Author {
  private Long id;
  private String name;
  private String gender;
  private Short age;
  private Short birthYear;
  private Short deathYear;
  private Integer books;

  public Author() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Short getAge() {
    return age;
  }

  public void setAge(Short age) {
    this.age = age;
  }

  public Short getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(Short birthYear) {
    this.birthYear = birthYear;
  }

  public Short getDeathYear() {
    return deathYear;
  }

  public void setDeathYear(Short deathYear) {
    this.deathYear = deathYear;
  }

  public Integer getBooks() {
    return books;
  }

  public void setBooks(Integer books) {
    this.books = books;
  }
}
