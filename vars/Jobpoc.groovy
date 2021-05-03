#!/usr/bin/env groovy
import org.apache.commons.csv.*
import org.jenkinsci.plugins.*

def call() {
	def records = readCSV file: 'Job.csv' , format: CSVFormat.DEFAULT.withHeader().withFirstRecordAsHeader()
	def result = records.groupBy({record -> record.get("Stages")+"-"+record.get("IsDepndent")+"-"+record.get("jobType")})

	result.each {key,value ->
		println "$key : $value"
	}
	

	for (Map.Entry<String, List<CSVRecord>> entry : result.entrySet()) {
		
		def  buildList = entry.getValue();
		buildList.each{println it.jobName}
	 
	 //println (buildList.getValue("jobName"))
	 
	}
	 
	 /*8PassedList= buildList.findAll{f -> !f.get("Status").contains("Failed")}
	 FailedList =  buildList.findAll{it.Status.contains("Failed")}
	 if (PassedList != null && PassedList.size() > 0) {
	 def arrr = PassedList.collect{it.Environment}
	 passedEnvList = arrr.join('|')
	 Comments="Passed";
	 }
	 if (FailedList != null && FailedList.size() > 0) {
	 def arrr1 = FailedList.collect{it.Environment}
	 failedEnvList = arrr1.join('|')
	 Comments="Failed";
	 }
	 file.append("\n")
	 file.append(buildList.get(0).get("AppID") + Spliter + (buildList.get(0).get("AppName")) + Spliter + buildList.get(0).get("ReleaseVersion") + Spliter + passedEnvList + Spliter +failedEnvList + Spliter + Comments)
	 }
	 println "+++++++++++++ Output ++++++++++++"
	 println file.text
	 println "+++++++++++++++++++++++++++++++"*/
}