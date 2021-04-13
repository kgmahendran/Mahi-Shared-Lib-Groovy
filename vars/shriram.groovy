#!/usr/bin/env groovy
def call() {

def CSVcontent = readCSV file: 'Input.csv'''

def str=CSVcontent.split(',')

def APPID=str[0]

println "$APPID"
  }