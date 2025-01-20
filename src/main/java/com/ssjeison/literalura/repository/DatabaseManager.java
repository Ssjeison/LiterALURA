package com.ssjeison.literalura.repository;

import com.ssjeison.literalura.model.Book;

import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/literalura";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "3145";

    public void setupDatabase() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String createTable = """
                CREATE TABLE IF NOT EXISTS books (
                    id SERIAL PRIMARY KEY,
                    title VARCHAR(255) NOT NULL,
                    author VARCHAR(255) NULL
                )
            """;
            conn.createStatement().execute(createTable);
        }
    }

    public void insertBook(Book book) throws SQLException {
        String query = "INSERT INTO books (id, title, author) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, book.getId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.executeUpdate();
        }
    }

    public ResultSet getAllBooks() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        return conn.createStatement().executeQuery("SELECT * FROM books");
    }
}
