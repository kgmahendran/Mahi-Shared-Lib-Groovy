#!/usr/bin/env groovy
import org.apache.commons.csv.*
def call() {

def CSVcontent = readCSV file: 'Input.csv'

CSVParser parser = CSVFormat.EXCEL.parse(CSVcontent);

//def str=CSVcontent.split(',')

//def APPID=str[0]

println "$parser"
  }