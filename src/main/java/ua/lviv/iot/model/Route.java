package ua.lviv.iot.model;

public class Route {


  private Integer id;
  private Integer totalFare;
  private Integer startingStopId;
  private Integer endStopId;

  public Route(Integer id, Integer totalFare, Integer startingStopId, Integer endStopId) {
    this.id = id;
    this.totalFare = totalFare;
    this.startingStopId = startingStopId;
    this.endStopId = endStopId;
  }

  public Route(Integer totalFare, Integer startingStopId, Integer endStopId) {
    this(null, totalFare, startingStopId, endStopId);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getTotalFare() {
    return totalFare;
  }

  public void setTotalFare(Integer totalFare) {
    this.totalFare = totalFare;
  }

  public Integer getStartingStopId() {
    return startingStopId;
  }

  public void setStartingStopId(Integer startingStopId) {
    this.startingStopId = startingStopId;
  }

  public Integer getEndStopId() {
    return endStopId;
  }

  public void setEndStopId(Integer endStopId) {
    this.endStopId = endStopId;
  }

  @Override
  public String toString() {
    return "\nRoute\n" +
        "id=" + id +
        ", total_fare=" + totalFare +
        ", starting_stop_id=" + startingStopId +
        ", end_stop_id=" + endStopId;
  }
}
