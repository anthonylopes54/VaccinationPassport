package com.example.vaccinationpassport.parser;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

import com.example.vaccinationpassport.record.ParsedNdefRecord;

import java.util.ArrayList;
import java.util.List;


public class NdefMessageParser {

    private NdefMessageParser() {
    }

    public static List<ParsedNdefRecord> parse(NdefMessage message) {
        return getRecords(message.getRecords());
    }

    public static List<ParsedNdefRecord> getRecords(NdefRecord[] records) {
        List<ParsedNdefRecord> elements = new ArrayList<ParsedNdefRecord>();

        for (final NdefRecord record : records) {
                elements.add(new ParsedNdefRecord() {
                    public String str() {
                        // THIS IS THE TEXT THAT APPEARS
                        System.out.println("aldsjflksfjlkdsfjlkdsjf");
                        return new String(record.getPayload());
                    }
                });
        }

        return elements;
    }
}
