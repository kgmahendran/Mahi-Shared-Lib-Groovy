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

def GRP_1 = records.groupBy({it.AppID})
def GRP_2=GRP_1.groupBy({it.AppName})
def FINAL_GRP=GRP_2.groupBy({it.ReleaseVersion})
println "++++++++++++++++++++++++++++++++++++++++"

result.FINAL_GRP { key,value ->
		println "$key : $value"
}

println "********************************"

  
  }