package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Logger {

    private File log;

    public Logger(String logFile) {
        this.log = new File(logFile);
    }

    public void purchaseLog(String event, BigDecimal balance, BigDecimal finalBalance) {

        try(PrintWriter pw = new PrintWriter(new FileOutputStream(log, true))) {
        DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String newDateForm = LocalDate.now().format(dateForm);

        DateTimeFormatter timeForm = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        String newTimeForm = LocalTime.now().format(timeForm);

        pw.write(newDateForm + " " + newTimeForm + " " + event + " " + balance + " " + finalBalance);
            pw.println() ;
        }catch (FileNotFoundException fnf){
            System.out.println("Oops, something went wrong.");
        }
    }

    public void itemLog(String name, String slotNumber, BigDecimal balance, BigDecimal finalBalance) {

        try(PrintWriter pw = new PrintWriter(new FileOutputStream(log, true))) {
            DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String newDateForm = LocalDate.now().format(dateForm);

            DateTimeFormatter timeForm = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
            String newTimeForm = LocalTime.now().format(timeForm);

            pw.write(newDateForm + " " + newTimeForm + " " + name + slotNumber + " " + balance + " " + finalBalance);
            pw.println() ;
        }catch (FileNotFoundException fnf){
            System.out.println("Oops, something went wrong.");
        }
    }
}
