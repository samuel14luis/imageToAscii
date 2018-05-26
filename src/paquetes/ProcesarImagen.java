/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Alisoft / Samuel Luis Mendoza
 */
public class ProcesarImagen {

    public static BufferedImage imageToIntputStream(String ruta) {
        try {
            InputStream input = new FileInputStream(ruta);
            ImageInputStream imageInput = ImageIO.createImageInputStream(input);
            BufferedImage imagenL = ImageIO.read(imageInput);
            return imagenL;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void recorrerImagen(String ruta_imagen) {
        recorrerImagen(imageToIntputStream(ruta_imagen));
    }

    public static void recorrerImagen(BufferedImage imagen) {
        int alto = imagen.getHeight();
        int ancho = imagen.getWidth();

        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                int srcPixel = imagen.getRGB(x, y);

                Color _color = new Color(srcPixel);

                int r = _color.getRed();
                int g = _color.getGreen();
                int b = _color.getBlue();

                System.out.print(interpretarRBGToAscii(r, g, b));

                if (x % 10 == 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProcesarImagen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            System.out.print("\n");
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProcesarImagen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static String interpretarRBGToAscii(int r, int g, int b) {
        /*
        Color:	Negro	Gris oscuro	Gris	Gris claro	Blanco
            R	0	51		102	153		204         255
            G 	0	51		102	153		204         255
            B	0	51		102	153		204         255
        	█	▓		▒	░		‗
          ascii	219	178		177	176		242	
         */
        int _ancho[] = {51, 51, 51, 51, 51};
        int carry[]
                = {
                    0,
                    _ancho[0],
                    _ancho[0] + _ancho[1],
                    _ancho[0] + _ancho[1] + _ancho[2],
                    _ancho[0] + _ancho[1] + _ancho[2] + _ancho[3],
                    _ancho[0] + _ancho[1] + _ancho[2] + _ancho[3] + _ancho[4]
                };

        if (isXYZEntreAyB(r, g, b, 0, carry[1])) {
            //es negro
            return "█";

        } else if (isXYZEntreAyB(r, g, b, carry[1] + 1, carry[2])) {
            //es gris oscuro
            return "▓";

        } else if (isXYZEntreAyB(r, g, b, carry[2] + 1, carry[3])) {
            //es gris
            return "▒";

        } else if (isXYZEntreAyB(r, g, b, carry[3] + 1, carry[4])) {
            //es gris claro
            return "░";

        } else if (isXYZEntreAyB(r, g, b, carry[4] + 1, carry[5])) {
            //es blanco
            return "░";

        } else {
            //devolver blanco, por si las dudas xd
            return "  ";

        }

        /*
        //FORMA ESTANDAR
        
        if (isXEntreAyB(r,0,51) && isXEntreAyB(g,0,51) && isXEntreAyB(b,0,51)) {
            //es negro
            
        } else if (isXEntreAyB(r,52,102) && isXEntreAyB(g,52,102) && isXEntreAyB(b,52,102)) {
            //es gris oscuro
            
        } else if (isXEntreAyB(r,103,153) && isXEntreAyB(g,103,153) && isXEntreAyB(b,103,153)) {
            //es gris
            
        } else if (isXEntreAyB(r,154,204) && isXEntreAyB(g,154,204) && isXEntreAyB(b,154,204)) {
            //es gris claro
            
        } else if (isXEntreAyB(r,205,255) && isXEntreAyB(g,205,255) && isXEntreAyB(b,205,255)) {
            //es blanco
        
        }*/
    }

    public static boolean isXEntreAyB(int x, int a, int b) {
        return b >= x && x >= a;
    }

    public static boolean isXYZEntreAyB(int x, int y, int z, int a, int b) {
        return isXEntreAyB(x, a, b) && isXEntreAyB(y, a, b) && isXEntreAyB(z, a, b);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    public static void recorrerImagen2(String ruta, boolean lento) {
        BufferedImage imagen = imageToIntputStream(ruta);
        int alto = imagen.getHeight();
        int ancho = imagen.getWidth();

        if (lento) {
            for (int y = 0; y < alto; y++) {
                for (int x = 0; x < ancho; x++) {
                    int srcPixel = imagen.getRGB(x, y);

                    Color _color = new Color(srcPixel);

                    int r = _color.getRed();
                    int g = _color.getGreen();
                    int b = _color.getBlue();

                    System.out.print(interpretarRBGToAscii2(r, g, b));

                    if (x % 10 == 0) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProcesarImagen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                System.out.print("\n");
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProcesarImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            for (int y = 0; y < alto; y++) {
                for (int x = 0; x < ancho; x++) {
                    int srcPixel = imagen.getRGB(x, y);

                    Color _color = new Color(srcPixel);

                    int r = _color.getRed();
                    int g = _color.getGreen();
                    int b = _color.getBlue();

                    System.out.print(interpretarRBGToAscii2(r, g, b));
                }
                System.out.print("\n");
            }
        }

    }

    public static String interpretarRBGToAscii2(int r, int g, int b) {
        /*
        Color:	Negro	Gris oscuro	Gris	Gris claro	Blanco
            R	0	51		102	153		204         255
            G 	0	51		102	153		204         255
            B	0	51		102	153		204         255
        	█	▓		▒	░		‗
          ascii	219	178		177	176		242	
         */
        int _ancho[] = {30, 31, 62, 61, 71};
        int carry[]
                = {
                    0,
                    _ancho[0],
                    _ancho[0] + _ancho[1],
                    _ancho[0] + _ancho[1] + _ancho[2],
                    _ancho[0] + _ancho[1] + _ancho[2] + _ancho[3],
                    _ancho[0] + _ancho[1] + _ancho[2] + _ancho[3] + _ancho[4]
                };

        if (isXYZEntreAyB(r, g, b, 0, carry[1])) {
            //es negro
            return "█";

        } else if (isXYZEntreAyB(r, g, b, carry[1] + 1, carry[2])) {
            //es gris oscuro
            return "▓";

        } else if (isXYZEntreAyB(r, g, b, carry[2] + 1, carry[3])) {
            //es gris
            return "▒";

        } else if (isXYZEntreAyB(r, g, b, carry[3] + 1, carry[4])) {
            //es gris claro
            return "░";

        } else if (isXYZEntreAyB(r, g, b, carry[4] + 1, carry[5])) {
            //es blanco
            return "░";

        } else {
            //devolver blanco, por si las dudas xd
            return "░";

        }

        /*
        //FORMA ESTANDAR
        
        if (isXEntreAyB(r,0,51) && isXEntreAyB(g,0,51) && isXEntreAyB(b,0,51)) {
            //es negro
            
        } else if (isXEntreAyB(r,52,102) && isXEntreAyB(g,52,102) && isXEntreAyB(b,52,102)) {
            //es gris oscuro
            
        } else if (isXEntreAyB(r,103,153) && isXEntreAyB(g,103,153) && isXEntreAyB(b,103,153)) {
            //es gris
            
        } else if (isXEntreAyB(r,154,204) && isXEntreAyB(g,154,204) && isXEntreAyB(b,154,204)) {
            //es gris claro
            
        } else if (isXEntreAyB(r,205,255) && isXEntreAyB(g,205,255) && isXEntreAyB(b,205,255)) {
            //es blanco
        
        }*/
    }

}
