package DataStructure.Recursion;

import java.util.Arrays;

public class SudokuSolver {

    public static void main(String[] args) {
        char[][] sudoku = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        solve(sudoku);
        printSudoku(sudoku);
    }


    public static boolean solve(char[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(sudoku[i][j] == '.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(sudoku,c,i,j)){
                            sudoku[i][j] = c;
                            if(solve(sudoku)){
                                return true;
                            }else{
                                sudoku[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] sudoku,char c,int row,int col){
        for(int i=0;i<9;i++){
                //check if we have the number c in any of the rows
                if(sudoku[i][col] == c) return false;
                //check if we have the number c in any of the columns
                if(sudoku[row][i] == c) return false;
            /**
             * This is for the 3 x 3 box check we can create the row and column using the following formulas
             * consider you found (5,7) empty, so how can you find which 3 x3 block it belongs to simple 5/3 = 1 & 7/3 = 2 this signifies that
             * you are in the 1th 3x3 block and 2nd 3x3 block, you can multiply it with 3 and get (1,2) => (3,6) so it's the 3rd row and 6th column
             * now how to get trace the other remaining blocks, i is iterating from 0 till 9 we can use it
             * row (3) will remain consistent while column will increase twice(6 to 7,8) then row(4) increments and column will be(6 to 7,8)
             * we can use i/3 for rows and i % 3 operations for column
             */

                int r = 3 * (row/3) + i/3;
                int cl = 3 * (col/3)+ i%3;
                if(sudoku[r][cl] == c) return false;
            }
        return true;
    }

    public static void printSudoku(char[][] sudoku){
        for(char[] ch:sudoku){
            System.out.println(Arrays.toString(ch));
        }
    }

}

/*
1ms solution from Singapore Prime Minister

class Solution {
    static final int ALL_ZEROS = 0;
    static final int ALL_ONES = 0x3fe;
    int[] row_bitmap, col_bitmap, cube_bitmap, entry, sequence;
    // Always points to the first empty cell's SQUARE index, which is stored in SEQUENCE
    int seq_start;
    // Utility arrays to store mapping from SQUARE to ROW/COLs/CUBES: e.g. 37 -> cube[1, 0], whose 1D index is 3;
    int[] square_to_row, square_to_col, square_to_cube;

    public void solveSudoku(char[][] board) {
        seq_start = 0;
        row_bitmap = new int[9];
        col_bitmap = new int[9];
        cube_bitmap = new int[9];
        entry =  new int[81];
        sequence =  new int[81];
        square_to_row =  new int[81];
        square_to_col =  new int[81];
        square_to_cube = new int[81];
        // Initialize all helping data structures
        // All digits are initially all available (marked by 1) in all rows/columns/cubes
        for (int i = 0; i < 9; i++)
            row_bitmap[i] = col_bitmap[i] = cube_bitmap[i] = ALL_ONES;
        // Sequence stores all SQUARE indices of all cells, with 0..start-1 being all filled cells, and the rest all empty
        // All cells initially all empty
        for (int i = 0; i < 81; i++)
            sequence[i] = i;
        for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++) {
            // Mapping from SQUARE to I/J is also beneficial: avoid calculating I/J from SQUARE later
            int square = i * 9 + j;
            square_to_row[square] = i;
            square_to_col[square] = j;
            square_to_cube[square] = (i / 3) * 3 + j / 3;
        }
        // Fill in the given cells. Update the bitmaps at the same time
        for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++) if (board[i][j] != '.') {
            int square = i * 9 + j, val = board[i][j] - '0', valbit = 1 << val;
            row_bitmap[i] &= ~valbit;
            col_bitmap[j] &= ~valbit;
            cube_bitmap[(i / 3) * 3 + j / 3] &= ~valbit;
            entry[square] = valbit;
            int seq_iter = seq_start;
            // Compact non-empty cells to the front, and use SEQ_START to mark the first empty cell's position
            while (seq_iter < 81 && sequence[seq_iter] != square)
                seq_iter++;
            swapSeq (seq_start++, seq_iter);
        }
        // main solver process
        boolean success = place (seq_start);
        assert success : "Unsolvable Puzzle!";
        // dump result back from ENTRY array to BOARD
        for (int s = 0; s < 81; s++) {
            int i = square_to_row[s], j = square_to_col[s];
            board[i][j] = (char) (Integer.numberOfTrailingZeros (entry[s]) + '0');
        }
    }

    boolean place (int seq_pos) {
        if (seq_pos >= 81)
            return true;
        int seq_next = nextPos (seq_pos);
        swapSeq (seq_pos, seq_next);
        int square = sequence[seq_pos], row_idx = square_to_row[square], col_idx = square_to_col[square], cube_idx = square_to_cube[square];
        int cell_bitmap = row_bitmap[row_idx] & col_bitmap[col_idx] & cube_bitmap[cube_idx];
        while (cell_bitmap > 0) {
            // Get each available bit/digit in order
            int next_digit_bit = cell_bitmap & -cell_bitmap;
            cell_bitmap &= ~next_digit_bit;
            entry[square] = next_digit_bit;
            // claim this DIGIT is used in row/column/cube
            row_bitmap[row_idx] &= ~next_digit_bit;
            col_bitmap[col_idx] &= ~next_digit_bit;
            cube_bitmap[cube_idx] &= ~next_digit_bit;

            if (place (seq_pos + 1))
                return true;

            // undo claims in the bitmaps
            row_bitmap[row_idx] |= next_digit_bit;
            col_bitmap[col_idx] |= next_digit_bit;
            cube_bitmap[cube_idx] |= next_digit_bit;
            entry[square] = ALL_ZEROS;
        }
        swapSeq (seq_pos, seq_next);
        return false;
    }

    // Find among empty cells the one with the smallest search space: least bits on its bitmap;
    int nextPos (int pos) {
        int min_idx = pos, min_digit_count = 100;
        for (int i = pos; i < 81; i++) {
            int square = sequence[i];
            // Number of bits in CELL_BITMAP is the number of digits that this cell can take
            int cell_bitmap = row_bitmap[square_to_row[square]] & col_bitmap[square_to_col[square]] & cube_bitmap[square_to_cube[square]];
            // Counts the bits, so you know how many digits this CELL can take: we want the minimum one
            int num_possible_digits = Integer.bitCount (cell_bitmap);
            if (num_possible_digits < min_digit_count) {
                min_idx = i;
                min_digit_count = num_possible_digits;
            }
        }
        return min_idx;
    }

    void swapSeq (int i, int j) {
        int tmp = sequence[i];
        sequence[i] = sequence[j];
        sequence[j] = tmp;
    }
}

comment
To understand this algorithm, you first have to understand the common usage of bitmasks. If we have a bitmap, which is initialized to 11..11, each bit representing something (as define d by you) being available, then there are some common operations regarding a bitmask of the format 0..010..0 (there can be multiple 1 bits):

allocate: bitmap &= ~bitmask: which clear out in bitmap all bits corresponding to 1 bits in bitmask.
deallocate: bitmap |= bitmask, which set back those bits mentioned above.
Hopefully you can gain some insights now for this algorithm. The powerful parts of this algorithm are:

bit operation: row_bitmap[i] is a bitmap that marks the digit (0 to 9) availability of a row i, and col_bitmap, cube_bitmap similarly. For example: row_bitmap[1] = 1101101110 means that only digits 4, 7 are unavailable from row 1 now (not including 0).
The nice thing about this is, when you have all these, you can calculate the search space for any entry! Suppose you are now at board[i][j] (which in the algorithm is represented by a 1-D index square), then the cell_bitmap as calculated in the code above (& together) represents the available digits for entry [i][j]. We can then use bitmap & -bitmap trick to extract out the last bit, indicating our intent to use it (thus making it unavailable/allocated) now, and then we clear out this bit from the cell_bitmap with the allocate operation discussed above.
Note that this style of bit manipulation is actually well-known and frequently used in the study of 8Quees problem.
Priority: There was another solution that more or less used such a concept of priority as well. The basic idea is, you want to search the entry with less options (smaller search space) first. This is based on some theory in constraint processing which I don't feel confident in explaining here. Intuitively, you want to search the most constrained variable (a variable ordering heuristic) first to make the search tree generally smaller.
This prioritization is implemented here with linear search: all empty cells' 1D indices (square) are stored in the array sequence. We move from left to right, at each iteration find the most constrained cell by a linear scan, then swap it to the front, find a digit for it, then move on. I tried to implement this with Priority Queue, but it does not seem so feasible: PQ only adjusts its order during get/set operations, while during solving, we sometimes fill a cell, ending up changing the priorities (indicated by the number of available digits) of other cells: but the PQ is not aware of that, meaning it will maintain the wrong or at least not-really-useful order.
Pre-calculation: the array square_to_row (and two other similar arrays) is simply a utility to store the mapping from the 1D index of a cell, square, to the corresponding row_idx (or col_idx, cube_idx). Since we are storing all values in the array entry, most of the time we are dealing with the 1D index square, which also makes backtracking argument passing easier. We would occasionally need to convert 1D index back to 2D, and storing these calculations' mappings is just some trick to trade space for time.

 */

