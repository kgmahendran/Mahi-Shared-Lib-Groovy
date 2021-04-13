#!/usr/bin/env groovy
import org.apache.commons.csv.*
import org.jenkinsci.plugins.*

def call() {

	def records = readCSV file: '$WORKSPACE\\Input.csv' , format: CSVFormat.DEFAULT.withHeader().withFirstRecordAsHeader()
	def result = records.groupBy({record -> record.get("AppID")+"-"+record.get("AppName")+"-"+record.get("ReleaseVersion")})
	def Output_Headers="AppID,AppName,ReleaseVersion,EnvironmentsPassed,EnvironmentFailed,Comments"

	File file = new File("$WORKSPACE\\output.csv")
	file.append(Output_Headers)

	List<CSVRecord> Status_Passed;
	List<CSVRecord> Status_Failed;
	def Spliter=","
	def Comments="NA";
	for (Map.Entry<String, List<CSVRecord>> entry : result.entrySet()) {
		def Failed_Env="NA";
		def Passed_Env="NA";
		def  buildList = entry.getValue();
		Status_Passed= buildList.findAll{f -> !f.get("Status").contains("Failed")}
		Status_Failed =  buildList.findAll{it.Status.contains("Failed")}

		if (Status_Passed != null && Status_Passed.size() > 0) {
			def arr_val = Status_Passed.collect{it.Environment}
			Passed_Env = arr_val.join('|')
			Comments="Passed";
		}
		if (Status_Failed != null && Status_Failed.size() > 0) {
			def arr_val1 = Status_Failed.collect{it.Environment}
			Failed_Env = arr_val1.join('|')
			Comments="Failed";
		}

		file.append("\n")
		file.append(buildList.get(0).get("AppID") + Spliter + (buildList.get(0).get("AppName")) + Spliter + buildList.get(0).get("ReleaseVersion") + Spliter + Passed_Env + Spliter +Failed_Env + Spliter + Comments)
	}
}