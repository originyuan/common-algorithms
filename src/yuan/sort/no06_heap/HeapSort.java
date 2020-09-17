package yuan.sort.no06_heap;

import java.util.Arrays;

/**
 * @author liuyiyuan
 */
public class HeapSort {
    /**
     * 堆排序
     * @param arr 排序数组
     */
    public static void sort(int[] arr) {

        int length = arr.length; //这里用length 或 length-1 都可以   对于基0的（len-1）/2正好排除叶子结点或只执行一个叶子

        //构建堆
        buildHeap(arr, length);

        for (int i = length - 1; i > 0; i--) {
            //将堆顶元素与末位元素调换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //数组长度-1 隐藏堆尾元素
            length--;

            //将堆顶元素下沉 目的是将最大的元素浮到堆顶来
            sink(arr, 0, length);
        }
    }

    /**
     * 构建堆
     * @param arr 数组
     * @param length 数组范围
     */
    private static void buildHeap(int[] arr, int length) {
        for (int i = length / 2 ; i >= 0; i--) {  //从索引3位置开始下沉构建堆   目的是从非叶子结点开始下沉，因为叶子结点不需要下沉   叶子=度为2+1
            sink(arr, i, length);
        }
    }

    /**
     * 下沉调整
     * @param arr 数组
     * @param index 调整位置
     * @param length 数组范围
     */
    private static void sink(int[] arr, int index, int length) {
        int leftChild = 2 * index + 1;//左子节点下标         这里是基0的所以索引为x的结点的子节点索引为2x+1 2x+2  如果基1（舍去0）就是2x 和 2x+1
        int rightChild = 2 * index + 2;//右子节点下标
        int present = index;//要调整的节点下标

        //下沉左边
        if (leftChild < length && arr[leftChild] > arr[present]) {
            present = leftChild;
        }

        //下沉右边
        if (rightChild < length && arr[rightChild] > arr[present]) {
            present = rightChild;
        }

        //如果下标不相等 证明调换过了
        if (present != index) {
            //交换值
            int temp = arr[index];
            arr[index] = arr[present];
            arr[present] = temp;

            //继续下沉
            sink(arr, present, length);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,2,5,9,7,3,6,2,8,9,0,45,18,2,16,2,44,21,0,9,3,4,1,10, 3, 4, 1,7,49,2,83}; //长度6  0-5

        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
