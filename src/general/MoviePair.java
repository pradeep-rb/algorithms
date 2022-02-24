package general;

import java.util.Comparator;

public class MoviePair {




    public static void main(String[] args) {
            int[] duration = new int[] {90, 85, 65, 60, 120, 150, 125};

            Max max = new Max(0, 1);
            for (int i=0; i < duration.length; i++) {
                for (int j = i+1; j < duration.length; j++) {
                    int currentTotal = duration[i] + duration[j];
                    int maxDuration = duration[max.getIndex1()] + duration[max.getIndex2()];
                   if(currentTotal > 220 || currentTotal < maxDuration) {
                       continue;
                   }
                   else if(currentTotal == maxDuration) {
                       if(duration[max.getIndex1()] >= duration[i] && duration[max.getIndex1()] >= duration[j] ||
                            duration[max.getIndex2()] >= duration[i] && duration[max.getIndex2()] >= duration[j]) {
                           continue;
                       }
                       else {
                           max = new Max(i, j);
                       }
                   }
                   else {
                       max = new Max(i, j);
                   }
                }
            }

        System.out.println(max);

    }




    static class Max {
        int index1;
        int index2;

        public Max(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }

        public int getIndex1() {
            return index1;
        }

        public int getIndex2() {
            return index2;
        }

        public void setIndex1(int index1) {
            this.index1 = index1;
        }

        public void setIndex2(int index2) {
            this.index2 = index2;
        }

        @Override
        public String toString() {
            return "Max{" +
                    "index1=" + index1 +
                    ", index2=" + index2 +
                    '}';
        }
    }
}
