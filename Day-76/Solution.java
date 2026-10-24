class Solution {
    private static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int startAlice = dateToDay(arriveAlice);
        int endAlice = dateToDay(leaveAlice);
        int startBob = dateToDay(arriveBob);
        int endBob = dateToDay(leaveBob);


        int overlapStart = Math.max(startAlice, startBob);
        int overlapEnd = Math.min(endAlice, endBob);


        if (overlapStart <= overlapEnd) {
            return overlapEnd - overlapStart + 1;
        }
        return 0;
    }


    private int dateToDay(String dateStr) {
        int month = Integer.parseInt(dateStr.substring(0, 2));
        int day = Integer.parseInt(dateStr.substring(3, 5));

        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += DAYS_IN_MONTHS[i];
        }
        return dayOfYear;
    }
}