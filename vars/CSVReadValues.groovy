def call()
{

def csvfilepath="D:/Demo-Pipeline/CSV-Jenkins/input.csv"

File CSVfilecontent=new File(csvfilepath)

println CSVfilecontent.text

println "############  List ################"

def records = readCSV file: 'D:/Demo-Pipeline/CSV-Jenkins/input.csv'
assert records[0][0] == 'key'
assert records[1][1] == 'b'

println "$key $b $records[0][0]"

}