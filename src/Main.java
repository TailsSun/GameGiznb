public class Main {
    private static final int PERCENT_FO_CREATE_LIFE = 15;
    private static final double PERCENT_TO_CHENGE_LIFE = 0.00;

    static int width = 1366;
    static int high = 768;
    static int lenght = 1;
    static int[][] mapLive = new int[width][high];

    public static void main(String[] args) {
        for (int y = 0; y < high; y++) {
            for (int x = 0; x < width; x++) {
                final double rnd = Math.random() * 100;
                if (rnd < PERCENT_FO_CREATE_LIFE) {
                    mapLive[x][y] = 1;
                }
            }
        }

        while (true) {
            Draw.draw(mapLive, width, high, lenght);
            mapLive = stageEvolution();
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    private static int[][] stageEvolution() {


        int[][] tmpMap = new int[width][high];
        for (int y = 0; y < high; y++) {
            for (int x = 0; x < width; x++) {

                int NumberLlivingCells = SearchLiveAround(x, y);
                if (NumberLlivingCells == 3) {
                    tmpMap[x][y] = 1;
                }
                if (mapLive[x][y] == 1) {
                    if (NumberLlivingCells == 2) {
                        tmpMap[x][y] = 1;
                        double rnd = Math.random() * 100;
                        if (rnd < PERCENT_TO_CHENGE_LIFE) {
                            mapLive[x][y] = 0;
                        }
                    }
                    if (NumberLlivingCells < 2 || NumberLlivingCells > 3) {
                        tmpMap[x][y] = 0;
                    }
                }
            }
        }
        return tmpMap;
    }

    private static int SearchLiveAround(int x, int y) {

        int NumberLlivingCells = 0;


        if (x == 0 & y == 0) { // проверяем верхний левый угол
            if (mapLive[x + 1][y] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x][y + 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x + 1][y + 1] == 1) {
                NumberLlivingCells++;
            }
        }

        if (x == width - 1 & y == 0) {// проверяем верхний правый угол
            if (mapLive[x - 1][y] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x - 1][y + 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x][y + 1] == 1) {
                NumberLlivingCells++;
            }
        }

        if (x == 0 & y == high - 1) { // проверяем нижний левый угол
            if (mapLive[x][y - 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x + 1][y - 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x + 1][y] == 1) {
                NumberLlivingCells++;
            }
        }

        if (x == width - 1 & y == high - 1) { // проверяем правый нижний угол
            if (mapLive[x - 1][y] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x - 1][y - 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x][y - 1] == 1) {
                NumberLlivingCells++;
            }
        }

        if (x == 0 & y > 0 & y < high - 1) { // проверяем у левой стенки
            if (mapLive[x][y - 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x + 1][y - 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x + 1][y] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x][y - 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x + 1][y - 1] == 1) {
                NumberLlivingCells++;
            }
        }

        if (x == width - 1 & y > 0 & y < high - 1) { // проверяем у правой стенки
            if (mapLive[x][y - 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x - 1][y - 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x - 1][y] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x - 1][y + 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x][y - 1] == 1) {
                NumberLlivingCells++;
            }
        }

        if (y == 0 & x > 0 & x < width - 1) { // проверяем у верхней стенки
            if (mapLive[x + 1][y] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x - 1][y] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x - 1][y + 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x][y + 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x + 1][y + 1] == 1) {
                NumberLlivingCells++;
            }
        }

        if (y == high - 1 & x > 0 & x < width - 1) { // проверяем у нижней стенки
            if (mapLive[x - 1][y] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x + 1][y] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x - 1][y - 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x][y - 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x + 1][y - 1] == 1) {
                NumberLlivingCells++;
            }
        }
        // проверка в поле где 8 клеток
        if (x > 0 && y > 0 && y < high - 1 && x < width - 1) {
            if (mapLive[x - 1][y - 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x][y - 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x + 1][y - 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x + 1][y] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x + 1][y + 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x][y + 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x - 1][y + 1] == 1) {
                NumberLlivingCells++;
            }
            if (mapLive[x - 1][y] == 1) {
                NumberLlivingCells++;
            }
        }
        return NumberLlivingCells;
    }


    private static void printToConsole(int[][] a) {

        for (int x = 0; x < a.length; x++) {
            for (int y = 0; y < a.length; y++) {
                System.out.print(a[y][x] + " ");
            }
            System.out.println();

        }
    }
}
