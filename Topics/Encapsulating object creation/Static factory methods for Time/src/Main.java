import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    private static final int H_IN_D = 24;
    private static final int S_IN_M = 60;
    private static final int S_IN_H = 3600;
    private static final Time NOON_FIELD = new Time(12, 0, 0);
    private static final Time MIDNIGHT_FIELD = new Time(0, 0, 0);

    private Time(int h, int m, int s) {
        hour = h;
        minute = m;
        second = s;
    }

    public static Time noon() {
        return NOON_FIELD;
    }

    public static Time midnight() {
        return MIDNIGHT_FIELD;
    }

    public static Time ofSeconds(long seconds) {
        Time time = new Time(0, 0, 0);
        int tmp = (int) (seconds / S_IN_H);
        time.hour = tmp > H_IN_D - 1 ? tmp % H_IN_D : tmp;
        time.minute = (int) ((seconds % S_IN_H) / S_IN_M);
        time.second = (int) (seconds % S_IN_M);
        return time;
    }

    public static Time of(int hour, int minute, int second) {
        Time time  = new Time(0, 0, 0);
        time.hour = second / S_IN_H >= H_IN_D ? ofSeconds(second).hour : hour;
        time.minute = second > S_IN_M ? ofSeconds(second).minute + minute : minute;
        time.second = ofSeconds(second).second;
        if (hour < 0 || hour > 23
                || minute < 0 || minute > 59
                || second > 59 || second < 0) {
            time = null;
        }
        return time;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.printf("%s %s %s", time.hour, time.minute, time.second);
        }
    }
}