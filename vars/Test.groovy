import org.apache.commons.csv.*
import java.util.stream.*

def call()
{


String[] HEADERS = [
	"AppID",
	"AppName",
	"Environment",
	"ReleaseVersion",
	"Status"
]


Reader filereader = new FileReader("D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv");
Iterable<CSVRecord> records = CSVFormat.DEFAULT
		.withHeader(HEADERS)
		.withFirstRecordAsHeader()
		.parse(filereader);


Map<String, List<CSVRecord>> recordListBySK =   StreamSupport
		.stream(records.spliterator(), false).
		collect(Collectors.groupingBy({record -> record.get("AppID")} ));
		


for (Map<String, Integer> skMaxMap : recordListBySK.entrySet()) {
	System.out.println(skMaxMap.getKey());
}

}