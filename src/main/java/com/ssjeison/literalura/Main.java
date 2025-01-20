package com.ssjeison.literalura;

import com.ssjeison.literalura.model.Book;
import com.ssjeison.literalura.repository.DatabaseManager;
import com.ssjeison.literalura.service.ApiService;
import com.ssjeison.literalura.util.JsonParser;

import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiService apiService = new ApiService();
        DatabaseManager dbManager = new DatabaseManager();
        JsonParser parser = new JsonParser();

        try {
            dbManager.setupDatabase();

            while (true) {
                System.out.println("=== Menú ===");
                System.out.println("1. Buscar libros");
                System.out.println("2. Ver libros en la base de datos");
                System.out.println("3. Salir");
                System.out.print("Selecciona una opción: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                if (option == 1) {
                    System.out.print("Ingresa un término de búsqueda: ");
                    String query = scanner.nextLine();
                    String response = apiService.fetchBooks(query);
                    Book[] books = parser.parseBooks(response);
                    for (Book book : books) {
                        System.out.println(book.getTitle() + " - " + book.getAuthor());
                        dbManager.insertBook(book);
                    }
                } else if (option == 2) {
                    ResultSet rs = dbManager.getAllBooks();
                    while (rs.next()) {
                        System.out.println(rs.getString("title") + " - " + rs.getString("author"));
                    }
                } else if (option == 3) {
                    break;
                } else {
                    System.out.println("Opción inválida.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
