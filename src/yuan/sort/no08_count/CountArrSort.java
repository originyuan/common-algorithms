package yuan.sort.no08_count;

import java.util.Arrays;

/**
 * @author liuyiyuan
 *
 * 计数排序，需要长度为最大数字+1的辅助数组，而且需要全为正数，利用数组下标进行存入取出排序
 * 如果出现负值可以先加上负值大小，完成后再进行减去负值大小
 */
public class CountArrSort {
    public static void sort(int[] arr) {

        //找出数组中的最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        //初始化计数数组
        int[] countArr = new int[max + 1];

        //计数
        for (int i = 0; i < arr.length; ++i) {
            countArr[arr[i]]++;
        }

        //顺序累加
        for (int i = 1; i < max + 1; ++i) {
            countArr[i] = countArr[i-1] + countArr[i];
        }

        //排序后的数组
        int[] sortedArr = new int[arr.length];

        //排序
        for (int i = arr.length - 1; i >= 0; --i) {
            sortedArr[countArr[arr[i]]-1] = arr[i];
            countArr[arr[i]]--;
        }

        //将排序后的数据拷贝到原数组
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = sortedArr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,2,5,9,7,3,6,2,8,9,0,18,2,16,2}; //长度6  0-5

        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
