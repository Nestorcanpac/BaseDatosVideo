package org.example;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

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

            System.out.println("*****");

            while (resultado.next()){
                String id= resultado.getString("id");
                String titulo= resultado.getString("titulo");
                String genero= resultado.getString("genero");
                String precio= resultado.getString("precio");
                String imagen= resultado.getString("imagen");
                String id_Desarrollador= resultado.getString("id_Desarrollador");
                System.out.println(id+" "+titulo+" "+genero+" "+precio+" "+imagen+" "+id_Desarrollador);
            }
            System.out.println(" ");


            System.out.println("********************INSERT********************");

            String insert= "Insert into Videojuegos values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(insert);

            preparedStatement.setInt(1,4);
            preparedStatement.setString(2,"Borderlands");
            preparedStatement.setString(3,"FPS");
            preparedStatement.setDouble(4,8.34);
            preparedStatement.setString(5,"https://static.wikia.nocookie.net/borderlands/images/a/a3/Borderlands3.jpg/revision/latest?cb=20190404183924&path-prefix=es");
            preparedStatement.setInt(6,4);
            int valor = preparedStatement.executeUpdate();



            Statement sentencia2= conexion.createStatement();
            String consulta2= "Select * from Videojuegos";
            ResultSet resultSet= sentencia2.executeQuery(consulta2);

            while (resultSet.next()){
                String id= resultSet.getString("id");
                String titulo= resultSet.getString("titulo");
                String genero= resultSet.getString("genero");
                String precio= resultSet.getString("precio");
                String imagen= resultSet.getString("imagen");
                String id_Desarrollador= resultSet.getString("id_Desarrollador");
                System.out.println(id+" "+titulo+" "+genero+" "+precio+" "+imagen+" "+id_Desarrollador);
            }
            System.out.println(" ");

            System.out.println("***********************DELETE***********************");

            String delete="Delete from Videojuegos where titulo like 'Borderlands'";
            PreparedStatement sentenciaDelete= conexion.prepareStatement(delete);
            int valorDelete= sentenciaDelete.executeUpdate();

            Statement sentencia3= conexion.createStatement();
            String consulta3= "Select * from Videojuegos";
            ResultSet resultSet2= sentencia3.executeQuery(consulta3);

            while (resultSet2.next()){
                String id= resultSet2.getString("id");
                String titulo= resultSet2.getString("titulo");
                String genero= resultSet2.getString("genero");
                String precio= resultSet2.getString("precio");
                String imagen= resultSet2.getString("imagen");
                String id_Desarrollador= resultSet2.getString("id_Desarrollador");
                System.out.println(id+" "+titulo+" "+genero+" "+precio+" "+imagen+" "+id_Desarrollador);
            }
            System.out.println(" ");

            System.out.println("**************************UPDATE******************************");

            String update= "Update Videojuegos set titulo='Borderlands 3' where id=3";
            PreparedStatement preparedStatementUpdate= conexion.prepareStatement(update);
            int valorUpdate = preparedStatementUpdate.executeUpdate();

            Statement sentencia4= conexion.createStatement();
            String consulta4= "Select * from Videojuegos";
            ResultSet resultSet3= sentencia4.executeQuery(consulta4);

            while (resultSet3.next()){
                String id= resultSet3.getString("id");
                String titulo= resultSet3.getString("titulo");
                String genero= resultSet3.getString("genero");
                String precio= resultSet3.getString("precio");
                String imagen= resultSet3.getString("imagen");
                String id_Desarrollador= resultSet3.getString("id_Desarrollador");
                System.out.println(id+" "+titulo+" "+genero+" "+precio+" "+imagen+" "+id_Desarrollador);
            }



            resultSet3.close();
            preparedStatementUpdate.close();
            resultSet.close();
            sentencia2.close();
            preparedStatement.close();
            resultado.close();
            sentencia.close();
            conexion.close();
        }

        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}