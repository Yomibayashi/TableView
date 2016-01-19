package test;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Contacto {

    private SimpleIntegerProperty id;
    private SimpleStringProperty nombre;
    private SimpleStringProperty telefono;
    private SimpleStringProperty departamento;
    private SimpleStringProperty direccion;

    public Contacto(int id, String nombre, String telefono, String departamento, String direccion) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.telefono = new SimpleStringProperty(telefono);
        this.departamento = new SimpleStringProperty(departamento);
        this.direccion = new SimpleStringProperty(direccion);
    }

    public Contacto() {
        this.id = new SimpleIntegerProperty();
        this.nombre = new SimpleStringProperty();
        this.telefono = new SimpleStringProperty();
        this.departamento = new SimpleStringProperty();
        this.direccion = new SimpleStringProperty();
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer v) {
        id.set(v);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String v) {
        nombre.set(v);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String v) {
        telefono.set(v);
    }

    public String getDepartamento() {
        return departamento.get();
    }

    public void setDepartamento(String v) {
        departamento.set(v);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String v) {
        direccion.set(v);
    }

}
