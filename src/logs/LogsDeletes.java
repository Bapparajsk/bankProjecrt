package logs;

import java.util.Date;
import java.util.TreeMap;

public class LogsDeletes {
    static TreeMap<Date, String> logs = new TreeMap<>();

    public static void printLogs() {
        for (Date key : logs.keySet()) {
            System.out.println(key + " -> " + logs.get(key));
        }
    }

    public static void setLogs(String log) {
        Date date = new Date();
        logs.put(date, log);
    }
}
