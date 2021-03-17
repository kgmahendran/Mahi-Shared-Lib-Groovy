def call()
{

def csvfilepath="D:/Demo-Pipeline/CSV-Jenkins/input.csv"

File CSVfilecontent=new File(csvfilepath)

println CSVfilecontent.text

println "############  List ################"



	Reader in = new FileReader("D:/Demo-Pipeline/CSV-Jenkins/input.csv");
    Iterable<CSVRecord> records = CSVFormat.DEFAULT
      .withHeader(HEADERS)
      .withFirstRecordAsHeader()
      .parse(in);
    for (CSVRecord record : records) {
        String author = record.get("AppID");
        String title = record.get("AppName");
		println $author 
		println $title 
    }

}