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
List<CSVRecord> PassedList;
List<CSVRecord> FailedList;
def failedEnvList="NA";
def passedEnvList="NA";
for (Map.Entry<String, List<CSVRecord>> entry : result.entrySet()) {
   
	def  buildList = entry.getValue();
	PassedList= buildList.findAll{f -> !f.get("Status").contains("Failed")}
	FailedList =  buildList.findAll{it.Status.contains("Failed")}
	
	println "---------------------Passed-----------------------------"
	println"$PassedList"
	println "---------------------Failed-----------------------------"
	println "$FailedList"
	
if (PassedList != null && PassedList.size() > 0) {
		 passedEnvList = PassedList.each({mp -> mp.get("Environment")}.join('|'))
		
	}
	if (FailedList != null && FailedList.size() > 0) {
	
		failedEnvList = FailedList.each({mp -> mp.get("Environment")}.join('|'))
		//def failedEnvList = FailedList.get("Status").join('|')
		 //def failedEnvList = FailedList.map({mp -> mp.get("Status")}).join("|")
	}
	
	
	print ln"-----------------------------------------------------"
	println "$passedEnvList"
	println "$failedEnvList"

	}

  }