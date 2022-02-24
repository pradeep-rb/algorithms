package aJan22.greedy;

//45
public class JumpGame2 {


    public int jump(int[] nums) {

        int steps = 0;
        int currJump = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1 ; i++) {

            farthest = Math.max(farthest, i + nums[i] );

            if(i == currJump) {
                currJump = farthest;
                steps++;
            }
        }
        return  steps;
    }



    public static void main(String[] args) {

        JumpGame2 jg = new JumpGame2();
        //System.out.println(jg.canJump(new int[] {3,2,1,0,4} ));
        //System.out.println(jg.jump(new int[] {2,3,1,1,4} ));
        //System.out.println(jg.canJump(new int[] {0, 2, 3} ));
        //System.out.println(jg.canJump(new int[] {2, 0, 0} ));

        System.out.println(jg.jump(new int[] {2,3,1,1,4} ));
        System.out.println(jg.jump(new int[] {1,2} ));
        System.out.println(jg.jump(new int[] {2,1} ));


    }

}
