package org.example.CRUD;

import java.sql.*;
import static org.example.CRUD.Credentials.*;


public class Update {

    // Método Update nombre
    public void updateClienteNombre(int idCliente, String nuevoNombre) {
        String updateQuery = "UPDATE cliente SET nombre = ? WHERE IDCliente = ?";
        UpdateStringMethod(idCliente, nuevoNombre, updateQuery);
        System.out.println("Nombre actualizado correctamente.");
    }

    // Método Update apellido
    public void updateClienteApellido(int idCliente, String nuevoApellido) {
        String updateQuery = "UPDATE cliente SET apellido = ? WHERE IDCliente = ?";
        UpdateStringMethod(idCliente, nuevoApellido, updateQuery);
        System.out.println("Apellido actualizado correctamente.");
    }

    // Método Update contraseña
    public void updateClienteContrasena(int idCliente, String nuevaContrasena) {
        String updateQuery = "UPDATE cliente SET contrasena = ? WHERE IDCliente = ?";
        UpdateStringMethod(idCliente, nuevaContrasena, updateQuery);
        System.out.println("Contraseña actualizado correctamente.");
    }

    // Método Update correo
    public void updateClienteCorreo(int idCliente, String nuevoCorreo) {
        String updateQuery = "UPDATE cliente SET correo = ? WHERE IDCliente = ?";
        UpdateStringMethod(idCliente, nuevoCorreo, updateQuery);
        System.out.println("Contraseña actualizado correctamente.");
    }

    private void UpdateStringMethod(int idCliente, String nuevoString, String updateQuery) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {
            pstmt.setString(1, nuevoString);
            pstmt.setInt(2, idCliente);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método Update telefono
    public void updateClienteTelefono(int idCliente, int nuevoTelefono) {
        String updateQuery = "UPDATE cliente SET telefono = ? WHERE IDCliente = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {
            pstmt.setInt(1, nuevoTelefono);
            pstmt.setInt(2, idCliente);
            pstmt.executeUpdate();
            System.out.println("Teléfono actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
