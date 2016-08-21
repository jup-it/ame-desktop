/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sscc.businesslogic;

import sscc.database.access.DBConexion;

/**
 *
 * @author USUARIO
 */
public class Sector {
    int idSector;
    String descripcion;
    String estado;

    public Sector() {
    }
    
    public boolean validar(String descripcion){
        if(descripcion.length()< 5)
            return false;
        this.descripcion = descripcion;
        this.estado = "A";
        return true;
    }
    
    public boolean validarU(String descripcion, int idSectorEditado, String estado) {
        if(descripcion.length()< 5)
            return false;
        Sector existeS = buscar(descripcion);
        if(existeS != null){
            if(existeS.getIdSector() != idSectorEditado)
                return false;
        }
        this.descripcion = descripcion;
        if(estado.equals("Activo"))
            this.estado = "A";
        else
            this.estado = "I";
        this.idSector = idSectorEditado;
        return true;
    }
    
    public boolean guardar(){
        return DBConexion.guardarSector(this);
    }
    
    public boolean actualizar(){
        return DBConexion.actualizarSector(this);
    }
    
    public Sector buscar(String descripcion){
        if(!descripcion.trim().equals(""))
            return DBConexion.buscarSector(descripcion);
        return new Sector();
    }
    
    public Sector[] buscar(){
        return DBConexion.listaSectores();        
    }
    
    public Sector buscar(int idSector){
        return DBConexion.buscarSector(idSector);
    }
    
    public String[] listar(){        
        return DBConexion.buscarSectores();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    
          
}
