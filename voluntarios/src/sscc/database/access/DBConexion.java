/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sscc.database.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import sscc.businesslogic.Sector;
import sscc.businesslogic.Voluntario;

/**
 *
 * @author valquirialbr
 */
public class DBConexion {
    static Connection conexion;    
            
    public static Connection obtenerConexion(){
        if(conexion == null){
            try {
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/voluntarios", 
                    "root", 
                    "");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Conexion",JOptionPane.ERROR_MESSAGE);
            }
        }
        return conexion;
    }
    
    public static boolean existeVoluntario(String identificacion){
        try {
            String sql = "select id_voluntario from voluntarios where id_voluntario = ?";
            PreparedStatement ps = obtenerConexion().prepareStatement(sql);
            ps.setString(1, identificacion);
            ResultSet rs = ps.executeQuery();
            boolean existe = rs.next();
            rs.close();
            ps.close();
            return existe;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static Voluntario buscarVoluntario(String identificacion) {
        try {
            String sql = "select * from voluntarios where id_voluntario = ?";
            PreparedStatement ps = obtenerConexion().prepareStatement(sql);
            ps.setString(1, identificacion);
            ResultSet rs = ps.executeQuery();
            Voluntario voluntario = new Voluntario();
            if(rs.next()){
                voluntario.setIdentificacion(identificacion);
                voluntario.setNombre(rs.getString("nombre"));
                voluntario.setEsLider(rs.getString("es_lider"));
                if(rs.getDate("fecha_actualizacion") != null){
                    voluntario.setFechaActualizacion(new Date(rs.getDate("fecha_actualizacion").getTime()));
                }
                voluntario.setFechaNacimiento(new Date(rs.getDate("fecha_nacimiento").getTime()));
                voluntario.setCorreo(rs.getString("correo"));
                voluntario.setFechaIngreso(new Date(rs.getDate("fecha_ingreso").getTime()));
                voluntario.setIdSector(rs.getInt("id_sector"));
                voluntario.setTelefono(rs.getString("telefono"));
                voluntario.setSexo(rs.getString("sexo"));
                voluntario.setProfesion(rs.getString("profesion"));
                voluntario.setValidado(rs.getString("validado"));
            }
            rs.close();
            ps.close();
            return voluntario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean guardarVoluntario(Voluntario voluntario){
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String sqlInsert =
                    "INSERT INTO `voluntarios`.`voluntarios`" +
                    "(`id_voluntario`,"+
                    "`nombre`,"+
                    "`fecha_nacimiento`,"+
                    "`fecha_ingreso`,"+
                    "`id_sector`,"+
                    "`fecha_actualizacion`,"+
                    "`sexo`,"+
                    "`es_lider`,"+
                    "`correo`,"+
                    "`telefono`,"+
                    "`profesion`)"+
                    "values (";
            sqlInsert = sqlInsert + "'"+ voluntario.getIdentificacion() + "',";
            sqlInsert = sqlInsert + "'"+ voluntario.getNombre() + "',";
            sqlInsert = sqlInsert + "STR_TO_DATE('"+ df.format(voluntario.getFechaNacimiento()) + "', '%d/%m/%Y'),";
            sqlInsert = sqlInsert + "STR_TO_DATE('"+ df.format(voluntario.getFechaIngreso()) + "', '%d/%m/%Y'),";
            sqlInsert = sqlInsert + ""+ (voluntario.getIdSector()==0?"null":voluntario.getIdSector()) + ",";
            sqlInsert = sqlInsert + "null,";
            sqlInsert = sqlInsert + "'"+ voluntario.getSexo() + "',";
            sqlInsert = sqlInsert + "'"+ voluntario.getEsLider() + "',";
            sqlInsert = sqlInsert + "'"+ voluntario.getCorreo() + "',";
            sqlInsert = sqlInsert + "'" + voluntario.getTelefono() + "', ";
            sqlInsert = sqlInsert + "'" + voluntario.getProfesion() + "')";
            System.out.println("sqlInsert: " + sqlInsert);
            PreparedStatement ps = obtenerConexion().prepareStatement(sqlInsert);
            ps.executeUpdate();
            ps.close();
            
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean guardarSector(Sector sector){
        try {
            String sqlInsert = 
                    "INSERT INTO `voluntarios`.`sectores`(" +
                    "`descripcion`," +
                    "`estado`)" +
                    "values(";
            sqlInsert = sqlInsert + "'" + sector.getDescripcion() + "',";
            sqlInsert = sqlInsert + "'A'";
            sqlInsert = sqlInsert + ")";
            System.out.println("sqlInsert: " + sqlInsert);
            PreparedStatement ps = obtenerConexion().prepareStatement(sqlInsert);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean guardarAptitudes(String[] aptitudes, String idVoluntario){
        try {
            for(String aptitud : aptitudes){
                String sqlInsert = 
                        "INSERT INTO `voluntarios`.`aptitudes`(" +
                        "`id_voluntario`," +
                        "`aptitud`)" +
                        "values(";
                sqlInsert = sqlInsert + "'" + idVoluntario + "',";
                sqlInsert = sqlInsert + "'" + aptitud + "'";
                sqlInsert = sqlInsert + ")";
                System.out.println("sqlInsert: " + sqlInsert);
                PreparedStatement ps = obtenerConexion().prepareStatement(sqlInsert);
                ps.executeUpdate();
                ps.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean eliminarAptitudes(String idVoluntario){
        try {
            String sqlInsert = 
                    "delete from `voluntarios`.`aptitudes`where id_voluntario = ?";
            PreparedStatement ps = obtenerConexion().prepareStatement(sqlInsert);
            ps.setString(1, idVoluntario);
            ps.executeUpdate();
            ps.close();            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static String[] buscarAptitudes(String idVoluntario){
        try {
            String sql = "select aptitud from aptitudes where id_voluntario = ?";
            String aptitudes = "";
            PreparedStatement ps = obtenerConexion().prepareStatement(sql);
            ps.setString(1, idVoluntario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                aptitudes = aptitudes + rs.getString("aptitud") + ">";
            }
            if(aptitudes.length() > 0){
                aptitudes = aptitudes.substring(0, aptitudes.length()-1);
                return aptitudes.split(">");
            }
            return new String[0];   
        } catch (Exception e) {
            e.printStackTrace();
            return new String[0];
        }        
    }
    
    public static String[] buscarSectores(){
        try {
            String sql = "select descripcion from sectores where estado = 'A'";
            String sectores = "";
            PreparedStatement ps = obtenerConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {                
                sectores = sectores + rs.getString("descripcion") + ">";
            }
            if(sectores.length() > 0){
                sectores = sectores.substring(0, sectores.length()-1);
                return sectores.split(">");
            }
            return new String[0];   
        } catch (Exception e) {
            e.printStackTrace();
            return new String[0];
        }        
    }
    
    public static Sector buscarSector(String descripcion){
        try {
            String sql = "select * from sectores where descripcion = ?";
            Sector sector = null;
            PreparedStatement ps = obtenerConexion().prepareStatement(sql);
            ps.setString(1, descripcion);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {      
                sector = new Sector();
                sector.setIdSector(rs.getInt("id_sector"));
                sector.setDescripcion(rs.getString("descripcion"));
                sector.setEstado(rs.getString("estado"));                
            }            
            rs.close();
            ps.close();
            return sector;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Sector buscarSector(int idSector) {
        try {
            String sql = "select * from sectores where estado = 'A' and id_sector = ?";
            Sector sector = new Sector();
            PreparedStatement ps = obtenerConexion().prepareStatement(sql);
            ps.setInt(1, idSector);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                sector.setIdSector(rs.getInt("id_sector"));
                sector.setDescripcion(rs.getString("descripcion"));
                sector.setEstado(rs.getString("estado"));
            }            
            return sector;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
//    public static void main(String[] args) {
//        System.out.println(DBConexion.existeVoluntario("0924942865"));
//    }

    public static boolean actualizarVoluntario(Voluntario voluntario) {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String sqlInsert =
                    "UPDATE `voluntarios`.`voluntarios` set " +
                    "nombre = ?," +
                    "fecha_nacimiento = ?," +
                    "id_sector = ?," +
                    "fecha_actualizacion = ?," +
                    "sexo = ?," +
                    "es_lider = ?," +
                    "correo = ?," +
                    "telefono = ?," +
                    "profesion = ?," +
                    "validado = ? " +
                    "where id_voluntario = ?";
            
            PreparedStatement ps = obtenerConexion().prepareStatement(sqlInsert);
            ps.setString(1, voluntario.getNombre());
            ps.setDate(  2, new java.sql.Date(voluntario.getFechaNacimiento().getTime()));
            ps.setInt(   3, voluntario.getIdSector());
            ps.setDate(  4, new java.sql.Date(new Date().getTime()));
            ps.setString(5, voluntario.getSexo());
            ps.setString(6, voluntario.getEsLider());
            ps.setString(7, voluntario.getCorreo());
            ps.setString(8, voluntario.getTelefono());
            ps.setString(9, voluntario.getProfesion());
            ps.setString(10, voluntario.getValidado());
            ps.setString(11, voluntario.getIdentificacion());
            
            ps.executeUpdate();
            ps.close();
            
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static Voluntario[] buscarNoValidados() {
        try {
            String sql = "select * from voluntarios where validado='N'";
            PreparedStatement ps = obtenerConexion().prepareStatement(sql);
            List<Voluntario> lvoluntarios = new ArrayList<Voluntario>();
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Voluntario voluntario = new Voluntario();
                voluntario.setIdentificacion(rs.getString("id_voluntario"));
                voluntario.setNombre(rs.getString("nombre"));
                voluntario.setEsLider(rs.getString("es_lider"));
                if(rs.getDate("fecha_actualizacion") != null){
                    voluntario.setFechaActualizacion(new Date(rs.getDate("fecha_actualizacion").getTime()));
                }
                voluntario.setFechaNacimiento(new Date(rs.getDate("fecha_nacimiento").getTime()));
                voluntario.setCorreo(rs.getString("correo"));
                voluntario.setFechaIngreso(new Date(rs.getDate("fecha_ingreso").getTime()));
                voluntario.setIdSector(rs.getInt("id_sector"));
                voluntario.setTelefono(rs.getString("telefono"));
                voluntario.setSexo(rs.getString("sexo"));
                voluntario.setProfesion(rs.getString("profesion"));
                lvoluntarios.add(voluntario);
            }
            rs.close();
            ps.close();
            return lvoluntarios.toArray(new Voluntario[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Sector[] listaSectores() {
        try {
            String sql = "select * from sectores";            
            List<Sector> lSectores = new ArrayList<Sector>();
            PreparedStatement ps = obtenerConexion().prepareStatement(sql);            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Sector sector = new Sector();
                sector.setIdSector(rs.getInt("id_sector"));
                sector.setDescripcion(rs.getString("descripcion"));
                sector.setEstado(rs.getString("estado"));
                lSectores.add(sector);
            }            
            rs.close();
            ps.close();
            return lSectores.toArray(new Sector[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean actualizarSector(Sector sector) {
        try {
            String sqlInsert = 
                    "UPDATE `voluntarios`.`sectores` set " +
                    "descripcion = ?, " +
                    "estado = ? " +
                    "where id_sector = ?";
            
            PreparedStatement ps = obtenerConexion().prepareStatement(sqlInsert);
            ps.setString(1, sector.getDescripcion());
            ps.setString(2, sector.getEstado());
            ps.setInt(3, sector.getIdSector());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Voluntario[] buscarPorSector(String descripcionSector) {
        try {
            String sql = "select * from voluntarios where id_sector = ?";
            Sector sector = buscarSector(descripcionSector);
            PreparedStatement ps = obtenerConexion().prepareStatement(sql);
            ps.setInt(1, sector.getIdSector());
            List<Voluntario> lvoluntarios = new ArrayList<Voluntario>();
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Voluntario voluntario = new Voluntario();
                voluntario.setIdentificacion(rs.getString("id_voluntario"));
                voluntario.setNombre(rs.getString("nombre"));
                voluntario.setEsLider(rs.getString("es_lider"));
                if(rs.getDate("fecha_actualizacion") != null){
                    voluntario.setFechaActualizacion(new Date(rs.getDate("fecha_actualizacion").getTime()));
                }
                voluntario.setFechaNacimiento(new Date(rs.getDate("fecha_nacimiento").getTime()));
                voluntario.setCorreo(rs.getString("correo"));
                voluntario.setFechaIngreso(new Date(rs.getDate("fecha_ingreso").getTime()));
                voluntario.setIdSector(rs.getInt("id_sector"));
                voluntario.setTelefono(rs.getString("telefono"));
                voluntario.setSexo(rs.getString("sexo"));
                voluntario.setProfesion(rs.getString("profesion"));
                lvoluntarios.add(voluntario);
            }
            rs.close();
            ps.close();
            return lvoluntarios.toArray(new Voluntario[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Voluntario[] buscarPorAptitudes(Object[] aptitudes) {
        try {
            List<Voluntario> lvoluntarios = new ArrayList<Voluntario>();
            String[] voluntariosFiltrados = buscarAptitudEnVoluntario(aptitudes);
            
            for(String idVoluntario : voluntariosFiltrados){
                String sql = "select * from voluntarios where id_voluntario = ?";            
                PreparedStatement ps = obtenerConexion().prepareStatement(sql);          
                ps.setString(1, idVoluntario);
                ResultSet rs = ps.executeQuery();            
                if(rs.next()){
                    Voluntario voluntario = new Voluntario();
                    voluntario.setIdentificacion(rs.getString("id_voluntario"));
                    voluntario.setNombre(rs.getString("nombre"));
                    voluntario.setEsLider(rs.getString("es_lider"));
                    if(rs.getDate("fecha_actualizacion") != null){
                        voluntario.setFechaActualizacion(new Date(rs.getDate("fecha_actualizacion").getTime()));
                    }
                    voluntario.setFechaNacimiento(new Date(rs.getDate("fecha_nacimiento").getTime()));
                    voluntario.setCorreo(rs.getString("correo"));
                    voluntario.setFechaIngreso(new Date(rs.getDate("fecha_ingreso").getTime()));
                    voluntario.setIdSector(rs.getInt("id_sector"));
                    voluntario.setTelefono(rs.getString("telefono"));
                    voluntario.setSexo(rs.getString("sexo"));
                    voluntario.setProfesion(rs.getString("profesion"));
                    lvoluntarios.add(voluntario);
                }
                rs.close();
                ps.close();
            }
            
            return lvoluntarios.toArray(new Voluntario[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] buscarAptitudEnVoluntario(Object[] aptitudes){
        try {
            String sql = "select distinct(id_voluntario) voluntario "
                        + "from aptitudes "
                        + "where aptitud in(";
            for(int i = 0; i<aptitudes.length;i++){
                sql = sql + "'" + aptitudes[i] + "'";
                if((i + 1) < (aptitudes.length-1))
                    sql = sql + ",";
            }
            sql = sql + ")";
            PreparedStatement ps = obtenerConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<String> lvoluntarios = new ArrayList<String>();
            while(rs.next()) {
                lvoluntarios.add(rs.getString("voluntario"));
            }            
            rs.close();
            ps.close();
            return lvoluntarios.toArray(new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Voluntario[] buscarDesactualizados(String fdesde, String fhasta) {
        try {
            String sql = "select * "
                    + " from voluntarios "
                    + " where fecha_actualizacion between STR_TO_DATE(?, '%d/%m/%Y')"
                    + " and STR_TO_DATE(?, '%d/%m/%Y')";
            PreparedStatement ps = obtenerConexion().prepareStatement(sql);
            ps.setString(1, fdesde);
            ps.setString(2, fhasta);
            List<Voluntario> lvoluntarios = new ArrayList<Voluntario>();
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Voluntario voluntario = new Voluntario();
                voluntario.setIdentificacion(rs.getString("id_voluntario"));
                voluntario.setNombre(rs.getString("nombre"));
                voluntario.setEsLider(rs.getString("es_lider"));
                if(rs.getDate("fecha_actualizacion") != null){
                    voluntario.setFechaActualizacion(new Date(rs.getDate("fecha_actualizacion").getTime()));
                }
                voluntario.setFechaNacimiento(new Date(rs.getDate("fecha_nacimiento").getTime()));
                voluntario.setCorreo(rs.getString("correo"));
                voluntario.setFechaIngreso(new Date(rs.getDate("fecha_ingreso").getTime()));
                voluntario.setIdSector(rs.getInt("id_sector"));
                voluntario.setTelefono(rs.getString("telefono"));
                voluntario.setSexo(rs.getString("sexo"));
                voluntario.setProfesion(rs.getString("profesion"));
                lvoluntarios.add(voluntario);
            }
            rs.close();
            ps.close();
            return lvoluntarios.toArray(new Voluntario[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
