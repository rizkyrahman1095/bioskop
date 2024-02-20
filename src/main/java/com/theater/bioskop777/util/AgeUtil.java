package com.theater.bioskop777.util;

import java.time.LocalDate;
import java.time.Period;

public class AgeUtil {

    public static int ageCounter(LocalDate birthDate) {
        // get current date
        LocalDate hariIni = LocalDate.now();

        // Menghitung selisih tahun, bulan, dan hari
        Period selisih = Period.between(birthDate, hariIni);

        // Mengembalikan umur dalam tahun
        return selisih.getYears();
    }

}
