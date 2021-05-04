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
		def JOB_LIST=buildList.jobName
		def CHECK_DEP=buildList.IsDepndent
		def DEP_LIST=buildList.Dependent_Jobs
		for (def i=0;i<JOB_LIST.size();i++)
		{
			if ( "${CHECK_DEP[i]}" ==  "YES" ) {
			build_info=build job: ""+JOB_LIST[i]+""
			def DEP_RES=build_info.result
			if ( "${DEP_RES}" == "SUCCESS" ) {
			build_info=build job: ""+DEP_LIST[i]+""
			}
			}
		
		}
	}
	 

}