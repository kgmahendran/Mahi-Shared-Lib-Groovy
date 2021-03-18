import org.apache.commons.csv.*
def call()
{


Reader filereader=new FileReader("D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv")	
Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(filereader);
    for (CSVRecord csvRecord : records) {
        println "${csvRecord.get(0)} ${csvRecord.get(1)} ${csvRecord.get(2)} ${csvRecord.get(3)} ${csvRecord.get(4)}"
    }

}