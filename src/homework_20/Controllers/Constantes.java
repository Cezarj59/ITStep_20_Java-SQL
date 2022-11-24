package homework_20.Controllers;

import java.util.Scanner;

public class Constantes {

    public static Scanner read = new Scanner(System.in);
    
    public static String host = "localhost";
    public static String port = "3306";
    public static String banco = "myStore";
    public static String url = "jdbc:mysql://" + host + ":" + port + "/" + banco;

    public static String user = "root";
    public static String pass = "";
}
