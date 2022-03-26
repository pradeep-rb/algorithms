package aJan22.dynamicprog;

//42 the DP aspect is in finding out the left and right maxes

public class RainWaterTrap {

    public int trap(int[] height) {
     int ans = 0;
     int length = height.length;
     int[] lMax = new int[length];
     int[] rMax = new int[length];

        lMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            lMax[i] = Math.max(height[i-1], lMax[i-1] );
            System.out.println(lMax[i]);
        }

        rMax[length-1] = height[length-1];
        for (int i = length - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i+1], rMax[i+1] );

        }
        int water = 0;
        for (int i = 0; i < length; i++) {
            water =  Math.min(lMax[i], rMax[i]) - height[i];
            ans += water > 0 ? water : 0;
        }

     return ans;
    }


    public static void main(String[] args) {
        RainWaterTrap rwt = new RainWaterTrap();
        System.out.println(rwt.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(rwt.trap(new int[]{4,2,0,3,2,5}));

    }
}
