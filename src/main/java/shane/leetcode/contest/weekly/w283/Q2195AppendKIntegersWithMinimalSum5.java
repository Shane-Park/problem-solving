package shane.leetcode.contest.weekly.w283;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class Q2195AppendKIntegersWithMinimalSum5 {

    @Test
    void test() {
        assertThat(minimalKSum(new int[]{1, 4, 25, 10, 25}, 2)).isEqualTo(5);
        assertThat(minimalKSum(new int[]{5, 6}, 6)).isEqualTo(25);
        assertThat(minimalKSum(new int[]{53, 41, 90, 33, 84, 26, 50, 32, 63, 47, 66, 43, 29, 88, 71, 28, 83}, 76)).isEqualTo(3444);
        assertThat(minimalKSum(new int[]{96, 44, 99, 25, 61, 84, 88, 18, 19, 33, 60, 86, 52, 19, 32, 47, 35, 50, 94, 17, 29, 98, 22, 21, 72, 100, 40, 84}, 35)).isEqualTo(794);
    }

    @Test
    public void tle() {
        assertThat(minimalKSum(new int[]{1}, 1000000000)).isEqualTo(500000001500000000L);
    }

    @Test
    public void tle2() {
        assertThat(minimalKSum(new int[]{4086366, 5582122, 602252, 194088, 5843831, 4688011, 4225061, 8086852, 8386614, 6397207, 3939315, 6563348, 5461867, 1699531, 5885475, 8053023, 4047122, 7456495, 3678920, 8243072, 377780, 2756730, 2238655, 4323623, 1154565, 4687386, 4308410, 1951050, 1891303, 1006569, 1061783, 6939240, 4713534, 8569169, 8726299, 6888672, 7984676, 135795, 4629646, 4516253, 9312465, 8462150, 3077367, 802271, 123243, 8262967, 1989621, 2533719, 1426910, 2797278, 2752827, 6004612, 9438815, 6132815, 2797005, 4429511, 7261388, 7973411, 5245256, 2696281, 8694421, 4296106, 1560394, 4496732, 8562126, 2532417, 6085845, 9364032, 5345936, 3462299, 3041207, 938739, 2354798, 5540338, 4359813, 5951900, 2207679, 5736816, 7707333, 1296648, 3918653, 847239, 1770683, 5759051, 4622699, 407228, 8817884, 9809250, 1519119, 1444821, 5038916, 8841743, 9720317, 4216286, 2062814, 5711520, 5439440, 1052348, 7446169, 9543139, 1917346, 4485838, 2047658, 3568114, 2258313, 4552562, 6947695, 2015302, 1796037, 7680038, 2009051, 8682473, 3484758, 2014331, 6859840, 4309197, 9137311, 1973701, 1079789, 8105112, 8708327, 2787814, 6617336, 8404464, 4417701, 2287618, 5590477, 4622699, 5270227, 9939149, 1990570, 4206791, 9574578, 6636757, 4871663, 2490722, 5203713, 8478043, 1813483, 5010841, 8867368, 5095178, 1917044, 26398, 3563047, 9699594, 9047579, 2118564, 3240432, 6173597, 3506966, 6583980, 136048, 4444722, 2477032, 1359924, 5886161, 8402840, 130246, 9583350, 8182998, 6175575, 6510635, 4354226, 8105636, 7650668, 7237252, 9813751, 1403441, 4059468, 3325422, 9574358, 6354440, 7185252, 8656682, 6232308, 6982621, 1265741, 6899242, 965724, 5020804, 1166479, 1202268, 2011019, 1015096, 6800199, 4139873, 4619521, 1865535, 4162165, 6724563, 3256758, 8580761, 6087629, 6035871, 4383929, 507862, 6021736, 4196698, 7618057, 2450252, 2495527, 4636943, 9821349, 1779822, 6695262, 5506788, 9959147, 5289563, 319802, 2594359, 8367482, 5769667, 6126724, 7122260, 9556036, 6970413, 3432498, 4204680, 66725, 8155578, 3054663, 5133426, 5897964, 6398030, 1229518, 3539606, 4426621, 447387, 8228027, 3966639, 8494754, 4653466, 2093971, 6106655, 3731405, 8782058, 2236724, 7085790, 3107254, 1060867, 9206908, 6767527, 7590952, 1138170, 2802192, 8409986, 9475557, 1648307, 9825848, 410114, 3537172, 8564044, 6253483, 463882, 8412682, 2896214, 9220546, 4778537, 4717637, 7354782, 3606191, 3486494, 4046755, 3815894, 5055736, 4776925, 1578093, 9624507, 4168578, 3518370, 1051575, 9528564, 7752314, 4087683, 3498469, 7799485, 3610326, 7002787, 5136544, 9394674, 2188796, 4178712, 2683164, 5154700, 9345189, 5990215, 7789758, 2690770, 5253367, 9150601, 2774297, 5639420, 7838201, 951477, 5941685, 4312091, 7270569, 4880182, 3458668, 3949835, 2576449}, 1991601))
                .isEqualTo(1983286874545L);
    }

    public long minimalKSum(int[] nums, long k) {
        long sum = (k * (k + 1)) / 2;
        nums = Arrays.stream(nums).distinct().sorted().toArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= k) {
                sum -= nums[i];
                sum += (++k);
            }
        }

        return sum;
    }

}
