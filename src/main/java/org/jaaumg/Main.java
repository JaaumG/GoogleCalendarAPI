package org.jaaumg;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Events;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static org.jaaumg.CalendarQuickstart.*;

public class Main {

    public static void main(String[] args) throws GeneralSecurityException, IOException, ParseException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Calendar service =
                new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                        .setApplicationName(APPLICATION_NAME)
                        .build();
        Events events = new Events();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do evento.");
        String nome = sc.nextLine();
        System.out.println("Digite a data do evento (dd/MM/yyyy HH:mm).");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(sc.nextLine(), formatter);
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        sc.close();

    }
}
