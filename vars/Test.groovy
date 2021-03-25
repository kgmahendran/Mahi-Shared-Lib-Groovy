def call() {
def records=readCSV file: 'D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv', text: ''
println "$records"
println"++++++++++++++++++++++++++++"
//print"$records.get("AppID")"
println"++++++++++++++++++++++++++++"
print"$records.get(0)"
}