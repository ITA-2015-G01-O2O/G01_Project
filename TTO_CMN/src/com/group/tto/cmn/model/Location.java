package com.group.tto.cmn.model;

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((area == null) ? 0 : area.hashCode());
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
    result = prime * result + ((place == null) ? 0 : place.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Location other = (Location) obj;
    if (area == null) {
      if (other.area != null) return false;
    } else if (!area.equals(other.area)) return false;
    if (city == null) {
      if (other.city != null) return false;
    } else if (!city.equals(other.city)) return false;
    if (locationId == null) {
      if (other.locationId != null) return false;
    } else if (!locationId.equals(other.locationId)) return false;
    if (place == null) {
      if (other.place != null) return false;
    } else if (!place.equals(other.place)) return false;
    return true;
  }

}
