package ua.lviv.iot.model;


public class DriverHasBus {

  private Integer id;
  private Integer driverId;
  private Integer busId;

  public DriverHasBus(Integer id, Integer driverId, Integer busId) {
    this.id = id;
    this.driverId = driverId;
    this.busId = busId;
  }

  public DriverHasBus(Integer driverId, Integer busId) {
    this(null, driverId, busId);
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getDriverId() {
    return driverId;
  }

  public void setDriverId(Integer driverId) {
    this.driverId = driverId;
  }

  public Integer getBusId() {
    return busId;
  }

  public void setBusId(Integer busId) {
    this.busId = busId;
  }

  @Override
  public String toString() {
    return "\nUserProfileHasTicket: " +
        "id:" + id +
        ", driver_id" + driverId +
        ", bus_id:" + busId;
  }
}


