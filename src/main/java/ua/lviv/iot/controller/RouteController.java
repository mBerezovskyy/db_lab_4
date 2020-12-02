package ua.lviv.iot.controller;

import ua.lviv.iot.dao.RouteDAO;
import ua.lviv.iot.model.Route;

import java.sql.SQLException;
import java.util.List;

public class RouteController implements GeneralController<Route> {

  RouteDAO routeDAO = new RouteDAO();

  @Override
  public List<Route> findAll() throws SQLException {
    return routeDAO.findAll();
  }

  @Override
  public Route findById(Integer id) throws SQLException {
    return routeDAO.findById(id);
  }

  @Override
  public void create(Route route) throws SQLException {
    routeDAO.create(route);
  }

  @Override
  public void update(Integer id, Route route) throws SQLException {
    routeDAO.update(id, route);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    routeDAO.delete(id);
  }
}
