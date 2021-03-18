import org.apache.commons.csv.*
def call()
{


Reader filereader=new FileReader("D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv")	
Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(filereader);
    for (CSVRecord csvRecord : records) {
		def APPID=csvRecord.get(0)
        println "$APPID"
    }

}