package coolboogey.coolboogey.system;

import coolboogey.coolboogey.files.DataManager;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Integer.parseInt;

public class timer {

    public static Timer timer;
    public static boolean timerOn;

    public static void onStart() {
        timerOn = true;
        TimerTask tt;

        tt = new TimerTask() {
            public void run() {
                long count = 0;
                if(DataManager.getConfig().contains("main.event")) {
                    List<String> EventInfo = DataManager.getConfig().getStringList("main.event");
                    if(EventInfo != null) {

                        count = parseInt(EventInfo.get(4));

                        if(count < parseInt(EventInfo.get(2))) {
                            int cool = parseInt(EventInfo.get(4)) + 1;
                            EventInfo.set(4, String.valueOf(cool));
                            DataManager.getConfig().set("main.event", EventInfo);
                            DataManager.save();
                        }
                    }
                    else if(count >= parseInt(EventInfo.get(2))) {
                        onEnd();
                    }
                }
            }
        };

        timer = new Timer();
        timer.schedule(tt, 0, 1000);
    }

    public static void onEnd() {
        timerOn = false;
        timer.cancel();
        timer.purge();
    }
}
