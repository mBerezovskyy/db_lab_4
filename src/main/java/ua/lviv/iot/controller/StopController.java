package ua.lviv.iot.controller;

import ua.lviv.iot.dao.StopDAO;
import ua.lviv.iot.model.Stop;

import java.sql.SQLException;
import java.util.List;

public class StopController implements GeneralController<Stop> {

  StopDAO stopDAO = new StopDAO();

  @Override
  public List<Stop> findAll() throws SQLException {
    return stopDAO.findAll();
  }

  @Override
  public Stop findById(Integer id) throws SQLException {
    return stopDAO.findById(id);
  }

  @Override
  public void create(Stop profile) throws SQLException {
    stopDAO.create(profile);
  }

  @Override
  public void update(Integer id, Stop profile) throws SQLException {
    stopDAO.update(id, profile);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    stopDAO.delete(id);
  }
}
