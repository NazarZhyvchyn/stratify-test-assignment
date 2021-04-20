package com.stratify.spring.files.excel.controller;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.stratify.spring.files.excel.model.MockData;

import com.stratify.spring.files.excel.service.MockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController
{

    @Autowired
    MockDataService mockdataService;


    public FilterController()
    {

    }

    @ResponseBody
    @RequestMapping(value="/api/excel/opportunity/{team},{product},{bookingType}", method = RequestMethod.GET)
    public ResponseEntity<List<MockData>> allData(
            @PathVariable("team") String team,
            @PathVariable("product") String product,
            @PathVariable("bookingType") String bookingType)

    {
        List<MockData> mockData = mockdataService.getAllMockdata();

        ResponseEntity<List<MockData>> retVal;

        if (mockData == null || mockData.isEmpty() )
        {
            List<MockData> mockData1 = new ArrayList<MockData>();
            retVal = ResponseEntity.ok(mockData1);
            return retVal;
        }

        List<MockData> collect = mockData
                .stream()
                .filter(x -> x.getTeam().equals(team))
                .filter(x -> x.getProduct().equals(product))
                .filter(x -> x.getBookingType().equals(bookingType))
                .collect(Collectors.toList());

        retVal = ResponseEntity.ok(collect);
        return retVal;
    }
}
