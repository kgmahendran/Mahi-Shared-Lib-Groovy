def call()
{

def csvfilepath="D:/Demo-Pipeline/CSV-Jenkins/input.csv"

File CSVfilecontent=new File(csvfilepath)

println CSVfilecontent.text

println "############  List ################"

Reader in = new FileReader("D:/Demo-Pipeline/CSV-Jenkins/input.csv");
Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
for (CSVRecord record : records) {
    String columnOne = record.get(0);
    String columnTwo = record.get(1);
	String columnThree = record.get(2);
	String columnFour= record.get(3);
	String columnFive = record.get(4);
}

println "$record.get(0)"


}


