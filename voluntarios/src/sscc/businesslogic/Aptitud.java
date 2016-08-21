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
public class Aptitud {
    
    public boolean guardar(String[] aptitudes, String idVoluntario){
        return DBConexion.guardarAptitudes(aptitudes, idVoluntario);
    }
    
    public boolean eliminar(String idVoluntario){
        return DBConexion.eliminarAptitudes(idVoluntario);
    }
    
    public String[] buscar(String idVoluntario){
        return DBConexion.buscarAptitudes(idVoluntario);
    }
}
