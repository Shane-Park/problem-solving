package shane.leetcode.contest.weekly.w303;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        assertThat(equalPairs(STool.convertToIntArray("[[3,2,1],[1,7,6],[2,7,7]]"))).isEqualTo(1);
        assertThat(equalPairs(STool.convertToIntArray("[[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]"))).isEqualTo(3);
        assertThat(equalPairs(STool.convertToIntArray("[[1]]"))).isEqualTo(1);
    }

    public int equalPairs(int[][] grid) {
        int LENGTH = grid.length;
        int cnt = 0;
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (same(grid, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean same(int[][] grid, int row, int col) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
        }
        return true;
    }

}