package aJan22.misc;

//277. Find the Celebrity
public class FindCelebrity {

    public int findCelebrity(int n) {

        int curr = 0;
        for (int i = 1; i < n; i++) {
            if(!knows(curr, i)) continue;
            curr = i;
        }

        for (int i = 0; i < n; i++) {
            if( i != curr && (knows(curr, i) || ! knows(i, curr))) return  -1;
        }

        return curr;
    }
    //dummy helper to no throw error.
    boolean knows(int a, int b){return  true; };
}
