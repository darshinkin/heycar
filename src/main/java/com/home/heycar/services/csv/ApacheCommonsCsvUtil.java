package com.home.heycar.services.csv;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.home.heycar.persistence.models.Listing;
import com.home.heycar.persistence.models.ListingId;

public class ApacheCommonsCsvUtil {

    public static final String CODE = "code";
    public static final String MAKE = "make";
    public static final String MODEL = "model";
    public static final String K_W = "kW";
    public static final String YEAR = "year";
    public static final String COLOR = "color";
    public static final String PRICE = "price";
    private static final String csvExtension = "csv";

    public static List<Listing> parseCsvFile(InputStream is) {
        List<Listing> listings = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Listing listing = Listing.builder()
                        .listingId(ListingId.builder().code(csvRecord.get(CODE)).build())
                        .make(csvRecord.get(MAKE))
                        .model(csvRecord.get(MODEL))
                        .kW(Integer.parseInt(csvRecord.get(K_W)))
                        .year(Integer.parseInt(csvRecord.get(YEAR)))
                        .color(csvRecord.get(COLOR))
                        .price(Integer.parseInt(csvRecord.get(PRICE)))
                        .build();
                listings.add(listing);
            }
        } catch (Exception e) {
            System.out.println("Reading CSV Error!");
            e.printStackTrace();
        }

        return listings;
    }

    public static boolean isCSVFile(MultipartFile file) {
        String extension = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];

        if (!csvExtension.equals(extension)) {
            return false;
        }

        return true;
    }
}
