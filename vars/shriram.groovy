#!/usr/bin/env groovy
import java.io.FileReader.*;
def call() {

Reader CSVcontent = new FileReader("D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv");

def str=CSVcontent.split(',')

def APPID=str[0]

println "$APPID"
  }