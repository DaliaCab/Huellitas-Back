package org.example.CRUD;

import java.sql.*;
import static org.example.CRUD.Credentials.*;

public class Delete {

    // Método Delete
    public void deleteCliente(int idCliente) {
        String deleteQuery = "DELETE FROM cliente WHERE IDCliente = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, idCliente);
            pstmt.executeUpdate();
            System.out.println("Cliente eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
