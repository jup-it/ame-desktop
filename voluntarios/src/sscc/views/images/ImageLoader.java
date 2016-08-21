/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sscc.views.images;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author USUARIO
 */
public class ImageLoader {
    public static Image obtenerImagen(String nombre){
        System.out.println("logo " + ImageLoader.class.getResource(nombre).getFile());
        return Toolkit.getDefaultToolkit().getImage(ImageLoader.class.getResource(nombre));
    }
}
