def call()
{

def records = readCSV file: 'D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv'
println "$records[1].CSVrecord.values[1]"

}