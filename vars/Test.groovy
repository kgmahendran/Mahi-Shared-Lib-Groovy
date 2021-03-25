def call() {
def records=readCSV file: 'D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv'
def records1=CSVFormat.EXCEL.withHeader().parse(records);
println "$records1"
println"++++++++++++++++++++++++++++"
//print"$records.get("AppID")"
println"++++++++++++++++++++++++++++"
print"$records1.get(0)"
}