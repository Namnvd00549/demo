package com.t1708m.model;

import com.t1708m.entity.Student;
import jdk.net.SocketFlow;

import java.sql.*;
import java.util.ArrayList;

public class StudentModel {
    public boolean save(Student student) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student-manager?user=root&password=abcD1234");
            Statement statement = connection.createStatement();
            String sqlCommand = "insert into students (username, password, email, fullName, address, phone) " +
                    "values ('" + student.getUsername() + "', '" + student.getPassword() + "'" +
                    ", '" + student.getEmail() + "', '" + student.getFullName() + "', '" + student.getAddress() + "', '" + student.getPhone() + "')";
            statement.execute(sqlCommand);
            System.out.println("Okie.");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean saveV2(Student student) {
        try {
            String sqlCommand = "insert into students (username, password, email, fullName, address, phone) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, student.getUsername());
            preparedStatement.setString(2, student.getPassword());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getFullName());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setString(6, student.getPhone());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<Student> getList() {
        ArrayList<Student> results = new ArrayList<>();
        try {
            String sqlCommand = "select * from students";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Student student = new Student();
                student.setUsername(username);
                student.setPassword(password);
                student.setFullName(fullName);
                student.setEmail(email);
                student.setAddress(address);
                student.setPhone(phone);
                results.add(student);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public Student findByUsenameAndStatus(String username, Student.Status.status) {
        try {
            String sqlCommand = "select  * from students where username = ? and status = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString( 1, username);
            preparedStatement.setInt( 2, status.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String rsUsername = resultSet.getString(1);
                String rsPassword = resultSet.getString(2);
                String rsEmail = resultSet.getString(3);
                String rsFullname = resultSet.getString(4);
                String rsAddress = resultSet.getString(5);
                String rsPhone = resultSet.getString(6);
                int rsStatus = resultSet.getInt(7);
                Student student = new Student();
                student.setUsername(rsUsername);
                student.setPassword(rsPassword);
                student.setEmail(rsEmail);
                student.setFullName(rsFullname);
                student.setAddress(rsAddress);
                student.setPhone(rsPhone);
                student.setStatus(Student.Status.findByValue(rsStatus));
                return student;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
