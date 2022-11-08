package com.example.finalProject.common.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static List<Integer> zoneDateToList(ZonedDateTime zonedDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-n");
        String[] DateTimeStringList= zonedDateTime.format(formatter).split("-");
        return new ArrayList<>(List.of(DateTimeStringList)).stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
