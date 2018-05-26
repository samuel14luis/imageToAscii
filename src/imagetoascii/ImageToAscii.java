/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagetoascii;

/**
 *
 * @author Alisoft / Samuel Luis Mendoza
 */
public class ImageToAscii {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("220 entre 10 y 20: " + paquetes.ProcesarImagen.isXEntreAyB(5, 10, 20));
        paquetes.ProcesarImagen.recorrerImagen2("src/img/imagen7.jpg", true);
        //paquetes.ProcesarImagen.recorrerImagen2("src/img/imagen7.png", true);
        //paquetes.ProcesarImagen.recorrerImagen2("src/img/imagen5.jpeg", true);
        //paquetes.ProcesarImagen.recorrerImagen2("src/img/azul.jpg", true);
        
        //paquetes.ProcesarImagen.recorrerImagen2("src/img/mao2.png", true);
        //paquetes.ProcesarImagen.recorrerImagen2("src/img/ella.jpg", true);
        
        //196px de alto
    }
    
}
