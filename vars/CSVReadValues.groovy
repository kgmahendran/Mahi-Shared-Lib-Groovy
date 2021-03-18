def call()
{

def csvfilepath="D:/Demo-Pipeline/CSV-Jenkins/input.csv"

File CSVfilecontent=new File(csvfilepath)

println CSVfilecontent.text

println "############  List ################"

String[][] records=readCSV file: 'D:/Demo-Pipeline/CSV-Jenkins/input.csv', text: ''

println records

}


