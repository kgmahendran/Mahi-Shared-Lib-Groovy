#!/usr/bin/env groovy
import org.apache.commons.csv.*
import org.jenkinsci.plugins.*
def call() {


def records = readCSV file: 'D:\\Demo-Pipeline\\CSV-Jenkins' 

println "$records[0]"
println "$records.get(0)"
println "$records.get()"
  }