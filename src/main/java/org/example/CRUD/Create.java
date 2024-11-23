package org.example.CRUD;

import java.sql.*;  // Importa la clase Connection, DriverManager, PreparedStatement, ResultSet y SQLException
import static org.example.CRUD.Credentials.*;

public class Create {

    private int getNextId() {
        String query = "SELECT MAX(IDCliente) as id FROM cliente";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt("id") + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Método Create
    public void createCliente(String nombre, String apellido, String contrasena, String fechaNacimiento, String correo, int telefono, String fechaAfiliacion) {
        String insertQuery = "INSERT INTO cliente (IDCliente, nombre, apellido, contrasena, fechaNacimiento, correo, telefono, fechaAfiliacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
            int id = getNextId();
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            pstmt.setString(4, contrasena);
            pstmt.setDate(5, Date.valueOf(fechaNacimiento));
            pstmt.setString(6, correo);
            pstmt.setInt(7, telefono);
            pstmt.setDate(8, Date.valueOf(fechaAfiliacion));
            pstmt.executeUpdate();
            System.out.println("Cliente agregado correctamente. Su id es: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
