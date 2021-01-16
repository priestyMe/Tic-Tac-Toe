class Main {
    public static void main(String[] args) {
        // put your code here

        char[][] grid = new char[3][3];

        grid[0][0] = O;
        grid[0][1] = X;
        grid[0][2] = X;
        grid[1][0] = O;
        grid[1][1] = X;
        grid[1][2] = O;
        grid[2][0] = X;
        grid[2][1] = O;
        grid[2][2] = X;


        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid.length; j++) {

                System.out.print(grid[i][j]);
            }

            System.out.println();

        }


    }
}