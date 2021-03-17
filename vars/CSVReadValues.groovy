def call()
{

def csvfilepath="D:/Demo-Pipeline/CSV-Jenkins/input.csv"

File CSVfilecontent=new File(csvfilepath)

println CSVfilecontent.text

println "############  List ################"

def records = readCSV file: 'D:/Demo-Pipeline/CSV-Jenkins/input.csv'

def Arrayvalues=records as String[]
println "# $Arrayvalues #"

}