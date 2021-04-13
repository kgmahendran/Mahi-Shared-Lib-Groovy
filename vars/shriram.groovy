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
	List<CSVRecord> PassedList= buildList.findAll{f -> !f.get("Status").contains("Failed")}.collect{it.Status}
	List<CSVRecord> FailedList =  buildList.findAll{it.Status.contains("Failed")}.collect{it.Status}
	
	//def passedEnvList = NA1;
	//def failedEnvList = NA2;
if (PassedList != null && PassedList.size() > 0) {
		//def passedEnvList = PassedList.get("Environment").join('|')
		 passedEnvList = PassedList.map({mp -> mp.get("Environment")}).join("|")
	}
	if (FailedList != null && FailedList.size() > 0) {
		//def failedEnvList = FailedList.get("Status").join('|')
		 failedEnvList = FailedList.map({mp -> mp.get("Status")}).join("|")
	}
	//def FFF=FailedList.join('|')
	println"$passedEnvList"
	println "$failedEnvList"
	
	//println "$failedEnvList"

	}

  }