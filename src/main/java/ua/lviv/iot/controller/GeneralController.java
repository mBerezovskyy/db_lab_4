package ua.lviv.iot.controller;

import java.sql.SQLException;
import java.util.List;

public interface GeneralController<T> {

  List<T> findAll() throws SQLException;

  T findById(Integer id) throws SQLException;

  void create(T object) throws SQLException;

  void update(Integer id, T object) throws SQLException;

  void delete(Integer id) throws SQLException;

}
