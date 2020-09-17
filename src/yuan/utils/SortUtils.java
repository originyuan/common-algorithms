package yuan.utils;

import java.util.Arrays;
import java.util.Random;

/**
 * 排序算法小工具
 *
 * @description:
 * @author: liuyiyuan
 */
public class SortUtils {
    /**
     * 洗牌算法
     * Fisher–Yates随机置乱算法也被称做高纳德置乱算法
     *
     * @param arr 要乱序的数组
     * @param <T> 要乱序的数组类型，必须是对象类型
     */
    public static <T> void shuffle(T[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i >= 1; i--) {
            int j = random.nextInt(i + 1);
            T tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5};
        shuffle(integers);
        System.out.println(Arrays.toString(integers));
    }

}
