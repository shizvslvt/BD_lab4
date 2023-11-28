package main;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String URL ="jdbc:mysql://localhost:3306/realtor_office";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static Connection connection;
    static List<Estate> estates;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {throw new RuntimeException(e);}
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    private void run() {
        CRUDimpl crud = new CRUDimpl();
        InputImpl input = new InputImpl();
        Scanner scanner = new Scanner(System.in);
        menu(crud,input,scanner);
    }
    private void menu(CRUDimpl crud, InputImpl input, Scanner scanner) {
        System.out.println("""
        [first - read]
        [1] - Create
        [2] - Read
        [3] - Update
        [4] - Delete
        [5] - Show
        [0] - Exit""");

        boolean status = true;
        while (status) {
            System.out.print("Input option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> createEstate(crud, input);
                case 2 -> readEstate(crud);
                case 3 -> updateEstate(crud, input,scanner);
                case 4 -> deleteEstate(crud, scanner);
                case 5 -> showEstate();
                case 0 -> status = false;
            }
            System.out.println("successful");
        }
    }
    private static void createEstate(CRUDimpl crud, InputImpl input) {
        crud.Create(connection, input.InputEstate());
    }
    private static void readEstate(CRUDimpl crud) {
        estates = crud.Read(connection);
    }
    private static void updateEstate(CRUDimpl crud, InputImpl input, Scanner scanner) {
        System.out.print("Print estate ID what u want to edit:");
        int id = scanner.nextInt();
        crud.Update(connection, input.InputEstate(),id);
    }
    private static void deleteEstate(CRUDimpl crud, Scanner scanner) {
        System.out.print("Print estate ID what u want to delete:");
        int id = scanner.nextInt();
        crud.Delete(connection, id);
    }
    private void showEstate() {
        for (Estate estate : estates) System.out.println(estate + "\n------------------------");
    }
}























