import java.util.ArrayList;

public class Level1 {
    public static int Unmanned(int L, int N, int[][] track) {
        ArrayList<Integer> stopTraffic = new ArrayList<>();
        for (int x = 0; x < track.length; x++) {
            stopTraffic.add(track[x][0]);
        }

        int amt = 0;
        int time = 0;

        for (int x = 1; x <= L; x++) {
            time++;
            for (int stops : stopTraffic) {
                if (x == stops) {
                    time += trafficLightColor(time, track, amt);
                    amt++;
                }
            }
        }

        return time;
    }

    public static int trafficLightColor(int time, int[][] track, int amt) {
        int circle = track[amt][1] + track[amt][2];

        while (time > circle) {
            time -= circle;
        }

        if (time <= track[amt][1])
            return track[amt][1] - time;
        return 0;
    }

}

