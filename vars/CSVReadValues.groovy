def call()
{

def csvfilepath="D:/Demo-Pipeline/CSV-Jenkins/input.csv"

File CSVfilecontent=new File(csvfilepath)

println CSVfilecontent.text

println "############  List ################"

def SAMPLE_CSV_FILE_PATH="D:/Demo-Pipeline/CSV-Jenkins/input.csv"
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());

for (CSVRecord csvRecord : csvParser) {
                // Accessing values by Header names
                def AppID = csvRecord.get("AppID");
                String AppName = csvRecord.get("AppName");
                String Environment = csvRecord.get("Environment");
                def  ReleaseVersion = csvRecord.get("ReleaseVersion");
				def Status = csvRecord.get("Status");

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("AppID : " + AppID);
                System.out.println("AppName : " + AppName);
                System.out.println("Environment : " + Environment);
                System.out.println("ReleaseVersion : " + ReleaseVersion);
				System.out.println("Status : " + Status);
                System.out.println("---------------\n\n");
            }
}


