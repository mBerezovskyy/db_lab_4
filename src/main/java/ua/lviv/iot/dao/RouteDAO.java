package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.Route;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RouteDAO implements GeneralDAO<Route> {

  private static final String SELECT_ALL = "SELECT * FROM fixbus_db.route";
  private static final String SELECT_ONE = "SELECT * FROM fixbus_db.route WHERE id=?";
  private static final String CREATE = "INSERT fixbus_db.route "
      + "(total_fare, starting_stop_id, end_stop_id) VALUES (?,?,?)";
  private static final String UPDATE = "UPDATE fixbus_db.route"
      + " SET total_fare=?, starting_stop_id=?, end_stop_id=? WHERE id=?";
  private static final String DELETE = "DELETE FROM fixbus_db.route WHERE id=?";


  @Override
  public List<Route> findAll(){
    List<Route> routes = new ArrayList<>();
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
      System.out.println(ps);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        Route route = new Route(
            resultSet.getInt("id"),
            resultSet.getInt("total_fare"),
            resultSet.getInt("starting_stop_id"),
            resultSet.getInt("end_stop_id"));
        routes.add(route);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return routes;
  }

  @Override
  public Route findById(Integer id) {
    Route route = null;
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        route = new Route(
            resultSet.getInt("id"),
            resultSet.getInt("total_fare"),
            resultSet.getInt("starting_stop_id"),
            resultSet.getInt("end_stop_id"));

      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return route;
  }

  @Override
  public void create(Route newRoute) {
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
      ps.setInt(1, newRoute.getTotalFare());
      ps.setInt(2, newRoute.getStartingStopId());
      ps.setInt(3, newRoute.getEndStopId());
      ps.executeUpdate();
      System.out.println(ps);

    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }


  @Override
  public void update(Integer id, Route updatedRoute){
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
      ps.setInt(1, updatedRoute.getTotalFare());
      ps.setInt(2, updatedRoute.getStartingStopId());
      ps.setInt(3, updatedRoute.getEndStopId());
      ps.setInt(4, id);
      ps.executeUpdate();
      System.out.println(ps);

    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id){
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(DELETE)) {
      ps.setInt(1, id);
      System.out.println(ps);
      ps.executeUpdate();

    } catch (Exception exception) {
      exception.printStackTrace();
    }

  }
}

