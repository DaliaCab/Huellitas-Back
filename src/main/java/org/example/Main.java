package org.example;

import org.example.CRUD.Create;
import org.example.CRUD.Delete;
import org.example.CRUD.Read;
import org.example.CRUD.Update;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Crear cliente");
            System.out.println("2. Leer clientes");
            System.out.println("3. Actualizar datos de un cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Create create = new Create();
                    scanner.nextLine(); // salto de línea
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasena = scanner.nextLine();
                    System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
                    String fechaNacimiento = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    int telefono = scanner.nextInt();
                    scanner.nextLine(); // salto de línea
                    System.out.print("Fecha de Afiliación (YYYY-MM-DD): ");
                    String fechaAfiliacion = scanner.nextLine();
                    create.createCliente(nombre, apellido, contrasena, fechaNacimiento, correo, telefono, fechaAfiliacion);
                    break;
                case 2:
                    Read read = new Read();
                    System.out.print("Indique el id del usuario que quiere leer, marque 0 (cero) si quiere verlos todos: ");
                    int id = scanner.nextInt();
                    read.readClientesById(id);
                    break;
                case 3:
                    Update update = new Update();
                    read = new Read();
                    System.out.print("IDCliente a actualizar: ");
                    int idClienteUpdate = scanner.nextInt();
                    read.readClientesById(idClienteUpdate);
                    System.out.println("¿Cual dato desea actualizar?");
                    System.out.println("1. Nombre");
                    System.out.println("2. Apellido");
                    System.out.println("3. Contraseña");
                    System.out.println("4. Correo");
                    System.out.println("5. telefono");
                    int updateOption = scanner.nextInt();
                    scanner.nextLine(); // salto de línea
                    switch (updateOption) {
                        case 1:
                            System.out.print("Nuevo Nombre: ");
                            String nuevoNombre = scanner.nextLine();
                            update.updateClienteNombre(idClienteUpdate, nuevoNombre);
                            break;
                        case 2:
                            System.out.print("Nuevo Apellido: ");
                            String nuevoApellido = scanner.nextLine();
                            update.updateClienteApellido(idClienteUpdate, nuevoApellido);
                            break;
                        case 3:
                            System.out.print("Nueva Contraseña: ");
                            String nuevaContrasena = scanner.nextLine();
                            update.updateClienteContrasena(idClienteUpdate, nuevaContrasena);
                            break;
                        case 4:
                            System.out.print("Nuevo Correo: ");
                            String nuevoCorreo = scanner.nextLine();
                            update.updateClienteCorreo(idClienteUpdate, nuevoCorreo);
                            break;
                        case 5:
                            System.out.print("Nuevo Teléfono: ");
                            int nuevoTelefono = scanner.nextInt();
                            update.updateClienteTelefono(idClienteUpdate, nuevoTelefono);
                            break;
                    }
                    break;
                case 4:
                    Delete delete = new Delete();
                    System.out.print("IDCliente a eliminar: ");
                    int idClienteDelete = scanner.nextInt();
                    delete.deleteCliente(idClienteDelete);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
