#!/usr/bin/env groovy
import org.apache.commons.csv.*
import jenkins.model.*
def call() {


def records = readCSV file: 'D:\\Demo-Pipeline\\CSV-Jenkins' , format: CSVFormat.EXCEL



//def str=CSVcontent.split(',')

//def APPID=str[0]

println "$parser"
  }