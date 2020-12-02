package ua.lviv.iot.model;

public class DriverHasRoute {
  private Integer id;
  private Integer driverId;
  private Integer routeId;

  public DriverHasRoute(Integer id, Integer driverId, Integer routeId) {
    this.id = id;
    this.driverId = driverId;
    this.routeId = routeId;
  }

  public DriverHasRoute(Integer driverId, Integer routeId) {
    this(null, driverId, routeId);
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

  public Integer getRouteId() {
    return routeId;
  }

  public void setRouteId(Integer routeId) {
    this.routeId = routeId;
  }

  @Override
  public String toString() {
    return "DriverHasRoute\n" +
        "id=" + id +
        ", driver_id=" + driverId +
        ", route_id=" + routeId;
  }
}
