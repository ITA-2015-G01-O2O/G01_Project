package com.group.tto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TTO_LOCATION")
public class Location {

  @Id
  @Column(name = "LOCATION_ID")
  @SequenceGenerator(name = "LOCATION_ID_SEQ", sequenceName = "SEQ_TTO_LOCA_ID")
  @GeneratedValue(generator = "LOCATION_ID_SEQ", strategy = GenerationType.SEQUENCE)
  private Long locationId;
  @Column(name = "AREA")
  private String area;
  @Column(name = "CITY")
  private String city;
  @Column(name = "PLACE")
  private String place;

  public Long getLocationId() {
    return locationId;
  }

  public void setLocationId(Long locationId) {
    this.locationId = locationId;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

}
