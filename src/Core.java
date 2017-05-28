/**
 * Created by DNS on 27.05.2017.
 */
import Display.Displey;

import java.awt.*;

public class Core {
private static boolean title;
    public static void draw(int[][] map, int width, int high, int length){

        if (!title){
            setTitle(width, high, length);
        }

        Displey.clear();
        Graphics2D graf = Displey.getGraphics();

        graf.setColor(Color.PINK);
        for (int y = 0; y < high ; y++) {
            for (int x = 0; x < width ; x++) {
                if (map[x][y] == 1){
                    graf.fillRect(x * length,y * length, length,length);
                }
            }
        }

        Displey.swapBuffers();
    }
    private static void setTitle(int width, int high, int lenght){
        Displey.create(width * lenght,high * lenght,"myTestGame",0xff000000,3);
        title = true;
    }


}
