def call()
{

CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader();
CSVParser csvParser = csvFormat.parse(Files.newBufferedReader(Paths.get("D:/Demo-Pipeline/CSV-Jenkins/Input.csv"))) 
    System.out.println(csvParser.getHeaderNames());
    for (CSVRecord csvRecord : csvParser) {
        System.out.println(csvRecord);
        System.out.println("  toMap(): " + csvRecord.toMap());

        Map<String, String> map = csvRecord.toMap();
        for (String name : csvParser.getHeaderNames())
            map.putIfAbsent(name, "");
        System.out.println("  Values  : " + map);
    }


}