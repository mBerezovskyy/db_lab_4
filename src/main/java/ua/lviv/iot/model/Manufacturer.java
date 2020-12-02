package ua.lviv.iot.model;

public class Manufacturer {

  private Integer id;
  private String name;
  private String phoneNumber;
  private String officeAdress;

  public Manufacturer(Integer id, String name, String phoneNumber, String officeAdress) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.officeAdress = officeAdress;
  }

  public Manufacturer(String name, String phoneNumber, String officeAdress) {
    this(null, name, phoneNumber, officeAdress);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getOfficeAdress() {
    return officeAdress;
  }

  public void setOfficeAdress(String officeAdress) {
    this.officeAdress = officeAdress;
  }

  @Override
  public String toString() {
    return "\nManufacturer: " +
        "id:" + id + ", name:" + name + ", office_adress:" + officeAdress + ", phone_number: " + phoneNumber;
  }
}
