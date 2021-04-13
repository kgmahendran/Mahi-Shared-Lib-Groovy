#!/usr/bin/env groovy
import org.apache.commons.csv.*
import org.jenkinsci.plugins.*
import java.util.stream.*
def call() {


def records = readCSV file: 'D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv' , format: CSVFormat.DEFAULT.withHeader().withFirstRecordAsHeader()

records.each { key,value ->
		println "$key : $value"
}

println "++++++++++++++++++++++++++++++++++++++++"

def result = records.groupBy({it.AppID}:{it.AppName}:{it.ReleaseVersion})

println "++++++++++++++++++++++++++++++++++++++++"

result.each { key,value ->
		println "$key : $value"
}

println "********************************"

  
  }