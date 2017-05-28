public class Main {
    private static final int PERCENT_FO_CREATE_LIFE = 5;
    private static final double PERCENT_TO_CHENGE_LIFE = 0.02;

    static int width = 800;
    static int high = 600;
    static int lenght = 1;
    static int[][] mas = new int[width][high];

    public static void main(String[] args) {

        mas[2][1] = 1;
        mas[3][2] = 1;
        mas[1][3] = 1;
        mas[2][3] = 1;
        mas[3][3] = 1;


        mas[25][25] = 1;
        mas[25][26] = 1;
        mas[26][25] = 1;
        mas[27][25] = 1;
        mas[28][25] = 1;
        mas[26][28] = 1;

        for (int y = 0; y < high; y++) {
            for (int x = 0; x < width; x++) {
                final double rnd = Math.random() * 100;
                if (rnd < PERCENT_FO_CREATE_LIFE) {
                    mas[x][y] = 1;
                }
            }
        }


        while (true) {


            Core.draw(mas, width, high, lenght);

//            vivod(mas);
            mas = podscetGizni(mas);


//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    private static int[][] podscetGizni(int[][] mas1) {


        int[][] tmpmass = new int[width][high];
        for (int y = 0; y < high; y++) {
            for (int x = 0; x < width; x++) {

                int proverkasosedey = proverkaSosedei(x, y);
                if (proverkasosedey == 3) {
                    tmpmass[x][y] = 1;
                }
                if (mas1[x][y] == 1) {
                    if (proverkasosedey == 2) {
                        tmpmass[x][y] = 1;
                        double rnd = Math.random() * 100;
                        if (rnd < PERCENT_TO_CHENGE_LIFE) {
                            mas[x][y] = 0;
                        }
                    }
                    if (proverkasosedey < 2 || proverkasosedey > 3) {
                        tmpmass[x][y] = 0;
                    }
                }
            }
        }
        return tmpmass;
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

        if (x == width - 1 & y == 0) {// проверяем верхний правый угол
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

        if (x == 0 & y == high - 1) { // проверяем нижний левый угол
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

        if (x == width - 1 & y == high - 1) { // проверяем правый нижний угол
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

        if (x == 0 & y > 0 & y < high - 1) { // проверяем у левой стенки
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

        if (x == width - 1 & y > 0 & y < high - 1) { // проверяем у правой стенки
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

        if (y == 0 & x > 0 & x < width - 1) { // проверяем у верхней стенки
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

        if (y == high - 1 & x > 0 & x < width - 1) { // проверяем у нижней стенки
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
        if (x > 0 && y > 0 && y < high - 1 && x < width - 1) {
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

        for (int x = 0; x < a.length; x++) {
            for (int y = 0; y < a.length; y++) {
                System.out.print(a[y][x] + " ");
            }
            System.out.println();

        }
    }
}
