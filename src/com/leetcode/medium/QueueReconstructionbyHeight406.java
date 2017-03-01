package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by aijaz on 2/28/17.
 */
public class QueueReconstructionbyHeight406 {
    class HeightInfo implements Comparable<HeightInfo>{
        int height;
        int order;

        public HeightInfo(int h, int o) {
            height = h;
            order = o;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            HeightInfo that = (HeightInfo) o;

            if (height != that.height) return false;
            return order == that.order;

        }

        @Override
        public int hashCode() {
            int result = height;
            result = 31 * result + order;
            return result;
        }

        @Override
        public int compareTo(HeightInfo o) {
            if(this.order != o.order ) {
                return this.order - o.order;
            }else{
                return this.height - o.height;
            }
        }
    }
    public int[][] reconstructQueue(int[][] people) {

        HeightInfo[] hInfos = new HeightInfo[people.length];
        for (int i = 0; i < people.length; i++) {
            HeightInfo h = new HeightInfo(people[i][0], people[i][1]);
            hInfos[i] = h;
        }
        Arrays.sort(hInfos);
        for (HeightInfo h :
                hInfos) {
            System.out.println(h.height + "\t" + h.order);
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        QueueReconstructionbyHeight406 obj = new QueueReconstructionbyHeight406();
        int[][] output = obj.reconstructQueue(input);
//        for (int i = 0; i < output.length; i++) {
//            System.out.println(output[i][0] + "\t" + output[i][1]);
//        }
    }
}
