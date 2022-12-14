package com.revature;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.mo.BillsClass;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        BillsClass BillClass = new BillsClass();

        ObjectMapper mapper = new ObjectMapper();
        String JSON = mapper.writeValueAsString(BillClass);
        System.out.println(JSON);
    }
}