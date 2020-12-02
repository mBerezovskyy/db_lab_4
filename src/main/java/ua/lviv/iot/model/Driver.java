package ua.lviv.iot.model;

public class Driver {

  private Integer id;
  private String name;
  private String surname;


  public Driver(Integer id, String name, String surname) {
    this.id = id;
    this.name = name;
    this.surname = surname;

  }

  public Driver(String name, String surname) {
    this(null, name, surname);
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

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }


  @Override
  public String toString() {
    return "\nDriver: " +
        "id: " + id +
        ", name: " + name +
        ", surname: " + surname;
  }
}
