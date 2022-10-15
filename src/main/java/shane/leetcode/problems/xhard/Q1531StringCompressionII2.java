package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my idea
 */
public class Q1531StringCompressionII2 {

    @Test
    public void test() {
        assertThat(getLengthOfOptimalCompression("cbaabcabcacabacaccc", 5)).isEqualTo(10);
        assertThat(getLengthOfOptimalCompression("cacbbacadb", 7)).isEqualTo(2);
        assertThat(getLengthOfOptimalCompression("babbab", 5)).isEqualTo(1);
        assertThat(getLengthOfOptimalCompression("llllllllllttttttttt", 1)).isEqualTo(4);
        assertThat(getLengthOfOptimalCompression("abc", 0)).isEqualTo(3);
        assertThat(getLengthOfOptimalCompression("a", 1)).isEqualTo(0);
        assertThat(getLengthOfOptimalCompression("abc", 2)).isEqualTo(1);
        assertThat(getLengthOfOptimalCompression("aabbaa", 2)).isEqualTo(2);
        assertThat(getLengthOfOptimalCompression("aaabcccd", 2)).isEqualTo(4);
        assertThat(getLengthOfOptimalCompression("aaaaaaaaaaa", 0)).isEqualTo(3);
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        final int LENGTH = s.length();
        int[][] dp = new int[LENGTH + 1][LENGTH + 1];
        for (int i = 0; i <= LENGTH; i++) {
            for (int j = 0; j <= LENGTH; j++) {
                dp[i][j] = 10_000;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= LENGTH; i++) {
            for (int j = 0; j <= k; j++) {
                int cnt = 0;
                int del = 0;
                for (int l = i; l > 0; l--) {
                    if (s.charAt(l - 1) == s.charAt(i - 1)) {
                        cnt++;
                    } else {
                        del++;
                    }
                    if (j - del >= 0)
                        dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - del] + 1 + (cnt > 1 ? (int) Math.log10(cnt) + 1 : 0));
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[LENGTH][k];
    }

}
