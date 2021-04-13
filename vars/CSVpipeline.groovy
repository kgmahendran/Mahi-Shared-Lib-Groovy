#!/usr/bin/env groovy
import org.apache.commons.csv.*
import org.jenkinsci.plugins.*
import java.util.stream.*

def call() {

	def Output_Headers="AppID,AppName,ReleaseVersion,EnvironmentsPassed,EnvironmentFailed,Comments"
	def records = readCSV file: 'Input.csv' , format: CSVFormat.DEFAULT.withHeader().withFirstRecordAsHeader()
	def result = records.groupBy({record -> record.get("AppID")+"-"+record.get("AppName")+"-"+record.get("ReleaseVersion")})
	records.each { key,value ->
		println "$key : $value"
	}
	File file = new File(".\\output.csv")
	file.text = ''
	file.append(Output_Headers)

	List<CSVRecord> PassedList;
	List<CSVRecord> FailedList;
	def Spliter=","
	def Comments="NA";
	for (Map.Entry<String, List<CSVRecord>> entry : result.entrySet()) {
		def failedEnvList="NA";
		def passedEnvList="NA";
		def  buildList = entry.getValue();
		PassedList= buildList.findAll{f -> !f.get("Status").contains("Failed")}
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
}