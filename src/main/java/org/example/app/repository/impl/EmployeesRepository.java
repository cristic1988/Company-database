package org.example.app.repository.impl;

import org.example.app.database.DBConn;
import org.example.app.entity.Employees;
import org.example.app.repository.AppRepository;
import org.example.app.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeesRepository implements AppRepository<Employees> {

    private final static String TABLE_EMPLOYEES = "employees";

    @Override
    public String create(Employees employees) {

        String sql = "INSERT INTO " + TABLE_EMPLOYEES +
                " (name, age, position, salary ) VALUES(?, ?, ?, ?)";
                try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {

            pstmt.setString(1, employees.getName());
            pstmt.setInt(2, employees.getAge());
            pstmt.setString(3, employees.getPosition());
            pstmt.setDouble(4, employees.getSalary());

            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    @Override
    public Optional<List<Employees>> read() {
        try (Statement stmt = DBConn.connect().createStatement()) {
            List<Employees> list = new ArrayList<>();

            String sql = "SELECT id, name, age, position, salary FROM "
                    + TABLE_EMPLOYEES;

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new Employees(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getInt("age"),
                                rs.getString("position"),
                                rs.getDouble("salary")
                        )
                );
            }

            return Optional.of(list);
        } catch (SQLException e) {

            return Optional.empty();
        }
    }

    @Override
    public String update(Employees employees) {

        if (readById(employees.getId()).isEmpty()) {
            return Constants.DATA_ABSENT_MSG;
        } else {

            String sql = "UPDATE " + TABLE_EMPLOYEES +
                    " SET name = ?, age = ?, position = ?, salary = ?" +
                    " WHERE id = ?";

            try (PreparedStatement pst = DBConn.connect().prepareStatement(sql)) {

                pst.setString(1, employees.getName());
                pst.setInt(2, employees.getAge());
                pst.setString(3, employees.getPosition());
                pst.setDouble(4, employees.getSalary());
                pst.setLong(5, employees.getId());

                pst.executeUpdate();

                return Constants.DATA_UPDATE_MSG;
            } catch (SQLException e) {

                return e.getMessage();
            }
        }
    }

    @Override
    public String delete(Long id) {

        if (!isIdExists(id)) {
            return Constants.DATA_ABSENT_MSG;
        } else {

            String sql = "DELETE FROM " + TABLE_EMPLOYEES +
                    " WHERE id = ?";

            try (PreparedStatement pst = DBConn.connect().prepareStatement(sql)) {

                pst.setLong(1, id);

                pst.executeUpdate();

                return Constants.DATA_DELETE_MSG;
            } catch (SQLException e) {

                return e.getMessage();
            }
        }
    }

    @Override
    public Optional<Employees> readById(Long id) {

        String sql = "SELECT id, name, age, position, salary FROM "
                + TABLE_EMPLOYEES + " WHERE id = ?";
        try (PreparedStatement pst = DBConn.connect().prepareStatement(sql)) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            Employees employees = new Employees(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("position"),
                    rs.getDouble("salary")
            );

            return Optional.of(employees);
        } catch (SQLException e) {

            return Optional.empty();
        }
    }


    private boolean isIdExists(Long id) {
        String sql = "SELECT COUNT(id) FROM " + TABLE_EMPLOYEES +
                " WHERE id = ?";
        try {
            PreparedStatement pst = DBConn.connect().prepareStatement(sql);
            pst.setLong(1, id);
            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }
}
