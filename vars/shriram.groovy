#!/usr/bin/env groovy
import org.apache.commons.csv.*
import org.jenkinsci.plugins.*
def call() {


//def records = readCSV file: 'D:\\Demo-Pipeline\\CSV-Jenkins' 

readFile("D:\\Demo-Pipeline\\CSV-Jenkins").split('\n').each ({ line, count ->

print $count  $line
  })