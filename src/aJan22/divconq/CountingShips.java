package aJan22.divconq;

//1274

/*
    Time Complexity: O(S . (log_2 max(M, N) - log_4 S))
    S is the total number of ships.
    Number of recursive calls needed to pinpoint 1 ship = log_2 max(M, N)
    Number of levels of calls needed(not the actuall number of recursive calls) to isolate the regions that contain
    exactly one ship, if there are S ships in total: log_4 S

    Number of calls needed to pinpoint a ship, after its region has been isolated =
      4 * (log_2 max(M, N) - log_4 S)
    For S ships = 4 S * (log_2 max(M, N) - log_4 S)

    Another way to look at it.
    If there was only one ship. Calls needed to pinpoint it = log_2 max(M, N)
    If we were to pinpoint S ships independently.  Then    S * log_2 max(M, N)
    If we need to pinpoint them in parallel:  4 S * (log_2 max(M, N) - log_4 S)

*/

abstract class Sea {
    abstract public boolean hasShips(int[] topRight, int[] bottomLeft);
 }

public class CountingShips {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) return 0;

        if( topRight[0] ==  bottomLeft[0]  && topRight[1] == bottomLeft[1] ) {
            return  1;
        }

        int midX = (topRight[0] + bottomLeft[0])/2;
        int midY = (topRight[1] + bottomLeft[1])/2;
        return countShips(sea, new int[]{midX, midY}, bottomLeft) +
                countShips(sea, topRight, new int[]{midX+1, midY+1}) +
                countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY+1}) +
                countShips(sea, new int[]{topRight[0], midY}, new int[]{midX+1, bottomLeft[1]});
    }
}
