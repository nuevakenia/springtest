package com.clientesweb.demo.utils.commons;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;

@Service
public class FechaUtilsService {

    public String getMes(){
        LocalDate currentDate = LocalDate.now();
        int month = currentDate.getMonthValue();
        String mothgString = "";
        if(month<10){
            mothgString = "0" + month;
            if(mothgString.equals("010")){
                mothgString = "10";
            }
            if(mothgString.equals("011")){
                mothgString = "11";
            }
            if(mothgString.equals("012")){
                mothgString = "12";
            }
        }else{
            mothgString = String.valueOf(month);
            if(mothgString.equals("001")){
                mothgString = "01";
            }
            if(mothgString.equals("002")){
                mothgString = "02";
            }
            if(mothgString.equals("003")){
                mothgString = "03";
            }
            if(mothgString.equals("004")){
                mothgString = "04";
            }
            if(mothgString.equals("005")){
                mothgString = "05";
            }
            if(mothgString.equals("006")){
                mothgString = "06";
            }
            if(mothgString.equals("007")){
                mothgString = "07";
            }
            if(mothgString.equals("008")){
                mothgString = "08";
            }
            if(mothgString.equals("009")){
                mothgString = "09";
            }
        }
        return mothgString;
    }


    public String getYear(){
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        return String.valueOf(year);
    }
}
