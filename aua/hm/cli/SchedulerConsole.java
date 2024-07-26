package am.aua.hm.cli;

import am.aua.hm.core.Days;
import am.aua.hm.core.Times;
import am.aua.hm.core.VideoCall;
import am.aua.hm.core.Workweek;
import am.aua.hm.exeptions.MalformedStringParameterException;

import java.util.Scanner;

public class SchedulerConsole {

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Workweek workweek = new Workweek();

        while (true) {
            System.out.println("Scheduler:");
            for (Days day : Days.values()) {
                for (Times time : Times.values()) {
                    System.out.println(day + " " + time + ": " + workweek.getTitleAt(day, time));
                }
            }
            System.out.println("Options: ");
            System.out.println("1. Add an event.");
            System.out.println("2. Remove an event.");
            System.out.println("3. Print details.");
            System.out.println("4. Load schedule from file.");
            System.out.println("5. Save schedule to file.");
            System.out.println("6. Quit.");
            int choice = scanner.nextInt();
        }
    }
}
