package aug21.misc;



import java.util.*;

public class ThrottleGateway {
    ThrottleWindow oneSecWindow = new ThrottleWindow(1,  3);
    ThrottleWindow tenSecWindow = new ThrottleWindow(10,  20);
    ThrottleWindow sixtySecWindow = new ThrottleWindow(60,  60);
    List<ThrottleWindow> throttleWindows = Arrays.asList(oneSecWindow, tenSecWindow, sixtySecWindow);
    TreeMap<Integer, Integer> txnCntBySec = new TreeMap<>();
    int MAX_WINDOW_SIZE = 60;


    public int dropRequests(List<Integer> txnsByTime) {
        int dropCnt = 0;

        for (int txnTime: txnsByTime) {
            //at every second update the dictionary that keeps track of how many txns arrived in a given second
            txnCntBySec.put(txnTime,  txnCntBySec.getOrDefault(txnTime, 0) + 1 );
            boolean dropped = false;
            for (ThrottleWindow throttleWindow: throttleWindows) {

                //at every second update the count of all the windows a
                throttleWindow.incrementCnt();

                //at every second check if the window needs to be slid and the count of
                //the window needs to be updated if the window was slid
                if(txnTime > throttleWindow.getEnd()) {
                    throttleWindow.slideWindow(txnTime, txnCntBySec.getOrDefault(throttleWindow.getStart(), 0) );
                }

                if(throttleWindow.getCount() >  throttleWindow.getCapacity()  ) {
                    System.out.println("Txn at " +  txnTime + " dropped from " + throttleWindow.getLength() + " sec window" );
                    dropped = true;
                }
            }
            if(dropped) dropCnt++;
            if(txnCntBySec.size() > MAX_WINDOW_SIZE) {
                txnCntBySec.pollFirstEntry();
            }
        }
        return dropCnt;
    }


    public static void main(String[] args) {
        ThrottleGateway tg = new ThrottleGateway();

        System.out.println(tg.dropRequests(Arrays.asList(1 ,1 ,1 ,1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7,
        11 ,11, 11 ,11 )));
    }




    class ThrottleWindow {
        private  int length;
        private int start = 1;
        private int count = 0;
        private int capacity;

        public ThrottleWindow(int length, int capacity) {
            this.length = length;
            this.capacity = capacity;
        }

        public int getLength() {
            return length;
        }

        public void incrementCnt() {
            count++;
        }

        public void slideWindow(int txnTime, int capacityAdjustment) {
            count = count - capacityAdjustment;
            start = txnTime - length + 1;
        }
        public int getEnd() {
            return start + length - 1;
        }
        public int getStart() {
            return start;
        }

        public int getCount() {
            return count;
        }

        public int getCapacity() {
            return capacity;
        }

    }
}
