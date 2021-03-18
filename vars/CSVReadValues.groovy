def call()
{

def csvfilepath="D:/Demo-Pipeline/CSV-Jenkins/input.csv"

File CSVfilecontent=new File(csvfilepath)

println CSVfilecontent.text

println "############  List ################"

def records=readCSV file: 'D:/Demo-Pipeline/CSV-Jenkins/input.csv', text: ''

    for (CSVRecord record : records) {
        for (int i = 0; i < record.size(); i++) {
            System.out.println("At " + i + ": " + record.get(i));
        }
    }

}


