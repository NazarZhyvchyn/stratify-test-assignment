package com.stratify.spring.files.excel.helper;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


import com.stratify.spring.files.excel.model.Metadata;
import com.stratify.spring.files.excel.model.MockData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;



public class ExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

  static String[] HEADERs = {"CustomerName", "BookingDate", "OpportunityID", "BookingType", "Total",
          "AccountExecutive", "SalesOrganization", "Team", "Product", "Renewable"};
  static String SHEET = "MOCK_DATA_47";

  public static boolean hasExcelFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }



  public static List<MockData> excelToData(InputStream is) {

    try {

      XSSFWorkbook workbook = new XSSFWorkbook(is);
      XSSFSheet sheet = workbook.getSheetAt(0);
      if (sheet == null) {
        throw new IllegalArgumentException("No sheet exists with name " + sheet.getSheetName());
      }

      Iterator<Row> rows = sheet.iterator();

      List<MockData> data = new ArrayList<MockData>();

      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();

        if (rowNumber == 0 | rowNumber == 1 | rowNumber == 2) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        MockData mockData = new MockData();
        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          switch (cellIdx) {
            case 0:
              mockData.setCustomerName(currentCell.getStringCellValue());
              break;
            case 1:

              mockData.setBookingDate(currentCell.getLocalDateTimeCellValue());
              break;
            case 2:
              mockData.setOpportunityId(currentCell.getStringCellValue());
              break;
            case 3:

              mockData.setBookingType(currentCell.getStringCellValue());
              break;
            case 4:
              mockData.setTotal(currentCell.getNumericCellValue());
              break;
            case 5:
              mockData.setAccountExecutive(currentCell.getStringCellValue());
              break;
            case 6:
              mockData.setSalesOrganization(currentCell.getStringCellValue());
              break;
            case 7:
              mockData.setTeam(currentCell.getStringCellValue());
              break;
            case 8:
              mockData.setProduct(currentCell.getStringCellValue());
              break;
            case 9:
              mockData.setRenewable(currentCell.getStringCellValue());
              break;

            default:
              break;
          }

          cellIdx++;
        }

        data.add(mockData);
      }
      workbook.close();

      return data;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }

  public static List<Metadata> metadataToData(InputStream is) {
    List<Metadata> excelMetadata = new ArrayList<Metadata>();

    try {

      XSSFWorkbook workbook = new XSSFWorkbook(is);
      XSSFSheet sheet = workbook.getSheetAt(0);
      if (sheet == null) {
        throw new IllegalArgumentException("No sheet exists with name " + sheet.getSheetName());
      }
      Metadata metadata = new Metadata();

      CellRangeAddress cellAddresses = new CellRangeAddress(2, 49, 1, 10 );
      XSSFExcelExtractor extractor = new XSSFExcelExtractor(workbook);

      try (OutputStream os = new FileOutputStream("temp.xlsx")) {
        workbook.write(os);
      }
      long len = new File("temp.xlsx").length();

      new File("temp.xlsx").delete();

      metadata.setName(sheet.getSheetName());
      metadata.setCreationDate(extractor.getCoreProperties().getCreated());
      metadata.setSize(len / 1024 + "KB");
      metadata.setUploadDate(String.valueOf(LocalDateTime.now()));
      metadata.setArea(cellAddresses.formatAsString());
      excelMetadata.add(metadata);
      workbook.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return excelMetadata;
  }

}




