package demo;

public class PrintTriangle {

    private void print(int row) {
        int column = 1+2*(row-1);

        for (int i=1; i<=row; i++) {
            int starCount = 1+2*(i-1);
            int emptyCount = column - starCount;

            for (int j=0; j<emptyCount/2; j++) {
                System.out.print(' ');
            }

            for (int j=0; j<starCount; j++) {
                System.out.print('*');
            }

            for (int j=0; j<emptyCount/2; j++) {
                System.out.print(' ');
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        PrintTriangle printTriangle = new PrintTriangle();
        printTriangle.print(5);
    }
}
