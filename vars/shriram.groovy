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
	def PassedList= buildList.findAll{f -> !f.get("Status").contains("Failed")}.collect{it.Status}
	def FailedList =  buildList.findAll{it.Status.contains("Failed")}.collect{it.Status}
	def passedEnvList=NA;
	def failedEnvList=NA;
if (PassedList != null && PassedList.size() > 0) {
		passedEnvList = PassedList.get("Environment").join('|')
	}
	if (FailedList != null && FailedList.size() > 0) {
		failedEnvList = FailedList.get("Status").join('|')
	}
	def FFF=FailedList.join('|')
	println"$PassedList"
	println "$FailedList"
	
	//println "$failedEnvList"

	}

  }