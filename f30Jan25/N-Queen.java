https://www.geeksforgeeks.org/problems/n-queen-problem0315/1



class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private int[] row = new int[10];

    // Function to check if it is safe to place a queen at position (r, c)
    private boolean place(int r, int c) {
        for (int prev = 0; prev < c; prev++) {
            // Check if there is any queen already present in the same row or same
            // diagonal
            if (row[prev] == r || Math.abs(row[prev] - r) == Math.abs(prev - c))
                return false;
        }
        return true;
    }

    // Backtracking function to find all possible solutions
    private void bt(int c, int n) {
        // No solutions possible for n = 2 or n = 3
        if (n == 2 || n == 3) return;
        if (c == n) {
            ArrayList<Integer> v = new ArrayList<>();
            for (int i = 0; i < n; i++)
                // Storing the positions of queens in the current solution
                v.add(row[i] + 1);
            result.add(v);
        }

        for (int i = 0; i < n; i++) {
            if (place(i, c)) {
                // Placing the queen at position (i, c)
                row[c] = i;

                // Recursively solving for the next column
                bt(c + 1, n);
            }
        }
    }

    // Function to solve the N-Queen problem
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        result.clear();
        bt(0, n);
        return result;
    }
}