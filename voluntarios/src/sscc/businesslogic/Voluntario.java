/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sscc.businesslogic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import sscc.database.access.DBConexion;

/**
 *
 * @author valquirialbr
 */
public class Voluntario {
    private String identificacion;
    private String nombre;
    private String sexo;
    private String esLider;
    private String correo;
    private String telefono;
    private Date fechaIngreso;
    private Date fechaNacimiento;
    private Date fechaActualizacion;
    private int idSector;
    private String profesion;
    private String validado;

    public Voluntario() {
    
    }
    
    public boolean existe(String identificacion){
        if(identificacion.length() == 10)
            return DBConexion.existeVoluntario(identificacion);
        else
            return false;
    }
    
    public boolean validar( String identificacion,
                            String nombre,
                            String sexo,
                            String esLider,
                            String correo,
                            String telefono,
                            String fechaNacimiento,
                            String sector,
                            String profesion){
       DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if(identificacion.length() != 10)
            return false;
        if(nombre.length() < 10)
            return false;
        try {
            if(new Date().compareTo(df.parse(fechaNacimiento)) <= 0)
                return false;
        } catch (Exception e) {
            return false;
        }
        this.setIdentificacion(identificacion);
        this.setNombre(nombre);
        this.setCorreo(correo);
        this.setEsLider(esLider);
        this.setSexo(sexo);
        this.setFechaIngreso(new Date());
        this.setTelefono(telefono);
        try {
            this.setFechaNacimiento(df.parse(fechaNacimiento));
        } catch (Exception e) {
        }
        Sector mSector = new Sector().buscar(sector);
        if(mSector == null)
            return false;
        this.setIdSector(mSector.idSector);
        this.setProfesion(profesion);
        return true;
    }
    
    public boolean guardar(){
        return DBConexion.guardarVoluntario(this);
    }
    
    public boolean actualizar(){
        return DBConexion.actualizarVoluntario(this);
    }
    
    public Voluntario buscar(String identificacion){
        return DBConexion.buscarVoluntario(identificacion);
    }

    public Voluntario[] buscarNoValidados(){
        return DBConexion.buscarNoValidados();
    }
    
    public Voluntario[] buscarPorSector(String sector) {
        return DBConexion.buscarPorSector(sector);
    }
    
    public Voluntario[] buscarPorAptitudes(Object[] aptitudes) {
        return DBConexion.buscarPorAptitudes(aptitudes);
    }
    
    public Voluntario[] buscarDesactualizados(String fdesde, String fhasta) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            sdf.parse(fdesde);
            sdf.parse(fhasta);
            return DBConexion.buscarDesactualizados(fdesde,fhasta);
        } catch (Exception e) {
            return new Voluntario[0];
        }
        
    }
    
    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEsLider() {
        return esLider;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public int getIdSector() {
        return idSector;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEsLider(String esLider) {
        this.esLider = esLider;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getValidado() {
        return validado;
    }

    public void setValidado(String validado) {
        this.validado = validado;
    }

    

    

    
       
    
}
