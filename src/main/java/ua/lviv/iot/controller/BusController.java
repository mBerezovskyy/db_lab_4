package ua.lviv.iot.controller;

import ua.lviv.iot.dao.BusDAO;
import ua.lviv.iot.model.Bus;

import java.sql.SQLException;
import java.util.List;

public class BusController implements GeneralController<Bus> {

  BusDAO busDAO = new BusDAO();

  @Override
  public List<Bus> findAll() throws SQLException {
    return busDAO.findAll();
  }

  @Override
  public Bus findById(Integer id) throws SQLException {
    return busDAO.findById(id);
  }

  @Override
  public void create(Bus bus) throws SQLException {
    busDAO.create(bus);
  }

  @Override
  public void update(Integer id, Bus bus) throws SQLException {
    busDAO.update(id, bus);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    busDAO.delete(id);
  }
}
