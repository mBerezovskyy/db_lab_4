package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.DriverHasBus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverHasBusDAO implements GeneralDAO<DriverHasBus> {

  private static final String SELECT_ALL = "SELECT * FROM fixbus_db.driver_has_bus";
  private static final String SELECT_ONE = "SELECT * FROM fixbus_db.driver_has_bus WHERE id=?";
  private static final String CREATE = "INSERT fixbus_db.driver_has_bus (driver_id, bus_id)" +
      "VALUES (?,?)";
  private static final String UPDATE = "UPDATE fixbus_db.driver_has_bus SET driver_id=?," +
      "bus_id=? WHERE id=?";
  private static final String DELETE = "DELETE FROM fixbus_db.driver_has_bus WHERE id=?";

  @Override
  public List<DriverHasBus> findAll() throws SQLException {
    List<DriverHasBus> driversBus = new ArrayList<DriverHasBus>();
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
      System.out.println(ps);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        DriverHasBus usersTicket = new DriverHasBus(
            resultSet.getInt("id"),
            resultSet.getInt("driver_id"),
            resultSet.getInt("bus_id"));
        driversBus.add(usersTicket);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return driversBus;
  }

  @Override
  public DriverHasBus findById(Integer id) throws SQLException {
    DriverHasBus driversBus = null;
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        driversBus = new DriverHasBus(
            resultSet.getInt("id"),
            resultSet.getInt("driver_id"),
            resultSet.getInt("bus_id"));
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return driversBus;
  }

  @Override
  public void create(DriverHasBus newDriverHasBus) throws SQLException {
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
      ps.setInt(2, newDriverHasBus.getBusId());
      ps.setInt(1, newDriverHasBus.getDriverId());
      ps.executeUpdate();
      System.out.println(ps);

    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }


  @Override
  public void update(Integer id, DriverHasBus driverHasBus) throws SQLException {
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
      ps.setInt(3, id);
      ps.setInt(2, driverHasBus.getBusId());
      ps.setInt(1, driverHasBus.getDriverId());

      ps.executeUpdate();
      System.out.println(ps);

    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) throws SQLException {
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(DELETE)) {
      ps.setInt(1, id);
      System.out.println(ps);
      ps.executeUpdate();

    } catch (Exception exception) {
      exception.printStackTrace();
    }

  }
}
