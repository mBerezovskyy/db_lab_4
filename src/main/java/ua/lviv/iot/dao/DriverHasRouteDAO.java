package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
//import ua.lviv.iot.model.DriverHasBus;
import ua.lviv.iot.model.DriverHasRoute;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverHasRouteDAO implements GeneralDAO<DriverHasRoute> {

  private static final String SELECT_ALL = "SELECT * FROM fixbus_db.driver_has_route";
  private static final String SELECT_ONE = "SELECT * FROM fixbus_db.driver_has_route WHERE id=?";
  private static final String CREATE = "INSERT fixbus_db.driver_has_route (driver_id, route_id)" +
      "VALUES (?,?)";
  private static final String UPDATE = "UPDATE fixbus_db.driver_has_route SET driver_id=?," +
      "route_id=? WHERE id=?";
  private static final String DELETE = "DELETE FROM fixbus_db.driver_has_route WHERE id=?";

  @Override
  public List<DriverHasRoute> findAll() throws SQLException {
    List<DriverHasRoute> driversRoute = new ArrayList<DriverHasRoute>();
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
      System.out.println(ps);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        DriverHasRoute usersTicket = new DriverHasRoute(
            resultSet.getInt("id"),
            resultSet.getInt("driver_id"),
            resultSet.getInt("route_id"));
        driversRoute.add(usersTicket);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return driversRoute;
  }

  @Override
  public DriverHasRoute findById(Integer id) throws SQLException {
    DriverHasRoute driversRoute = null;
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        driversRoute = new DriverHasRoute(
            resultSet.getInt("id"),
            resultSet.getInt("driver_id"),
            resultSet.getInt("route_id"));
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return driversRoute;
  }

  @Override
  public void create(DriverHasRoute newDriverHasRoute) throws SQLException {
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
      ps.setInt(1, newDriverHasRoute.getDriverId());
      ps.setInt(2, newDriverHasRoute.getRouteId());
      ps.executeUpdate();
      System.out.println(ps);

    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, DriverHasRoute newDriverHasRoute) throws SQLException {
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
      ps.setInt(3, id);
      ps.setInt(1, newDriverHasRoute.getDriverId());
      ps.setInt(2, newDriverHasRoute.getRouteId());

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
