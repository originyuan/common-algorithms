package yuan.sort.no10_base;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author liuyiyuan
 *
 *
 *
 * 基数排序
 *      分割数字位进行排序，依次从个位到高位，每位采用桶排序，每位数字0-9 所以只需要10个桶
 *
 *      适用于长数字比较，比如身份证，电话号等的排序，如果用计数排序或桶排序将要使用大量的内存（计数排序需要最大数字+1长度的数组，桶排序需要数组长度个桶（可能））
 */
public class BaseNumSort {

    public static void sort(int[] arr)
    {
        int length = arr.length;

        //最大值
        int max = arr[0];
        for(int i=0;i<length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //当前排序位置
        int location = 1;

        //桶列表
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();

        //长度为10 装入余数0-9的数据
        for(int i = 0; i < 10; i++){
            bucketList.add(new ArrayList());//每个桶的长度为待排序数组长度
        }

        while(true)
        {
            //判断是否排完
            int dd = (int)Math.pow(10,(location - 1));
            if(max < dd){
                break;
            }

            //数据入桶
            for(int i = 0; i < length; i++)
            {
                //计算余数 放入相应的桶
                int number = ((arr[i] / dd) % 10);
                bucketList.get(number).add(arr[i]);
            }

            //写回数组
            int nn = 0;
            for (int i=0;i<10;i++){
                int size = bucketList.get(i).size();
                for(int ii = 0;ii < size;ii ++){
                    arr[nn++] = bucketList.get(i).get(ii);
                }
                bucketList.get(i).clear();
            }
            location++;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{681, 791,590, 3999, 600,2888, 999, 896, 952};

        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
