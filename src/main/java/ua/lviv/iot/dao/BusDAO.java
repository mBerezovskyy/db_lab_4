package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.Bus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusDAO implements GeneralDAO<Bus> {

  private static final String SELECT_ALL = "SELECT * FROM fixbus_db.bus";
  private static final String SELECT_ONE = "SELECT * FROM fixbus_db.bus WHERE id=?";
  private static final String CREATE = "INSERT fixbus_db.bus"
      + "(number_sign, age, capacity, mileage, manufacturer_id)" +
      "VALUES (?,?,?,?,?)";
  private static final String UPDATE = "UPDATE fixbus_db.bus"
      + " SET number_sign=?, age=?, capacity=?, mileage=?,  " +
      "manufacturer_id=? WHERE id=?";
  private static final String DELETE = "DELETE FROM fixbus_db.bus WHERE id=?";


  @Override
  public List<Bus> findAll() throws SQLException {
    List<Bus> buses = new ArrayList<Bus>();
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
      System.out.println(ps);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        Bus bus = new Bus(
            resultSet.getInt("id"),
            resultSet.getString("number_sign"),
            resultSet.getInt("age"),
            resultSet.getInt("capacity"),
            resultSet.getInt("mileage"),
            resultSet.getInt("manufacturer_id"));
        buses.add(bus);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return buses;
  }


  @Override
  public Bus findById(Integer id) throws SQLException {
    Bus bus = null;
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        bus = new Bus(
            resultSet.getInt("id"),
            resultSet.getString("number_sign"),
            resultSet.getInt("age"),
            resultSet.getInt("capacity"),
            resultSet.getInt("mileage"),
            resultSet.getInt("manufacturer_id"));
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return bus;
  }

  @Override
  public void create(Bus bus) throws SQLException {

    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
      ps.setString(1, bus.getNumberSign());
      ps.setInt(2, bus.getAge());
      ps.setInt(3, bus.getCapacity());
      ps.setInt(4, bus.getMileage());
      ps.setInt(5, bus.getManufacturerId());
      ps.executeUpdate();
      System.out.println(ps);

    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }


  @Override
  public void update(Integer id, Bus newBus) throws SQLException {
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
      ps.setInt(6, id);
      ps.setString(1, newBus.getNumberSign());
      ps.setInt(2, newBus.getMileage());
      ps.setInt(3, newBus.getAge());
      ps.setInt(4, newBus.getCapacity());
      ps.setInt(5, newBus.getManufacturerId());

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
