package com.pingcap.example.domain;

import java.util.Date;

public class Book {
  private Long id;
  private String title;
  private String type;
  private Date publishedAt;
  private Double price;
  private Float averageScore;

  public Book() {
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", type='" + type + '\'' +
        ", publishedAt=" + publishedAt +
        ", price=" + price +
        ", averageScore=" + averageScore +
        '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Date getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(Date publishedAt) {
    this.publishedAt = publishedAt;
  }

  public Float getAverageScore() {
    return averageScore;
  }

  public void setAverageScore(Float averageScore) {
    this.averageScore = averageScore;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

}
