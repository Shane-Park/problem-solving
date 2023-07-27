package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 * 19 / 52 testcases passed
 */
public class Q2141MaximumRunningTimeOfNComputers {

    @Test
    void test() {
        assertThat(maxRunTime(3, new int[]{10, 10, 3, 5})).isEqualTo(8);
        assertThat(maxRunTime(2, new int[]{3, 3, 3})).isEqualTo(4);
        assertThat(maxRunTime(2, new int[]{1, 1, 1, 1})).isEqualTo(2);
    }

    @Test
    void tle() {
        assertThat(maxRunTime(385, new int[]{6725, 4264, 1072, 8829, 7916, 4933, 2920, 7008, 1484, 7437, 4351, 9213, 9214, 2115, 4901, 4506, 7845, 9172, 1910, 3432, 8879, 2976, 6129, 9889, 8632, 8810, 5825, 6009, 6108, 1050, 3553, 9918, 8633, 4317, 7214, 8299, 6536, 6284, 3835, 7452, 7163, 6465, 4247, 6329, 7980, 2102, 6928, 4366, 9428, 7886, 8747, 9488, 961, 5621, 8096, 9692, 5820, 3407, 5700, 136, 6587, 2911, 2851, 4558, 3161, 6949, 1571, 7130, 8473, 4528, 2732, 6050, 5101, 2758, 3666, 3918, 1804, 4203, 3881, 1320, 7326, 4738, 7615, 4016, 3311, 8906, 4506, 3161, 6382, 134, 2024, 5147, 6972, 723, 1407, 8974, 4165, 4241, 3411, 2233, 6114, 5184, 5415, 974, 500, 763, 152, 2056, 6083, 2586, 438, 551, 3393, 7584, 1424, 2215, 2010, 5292, 9467, 8055, 1682, 2149, 4770, 6987, 6140, 8001, 7024, 3302, 888, 7681, 4491, 9140, 3590, 9956, 3893, 189, 8414, 7362, 8370, 2831, 7106, 4147, 6045, 4387, 6187, 569, 8851, 7885, 4969, 5514, 7416, 2056, 4832, 1418, 4054, 143, 29, 3684, 1184, 9150, 978, 4617, 9825, 1325, 8058, 9323, 803, 4711, 1832, 5194, 8379, 6469, 3061, 9550, 2772, 4378, 9576, 6549, 6044, 6060, 7940, 2085, 7956, 2791, 1376, 5661, 7935, 5980, 1442, 7938, 9219, 4364, 8748, 9215, 7775, 2619, 4153, 844, 4856, 5514, 3260, 3912, 9644, 8677, 8890, 7647, 569, 1913, 2682, 3148, 3480, 1559, 6570, 6189, 2981, 9868, 3217, 704, 1414, 6210, 9861, 1649, 801, 3266, 9579, 11, 8812, 2235, 3100, 748, 4841, 7715, 7916, 1472, 3640, 3241, 6643, 7143, 4878, 9496, 9064, 4243, 6183, 7004, 6773, 1291, 658, 1084, 4082, 7601, 7818, 3239, 1377, 8407, 3875, 6139, 7617, 1995, 7560, 5039, 7392, 7013, 3133, 4459, 8218, 2762, 5506, 7249, 3844, 3255, 6157, 5043, 6785, 208, 474, 9268, 2255, 9693, 5655, 7723, 167, 7800, 1419, 9267, 2491, 4776, 4479, 3894, 8308, 9287, 4815, 6891, 9433, 4567, 9791, 6415, 7773, 8816, 6121, 9303, 5461, 7877, 2494, 5534, 1846, 3892, 5535, 8675, 139, 2758, 224, 2280, 1984, 8579, 5502, 6978, 4506, 5113, 3263, 7776, 7232, 8496, 3859, 3116, 5832, 6800, 7266, 3265, 1066, 9433, 8765, 5278, 8708, 709, 4186, 1798, 7090, 6853, 4991, 2114, 3052, 3729, 6118, 1423, 2048, 6888, 5688, 9347, 9067, 5689, 3623, 9979, 110, 910, 3082, 3449, 7940, 238, 6605, 6310, 2675, 3050, 7052, 2797, 4405, 5512, 4903, 49, 1948, 8204, 2637, 4497, 3813, 4205, 1931, 2712, 4152, 8436, 1509, 3185, 7203, 7533, 1918, 1791, 5161, 8199, 8405, 1945, 9743, 7192, 4399, 6927, 3309, 5134, 3105, 7989, 8518, 980, 969, 5095, 6647, 7539, 7991, 9306, 6732, 2307, 2973, 5807, 5718, 1367, 3209, 6570, 4721, 7946, 9573, 7044, 1039, 7909, 5017, 5162, 3202, 2599, 7028, 2919, 1282, 8528, 6390, 2652, 2295, 5230, 9615, 3207, 4158, 7657, 1779, 5682, 1956, 8528, 3646, 6741, 2726, 448, 7625, 5157, 102, 8142, 4271, 708, 7898, 8132, 8095, 2484, 8170, 5707, 1021, 5420, 2916, 8686, 6867, 7833, 4408, 6050, 7134, 979, 2357, 7649, 4280, 4666, 8039, 8072, 6575, 9385, 7654, 21, 9055, 9684, 8518, 1279, 9761, 2667, 6938, 4860, 1220, 1520, 7332, 1652, 9581, 8650, 2370, 1834, 9904, 5082, 4079, 4980, 4671, 377, 6368, 4991, 8469, 1860, 9232, 1066, 1047, 1471, 8545, 2794, 6346, 523, 501, 1056, 288, 7938, 1681, 5517, 7181, 5037, 8089, 2280, 336, 3795, 9723, 9429, 7692, 9949, 3933, 9559, 8910, 7539, 2543, 9751, 7209, 8911, 7442, 3465, 704, 1758, 8417, 435, 1799, 5933, 7012, 8698, 4897, 7662, 5312, 9193, 4201, 6871, 6786, 6172, 746, 5024, 8169, 3999, 8113, 488, 2024, 4059, 4786, 2866, 476, 6453, 6393, 3504, 6190, 8382, 6062, 7860, 5828, 6944, 2260, 1293, 9762, 1419, 4235, 759, 8633, 2613, 2807, 138, 3415, 7257, 184, 7906, 4342, 9547, 2373, 3113}))
                .isEqualTo(7114L);
    }

    public long maxRunTime(int n, int[] batteries) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int battery : batteries) {
            pq.offer(battery);
        }
        while (pq.size() > n) {
            Integer poll = pq.poll();
            int nextSmall = pq.poll();
            if (poll > 1) {
                pq.offer(poll - 1);
            }
            pq.offer(nextSmall + 1);
        }
        return pq.peek();
    }

}
