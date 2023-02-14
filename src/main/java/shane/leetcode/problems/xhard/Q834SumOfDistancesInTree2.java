package shane.leetcode.problems.xhard;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE when n is 10000
 */
public class Q834SumOfDistancesInTree2 {

    @Test
    public void test() {
        assertThat(sumOfDistancesInTree(6, Ps.intArray("[[0,1],[0,2],[2,3],[2,4],[2,5]]")))
                .isEqualTo(new int[]{8, 12, 6, 10, 10, 10});
        assertThat(sumOfDistancesInTree(1, Ps.intArray("[]")))
                .isEqualTo(new int[]{0});
        assertThat(sumOfDistancesInTree(2, Ps.intArray("[[1,0]]")))
                .isEqualTo(new int[]{1, 1});
    }

    /**
     * 582 ms
     */
    @Test
    public void tle() {
        assertThat(sumOfDistancesInTree(200, Ps.intArray("[[107,95],[167,65],[104,171],[169,174],[139,183],[171,8],[128,130],[195,46],[95,86],[66,34],[174,17],[84,81],[75,47],[83,184],[67,11],[69,156],[112,119],[105,49],[26,15],[157,137],[157,60],[95,117],[15,1],[16,95],[165,109],[199,44],[29,90],[113,85],[52,49],[156,71],[1,76],[139,95],[140,49],[141,30],[81,179],[154,110],[144,191],[98,108],[116,173],[100,91],[178,120],[32,79],[165,39],[179,97],[190,10],[35,85],[142,45],[14,95],[39,150],[29,138],[189,85],[186,99],[149,128],[118,97],[1,66],[83,17],[72,42],[9,24],[87,156],[0,173],[141,5],[163,95],[43,53],[57,188],[69,12],[70,49],[79,197],[174,49],[110,122],[163,47],[169,6],[88,10],[181,143],[54,56],[70,160],[34,72],[180,31],[133,48],[181,93],[118,16],[95,55],[168,108],[90,68],[5,73],[11,102],[186,161],[64,142],[76,101],[82,38],[134,95],[164,7],[1,121],[126,152],[161,139],[116,144],[128,45],[64,89],[33,17],[100,58],[61,95],[191,22],[85,120],[183,59],[20,183],[173,58],[145,36],[42,2],[175,43],[124,163],[114,96],[98,133],[63,7],[139,185],[153,131],[157,106],[5,66],[45,188],[1,98],[163,136],[116,51],[51,165],[98,11],[141,28],[10,86],[90,172],[45,50],[131,146],[43,140],[176,184],[148,10],[49,197],[24,115],[155,15],[37,1],[40,134],[45,7],[36,129],[24,119],[120,192],[11,111],[186,172],[41,50],[196,178],[95,1],[121,78],[81,3],[188,54],[120,158],[182,88],[9,77],[13,183],[127,128],[160,4],[161,23],[123,170],[113,132],[168,162],[166,18],[181,121],[180,111],[98,126],[85,82],[172,167],[193,67],[4,194],[147,177],[183,92],[146,140],[159,50],[147,188],[187,50],[1,145],[116,160],[161,62],[173,74],[139,49],[87,98],[145,198],[137,142],[123,137],[80,86],[44,119],[119,100],[190,25],[166,70],[139,27],[145,154],[151,113],[27,45],[95,19],[110,195],[117,125],[94,167],[114,157],[191,103],[86,113],[171,23],[184,21],[4,135]]")))
                .isEqualTo(new int[]{1777, 989, 1949, 2039, 1449, 1359, 1549, 1355, 1631, 2509, 1237, 1335, 1925, 1267, 1089, 1183, 1077, 1343, 1505, 1089, 1267, 1927, 1991, 1239, 2313, 1631, 1381, 1019, 1751, 1799, 1751, 1923, 1561, 1541, 1361, 1601, 1367, 1187, 1797, 1985, 1285, 1551, 1751, 1353, 2317, 1161, 1947, 1277, 1543, 973, 1353, 1597, 1171, 1551, 1545, 1089, 1743, 1547, 1757, 1267, 1911, 1089, 1245, 1553, 1535, 1803, 1169, 1531, 1801, 1727, 1111, 1729, 1555, 1557, 1777, 1475, 1185, 2707, 1377, 1363, 1247, 1841, 1599, 1535, 2039, 1403, 1049, 1339, 1433, 1733, 1603, 2135, 1267, 1571, 1803, 891, 2107, 1455, 1149, 1425, 1937, 1383, 1533, 1991, 1631, 1171, 1911, 1089, 1343, 1987, 1553, 1529, 2319, 1223, 1909, 2511, 1407, 1087, 1265, 2121, 1593, 1179, 1751, 1719, 1279, 1285, 1345, 1551, 1353, 1565, 1551, 1549, 1421, 1345, 1087, 1647, 1279, 1523, 1997, 879, 1159, 1553, 1339, 1571, 1599, 1171, 1353, 1545, 1435, 1551, 2183, 1421, 1543, 1747, 1361, 1381, 1531, 1713, 1791, 1551, 1255, 1047, 1737, 1081, 1553, 1789, 1307, 1605, 1539, 1351, 1917, 1433, 1411, 1579, 1155, 1551, 1927, 1743, 1789, 1647, 1725, 1373, 1631, 1069, 1729, 1077, 1227, 1551, 1349, 1601, 1433, 1793, 1791, 1729, 1647, 1749, 1987, 1167, 1369, 2515});
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[][] distances = new int[n][n];
        for (int[] distance : distances) {
            Arrays.fill(distance, n);
        }
        for (int i = 0; i < n; i++) {
            distances[i][i] = 0;
        }

        for (int[] edge : edges) {
            dijkstra(distances, edge[0], edge[1], 1);
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Arrays.stream(distances[i]).sum();
        }
        return answer;
    }

    private void dijkstra(int[][] distances, int n1, int n2, int distance) {
        distances[n1][n2] = distance;
        distances[n2][n1] = distance;
        for (int i = 0; i < distances.length; i++) {
            if (i == n1 || i == n2)
                continue;
            if (distances[n1][i] == 1 && distances[i][n2] > distance + 1) {
                dijkstra(distances, i, n2, distance + 1);
            }
            if (distances[n2][i] == 1 && distances[i][n1] > distance + 1) {
                dijkstra(distances, i, n1, distance + 1);
            }
        }
    }

}
