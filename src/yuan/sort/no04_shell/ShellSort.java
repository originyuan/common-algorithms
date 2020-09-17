package yuan.sort.no04_shell;

import yuan.sort.Sort;

/**
 * @author liuyiyuan
 * <p>
 * 希尔排序
 * <p>
 * 希尔排序这个名字，来源于它的发明者希尔，也称作“缩小增量排序”，是插入排序的一种更高效的改进版本。
 * <p>
 * 　　我们知道，插入排序对于大规模的乱序数组的时候效率是比较慢的，因为它每次只能将数据移动一位，
 * 希尔排序为了加快插入的速度，让数据移动的时候可以实现跳跃移动，节省了一部分的时间开支。
 */
public class ShellSort extends Sort {

    public static ShellSort instance = new ShellSort();

    private ShellSort() {
    }

    @Override
    public void sort(Comparable[] arr) {
        int len = arr.length;
        //计算区间
        int grp = 1;
        while (grp < len) { //也可以 grp < len/3
            grp = grp * 3 + 1; //1, 4, 13, 40, 121,...
        }
        while (grp >= 1) {
            for (int i = grp; i < len; i++) {
                for (int j = i; j >= grp && less(arr[j], arr[j - grp]); j -= grp) {
                    exch(arr, j, j - grp);
                }

            }
            grp = grp / 3;
        }
    }



    public static void main(String[] args) {
        Integer[] a = {28, 9, 2, 5, 17, 45, 1, 7, 0, 2, 8, 9, 23};
        ShellSort.instance.sort(a);
        ShellSort.instance.show(a);
    }
}
