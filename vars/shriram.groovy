#!/usr/bin/env groovy
import org.apache.commons.csv.*
import org.jenkinsci.plugins.*
def call() {


def records = readCSV file: 'D:\\Demo-Pipeline\\CSV-Jenkins' 


//def str=CSVcontent.split(',')

//def APPID=str[0]

println "$records"
  }