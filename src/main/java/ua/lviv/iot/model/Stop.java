package ua.lviv.iot.model;

public class Stop {

  private Integer id;
  private String district;
  private String streetName;
  private String streetNumber;

  public Stop(Integer id, String district, String streetName, String streetNumber) {
    this.id = id;
    this.district = district;
    this.streetName = streetName;
    this.streetNumber = streetNumber;
  }

  public Stop(String district, String streetName, String streetNumber) {
    this(null, district, streetName, streetNumber);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  @Override
  public String toString() {
    return "\nStop" +
        "id=" + id +
        ", district='" + district + '\'' +
        ", street_name='" + streetName + '\'' +
        ", street_number='" + streetNumber + '\'';
  }

}
