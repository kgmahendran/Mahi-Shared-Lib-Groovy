import org.apache.commons.csv.*
import java.util.stream.*
@NonCPS
def call()
{

def BuildDet = new BuildDetails()
String[] HEADERS = ["AppID","AppName","Environment","ReleaseVersion","Status"]


Reader filereader = new FileReader("D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv");
Iterable<CSVRecord> records = CSVFormat.DEFAULT
		.withHeader(HEADERS)
		.withFirstRecordAsHeader()
		.parse(filereader);


Map<String, List<CSVRecord>> recordFiltered =   StreamSupport
		.stream(records.spliterator(), false).
		collect(Collectors.groupingBy({record -> record.get("AppID")+"-"+record.get("AppName")+"-"+record.get("ReleaseVersion")} ));
		

recordFiltered.each { key,value ->
		println "$key : $value"
}

for (Map.Entry<String, List<CSVRecord>> entry : recordFiltered.entrySet()) {
	System.out.println(entry.getKey());
	List<CSVRecord> buildList = entry.getValue();
	
	List<CSVRecord> failedList = buildList.stream().filter({f -> f.get("Status").contains("Failed")})
	.collect(Collectors.toList());
	
	println "$failedList"

}

}