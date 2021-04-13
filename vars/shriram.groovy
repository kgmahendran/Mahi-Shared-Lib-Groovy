#!/usr/bin/env groovy
def call() {

def CSVcontent = readCSV file: 'Input.csv', format: CSVFormat.DEFAULT.withHeader()

//CSVParser parser = CSVFormat.EXCEL.parse(CSVcontent);

//def str=CSVcontent.split(',')

//def APPID=str[0]

println "$CSVcontent"
  }