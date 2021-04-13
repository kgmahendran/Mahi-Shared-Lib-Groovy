#!/usr/bin/env groovy
def call() {

def excelFormat = CSVFormat.EXCEL
def CSVcontent = readCSV file: 'Input.csv', format: excelFormat

println "$CSVcontent"
  }