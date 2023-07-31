package model;

public class Train {
    private int arrivalTimeInMinutes;

    public Train(String timePoint) {
        String[] nowTime = timePoint.split(":");
        int h = Integer.parseInt(nowTime[0]);
        int m = Integer.parseInt(nowTime[1]);
        this.arrivalTimeInMinutes = h * 60 + m;
    }

    public int getArrivalTimeInMinutes() {
        return arrivalTimeInMinutes;
    }
}
