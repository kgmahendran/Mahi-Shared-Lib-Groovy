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

def result = records.groupBy({record -> record.get("AppID")+"-"+record.get("AppName")+"-"+record.get("ReleaseVersion")})

println "++++++++++++++++++++++++++++++++++++++++"

result.each { key,value ->
		println "$key : $value"
}

println "********************************"

for (Map.Entry<String, List<CSVRecord>> entry : result.entrySet()) {

	def  buildList = entry.getValue();
	def FailedList =  buildList.findAll{it.Status.contains("Failed")}.collect{it.Status}
	
	println"$FailedList"
	
	if (FailedList != null && failedList.size() > 0) {
	def  failedEnvList = failedList.map({mp -> mp.get("Status")}).collect(Collectors.joining("|"));
	}
	
	println $failedEnvList"

	}

  }