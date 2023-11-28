package main;

import java.sql.Connection;
import java.util.List;

public interface CRUD {
    void Create(Connection connection, Estate estate);
    List<Estate> Read(Connection connection);
    void Update(Connection connection, Estate estate, int id);
    void Delete(Connection connection, int id);
}
