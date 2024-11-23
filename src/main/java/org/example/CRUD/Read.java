package org.example.CRUD;

import java.sql.*;
import static org.example.CRUD.Credentials.*;

public class Read {

    // Método Read todos
    public void readClientes() {
        String query = "SELECT * FROM cliente";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("IDCliente: " + rs.getInt("IDCliente"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Apellido: " + rs.getString("apellido"));
                System.out.println("Correo: " + rs.getString("correo"));
                System.out.println("Teléfono: " + rs.getInt("telefono"));
                System.out.println("Fecha de Afiliación: " + rs.getDate("fechaAfiliacion"));
                System.out.println("---------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método Read por id
    public void readClientesById(int id) {
        if (id == 0){ // Si el id es 0, se muestran todos los clientes
            readClientes();
            return;
        }

        String query = "SELECT * FROM cliente Where IDCliente = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(query)){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("IDCliente: " + rs.getInt("IDCliente"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Apellido: " + rs.getString("apellido"));
                System.out.println("Correo: " + rs.getString("correo"));
                System.out.println("Teléfono: " + rs.getInt("telefono"));
                System.out.println("Fecha de Afiliación: " + rs.getDate("fechaAfiliacion"));
                System.out.println("---------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
