package org.example;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try{
            FileReader fileReader =new FileReader(new File("Videojuegos.sql"));
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            StringBuilder script= new StringBuilder();
            String linea;

            while ((linea = bufferedReader.readLine()) != null){
                script.append(linea).append("\n");
            }
            System.out.println(script);

            Connection conexion=
                    DriverManager.getConnection("jdbc:sqlite:Videojuegos.db");

            Statement sentencia = conexion.createStatement();
            String sql = script.toString();
            int resultadoQuery = sentencia.executeUpdate(sql);

            String consultaVideo= "Select * from Videojuegos";
            ResultSet resultado= sentencia.executeQuery(consultaVideo);

            while (resultado.next()){
                String id= resultado.getString("id");
                String titulo= resultado.getString("titulo");
                String genero= resultado.getString("genero");
                String precio= resultado.getString("precio");
                String imagen= resultado.getString("imagen");
                String id_Desarrollador= resultado.getString("id_Desarrollador");
                System.out.println(id+" "+titulo+" "+genero+" "+precio+" "+imagen+" "+id_Desarrollador);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}