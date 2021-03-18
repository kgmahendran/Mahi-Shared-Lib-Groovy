def call()
{

def records = readCSV file: 'D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv'
println "$records[0].CSVrecord.values[0]"

}