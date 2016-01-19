package tableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class ContactosController implements Initializable {

    @FXML
    ImageView img;

    @FXML
    TableView<Contacto> tableContacto;
    @FXML
    TableColumn<Contacto, Integer> colId;
    @FXML
    TableColumn<Contacto, String> colNombre;
    @FXML
    TableColumn<Contacto, String> colTelefono;
    @FXML
    TableColumn<Contacto, String> colDepartamento;
    @FXML
    TableColumn<Contacto, String> colDireccion;

    @FXML
    TextField textNombre;
    @FXML
    TextField textTelefono;
    @FXML
    ComboBox cboDepartamento;
    @FXML
    TextField textDireccion;

    ObservableList<Contacto> dataContacto;
    
    ContactoDAO dao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao = new ContactoDAO();
        colId.setCellValueFactory(new PropertyValueFactory<Contacto, Integer>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Contacto, String>("nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<Contacto, String>("telefono"));
        colDepartamento.setCellValueFactory(new PropertyValueFactory<Contacto, String>("departamento"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<Contacto, String>("direccion"));
        dataContacto = FXCollections.observableArrayList(dao.listarContactos());
        tableContacto.setItems(dataContacto);
        cboDepartamento.setItems(FXCollections.observableArrayList("Lima", "Cajamarca", "Piura", "Arequipa"));
    }

    @FXML
    public void agregarContacto(ActionEvent event) {
        try {
            Contacto contacto = new Contacto();
            contacto.setNombre(textNombre.getText());
            contacto.setTelefono(textTelefono.getText());
            contacto.setDepartamento((String)cboDepartamento.getValue());
            contacto.setDireccion(textDireccion.getText());
            dao.registrarContacto(contacto);
            dataContacto = FXCollections.observableArrayList(dao.listarContactos());
            tableContacto.setItems(dataContacto);
            textNombre.setText("");
            textTelefono.setText("");
            textDireccion.setText("");
        } catch (Exception e) {
            System.out.println("Error al Registrar");
        }

    }

}
