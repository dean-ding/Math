package com.tvt.math.other;

/**
 * <p><strong>对公司的员工的年龄排序</strong></p>
 * 时间复杂度为O(n),空间复杂度最大可以为O(n)
 */
public class AgeOrder {

    public void order(int[] ages, int length) {
        if (length <= 0) {
            System.err.println("错误的组合");
        }
        if (length == 1) {
            print(ages, length);
            return;
        }
        int oldestAge = 99; // 最大年龄
        int[] timesOfAge = new int[oldestAge + 1];// 每个年龄出现的次数

        // 查询这个数组中出现的年龄，然后根据年龄放到对应的timesOfAge中，出现一次+1
        for (int i = 0; i < length; i++) {
            int age = ages[i];
            if (age > oldestAge) {
                System.err.println("这个人的年龄超过了最大值");
                continue;
            }
            if (age < 0) {

                System.err.println("这个人是童工");
                continue;
            }
            timesOfAge[age] = timesOfAge[age] + 1;
        }
        // 將timesOfAge的年龄值遍历，并根据各个年龄出现的次数多次赋值到ages中
        int index = 0;
        for (int i = 0; i < oldestAge; i++) {
            for (int j = 0; j < timesOfAge[i]; j++) {
                ages[index] = i;
                index++;
            }
        }
        print(ages, length);
    }

    private void print(int[] ages, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(ages[i] + ",");
        }
    }

}
