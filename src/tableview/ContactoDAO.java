package tableview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ContactoDAO() {
    }
    
    public void openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactos", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public void registrarContacto(Contacto contacto) {
        try {
            openConnection();
            String query = "insert into contacto(nombre,telefono,departamento,direccion) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, contacto.getNombre());
            preparedStatement.setString(2, contacto.getTelefono());
            preparedStatement.setString(3, contacto.getDepartamento());
            preparedStatement.setString(4, contacto.getDireccion());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
        }
    }

    public List<Contacto> listarContactos() {
        List<Contacto> contactos = new ArrayList();
        try {
            openConnection();
            statement = connection.createStatement();
            String query = "select id,nombre,telefono,departamento,direccion from contacto";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Contacto contacto = new Contacto(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("telefono"),
                        resultSet.getString("departamento"),
                        resultSet.getString("direccion")
                );
                contactos.add(contacto);
            }
            statement.close();
            resultSet.close();
            connection.close();
            return contactos;
        } catch (Exception e) {
        }
        return contactos;
    }

}
