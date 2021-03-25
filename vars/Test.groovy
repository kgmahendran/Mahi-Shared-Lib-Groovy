import org.apache.commons.csv.*
def call() {
def records_values=readCSV file: 'D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv'
Iterable<CSVRecord> records = CSVFormat.DEFAULT
		.withHeader(HEADERS)
		.withFirstRecordAsHeader()
		.parse(records_values);
println "$records"
println"++++++++++++++++++++++++++++"

}