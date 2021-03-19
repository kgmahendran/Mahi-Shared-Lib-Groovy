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

StringBuilder sb = new StringBuilder();
sb.append(header);

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
	
	List<CSVRecord> passedList = buildList.stream().filter({f -> !f.get("Status").contains("Failed")})
	.collect(Collectors.toList());
	
	String delimitter = ",";
	String passedEnvList = "NA";
	String failedEnvList = "NA";
	String comments = "NA";
	
	if (passedList != null && passedList.size() > 0) {
		passedEnvList = passedList.stream().map({mp -> mp.get("Environment")}).collect(Collectors.joining("|"));
		comments="Passed";
	}
	if (failedList != null && failedList.size() > 0) {
		failedEnvList = failedList.stream().map({mp -> mp.get("Status")}).collect(Collectors.joining("|"));
		comments="Failed";
	}
	
	sb.append('\n');
	sb.append(buildList.get(0).get("AppID") + delimitter);
	sb.append(buildList.get(0).get("AppName") + delimitter);
	sb.append(buildList.get(0).get("ReleaseVersion") + delimitter);
	sb.append(passedEnvList + delimitter);
	sb.append(failedEnvList + delimitter);
	sb.append(comments + delimitter);	

}

PrintWriter writer;
try {
	writer = new PrintWriter(new File("D:\\Demo-Pipeline\\CSV-Jenkins\\test.csv"))
	writer.write(sb.toString());
	System.out.println("done!");

}

catch (FileNotFoundException e) {
	System.out.println(e.getMessage());
}
finally {
	writer.close();
}

}