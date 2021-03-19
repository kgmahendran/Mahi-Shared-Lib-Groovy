import org.apache.commons.csv.*
import java.util.stream.*
@NonCPS
def call()
{


String[] HEADERS = ["AppID","AppName","Environment","ReleaseVersion","Status"]


Reader filereader = new FileReader("D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv");
Iterable<CSVRecord> records = CSVFormat.DEFAULT
		.withHeader(HEADERS)
		.withFirstRecordAsHeader()
		.parse(filereader);


Map<String, List<CSVRecord>> recordListBySK =   StreamSupport
		.stream(records.spliterator(), false).
		collect(Collectors.groupingBy({record -> record.get("AppID")} ));
		

recordListBySK.each { key,value ->
		println "$key : $value"
}

}