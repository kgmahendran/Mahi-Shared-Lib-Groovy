#!/usr/bin/env groovy
import org.apache.commons.csv.*
import org.jenkinsci.plugins.*
import java.util.stream.*
@NonCPS
def call() {


def records = readCSV file: 'D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv' , format: CSVFormat.DEFAULT.withHeader().withFirstRecordAsHeader()

Map<String, List<CSVRecord>> recordFiltered =   StreamSupport
		.stream(records.spliterator(), false).
		collect(Collectors.groupingBy({record -> record.get("AppID")+"-"+record.get("AppName")+"-"+record.get("ReleaseVersion")} ));
		
println("**Read the content and Filterted using #AppID,#AppName and #Release Version**")
println("-----------------------------------------")
recordFiltered.each { key,value ->
		println "$key : $value"
}
  }