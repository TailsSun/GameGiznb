import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    static int[][] mas = new int[510][510];

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("Введи 3 раза по 2 координаты трёх ячеек первоначальной жизни : больше 0 меньше 50! удачи");
//
//        for (int i = 0; i <3 ; i++) {
//            try {
//                int x = Integer.parseInt(reader.readLine());
//                int y = Integer.parseInt(reader.readLine());
//            if(x<0 && x > 50 && y< 0 && y > 50){
//                System.out.println(" ай ай ай введи правильное число!!!!!!!");
//            }else{
//                mas[x][y] = 1;
//            }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        mas[25][25] = 1;
        mas[25][26] = 1;
        mas[26][25] = 1;
        mas[27][25] = 1;
        mas[28][25] = 1;
        mas[26][28] = 1;
        while(true) {

            podscetGizni(mas);
            vivod(mas);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static void podscetGizni(int[][] mas1) {

        int proverkasosedey = 0;
        for (int x = 0; x < mas1.length ; x++) {
            for (int y = 0; y < mas1.length ; y++) {

                proverkasosedey = proverkaSosedei(x,y);

                if(mas1[x][y] == 0){// если жизни нет проверяем соседей и если их 3 тогда даём новую жизнь
                   if(proverkasosedey == 3){
                       mas1[x][y] = 1;
                   }
                   if(mas1[x][y] == 1 && proverkasosedey < 2 && proverkasosedey > 3){
                        mas1[x][y] = 0;
                    }
                }


            }
        }

    }

    private static int proverkaSosedei(int x, int y) {

        int chisloGizni = 0;


        if (x == 0 & y == 0) { // проверяем верхний левый угол
            if (mas[x + 1][y] == 1) {
                chisloGizni++;
            }
            if (mas[x][y + 1] == 1) {
                chisloGizni++;
            }
            if (mas[x + 1][y + 1] == 1) {
                chisloGizni++;
            }
        }

        if (x == mas.length & y == 0) {// проверяем верхний правый угол
            if (mas[x - 1][y] == 1) {
                chisloGizni++;
            }
            if (mas[x - 1][y + 1] == 1) {
                chisloGizni++;
            }
            if (mas[x][y + 1] == 1) {
                chisloGizni++;
            }
        }

        if (x == 0 & y == mas.length) { // проверяем нижний левый угол
            if (mas[x][y - 1] == 1) {
                chisloGizni++;
            }
            if (mas[x + 1][y - 1] == 1) {
                chisloGizni++;
            }
            if (mas[x + 1][y] == 1) {
                chisloGizni++;
            }
        }

        if (x == mas.length & y == mas.length) { // проверяем правый нижний угол
            if (mas[x - 1][y] == 1) {
                chisloGizni++;
            }
            if (mas[x - 1][y - 1] == 1) {
                chisloGizni++;
            }
            if (mas[x][y - 1] == 1) {
                chisloGizni++;
            }
        }

        if (x == 0 & y > 0 & y < mas.length) { // проверяем у левой стенки
            if (mas[x][y - 1] == 1) {
                chisloGizni++;
            }
            if (mas[x + 1][y - 1] == 1) {
                chisloGizni++;
            }
            if (mas[x + 1][y] == 1) {
                chisloGizni++;
            }
            if (mas[x][y - 1] == 1) {
                chisloGizni++;
            }
            if (mas[x + 1][y - 1] == 1) {
                chisloGizni++;
            }
        }

        if (x == mas.length & y > 0 & y < mas.length) { // проверяем у правой стенки
            if (mas[x][y - 1] == 1) {
                chisloGizni++;
            }
            if (mas[x - 1][y - 1] == 1) {
                chisloGizni++;
            }
            if (mas[x - 1][y] == 1) {
                chisloGizni++;
            }
            if (mas[x - 1][y + 1] == 1) {
                chisloGizni++;
            }
            if (mas[x][y - 1] == 1) {
                chisloGizni++;
            }
        }

        if (y == 0 & x > 0 & x < mas.length-1) { // проверяем у верхней стенки
            if (mas[x + 1][y] == 1) {
                chisloGizni++;
            }
            if (mas[x - 1][y] == 1) {
                chisloGizni++;
            }
            if (mas[x - 1][y + 1] == 1) {
                chisloGizni++;
            }
            if (mas[x][y + 1] == 1) {
                chisloGizni++;
            }
            if (mas[x + 1][y + 1] == 1) {
                chisloGizni++;
            }
        }

        if (y == mas.length & x > 0 & x < mas.length) { // проверяем у нижней стенки
            if (mas[x - 1][y] == 1) {
                chisloGizni++;
            }
            if (mas[x + 1][y] == 1) {
                chisloGizni++;
            }
            if (mas[x - 1][y - 1] == 1) {
                chisloGizni++;
            }
            if (mas[x][y - 1] == 1) {
                chisloGizni++;
            }
            if (mas[x + 1][y - 1] == 1) {
                chisloGizni++;
            }
        }
               // проверка в поле где 8 клеток
        if(x > 0 && y > 0 && y < mas.length-1 && x < mas.length-1) {
            if (mas[x - 1][y - 1] == 1) {
                chisloGizni++;
            }
            if (mas[x][y - 1] == 1) {
                chisloGizni++;
            }
            if (mas[x + 1][y - 1] == 1) {
                chisloGizni++;
            }
            if (mas[x + 1][y] == 1) {
                chisloGizni++;
            }
            if (mas[x + 1][y + 1] == 1) {
                chisloGizni++;
            }
            if (mas[x][y + 1] == 1) {
                chisloGizni++;
            }
            if (mas[x - 1][y + 1] == 1) {
                chisloGizni++;
            }
            if (mas[x - 1][y] == 1) {
                chisloGizni++;
            }
        }

        return chisloGizni;
    }


    private static void vivod(int[][] a) {

        for (int x = 0; x <a.length ; x++) {
            for (int y = 0; y <a.length ; y++) {
                System.out.print(a[x][y]+ " ");
            }
            System.out.println();

        }
    }
}
