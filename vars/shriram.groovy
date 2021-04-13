#!/usr/bin/env groovy
import org.apache.commons.csv.*
import org.jenkinsci.plugins.*
import java.util.stream.*

def call() {

def Headers="AppID,AppName,ReleaseVersion,EnvironmentsPassed,EnvironmentFailed,Comments"
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

	File file = new File("D:\\Demo-Pipeline\\CSV-Jenkins\\output.csv")
	file.append(Headers)

println "********************************"
List<CSVRecord> PassedList;
List<CSVRecord> FailedList;
def failedEnvList="NA";
def passedEnvList="NA";
for (Map.Entry<String, List<CSVRecord>> entry : result.entrySet()) {
   
	def  buildList = entry.getValue();
	PassedList= buildList.findAll{f -> !f.get("Status").contains("Failed")}
	FailedList =  buildList.findAll{it.Status.contains("Failed")}
	
	//println "---------------------Passed-----------------------------"
	//println"$PassedList"
	//println "---------------------Failed-----------------------------"
	println "$FailedList"
	if (PassedList != null && PassedList.size() > 0) {
		 def arrr = PassedList.collect{it.Environment}
		passedEnvList = arrr.join('|')
	}
	if (FailedList != null && FailedList.size() > 0) {
		 def arrr1 = FailedList.collect{it.Environment}
		failedEnvList = arrr1.join('|')
	}

	
	//println "+++++++++++++++++++++++++++"
	//println "$passedEnvList"
	//println "$failedEnvList"
	//println "+++++++++++++++++++++++++++"
	
	File file = new File("D:\\Demo-Pipeline\\CSV-Jenkins\\output.csv")
	file.append("\n")
	file.append(buildList.get(0).get("AppID"))
	}
	
	

  }