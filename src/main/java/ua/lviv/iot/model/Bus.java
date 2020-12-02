package ua.lviv.iot.model;

public class Bus {

  private Integer id;
  private String numberSign;
  private Integer age;
  private Integer capacity;
  private Integer mileage;
  private Integer manufacturerId;


  public Bus(Integer id, String numberSign, Integer age, Integer capacity,
             Integer mileage, Integer manufacturerId) {
    this.id = id;
    this.numberSign = numberSign;
    this.age = age;
    this.capacity = capacity;
    this.mileage = mileage;
    this.manufacturerId = manufacturerId;
  }

  public Bus(String numberSign, Integer age, Integer capacity,
             Integer mileage, Integer manufacturerId) {
    this(null, numberSign, age, capacity, mileage, manufacturerId);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNumberSign() {
    return numberSign;
  }

  public void setNumberSign(String numberSign) {
    this.numberSign = numberSign;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public Integer getMileage() {
    return mileage;
  }

  public void setMileage(Integer mileage) {
    this.mileage = mileage;
  }

  public Integer getManufacturerId() {
    return manufacturerId;
  }

  public void setManufacturerId(Integer manufacturerId) {
    this.manufacturerId = manufacturerId;
  }


  @Override
  public String toString() {
    return "\nBus: " +
        "id:" + id +
        ", number_sign: " + numberSign +
        ", age: " + age +
        ", capacity: " + capacity +
        ", mileage: " + mileage +
        ", manufacturer_id: " + manufacturerId;
  }
}
