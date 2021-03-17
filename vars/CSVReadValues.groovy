def call()
{

def csvfilepath="D:/Demo-Pipeline/CSV-Jenkins/input.csv"

File CSVfilecontent=new File(csvfilepath)

println CSVfilecontent.text

println "############  List ################"

def records = readCSV file: 'D:/Demo-Pipeline/CSV-Jenkins/input.csv'


println "$records"

println "-----------------------------------------"

def record0= records[0].CSVRecord 
def record1= records[1].CSVRecord 

println "$record0"
println "$record1"
}