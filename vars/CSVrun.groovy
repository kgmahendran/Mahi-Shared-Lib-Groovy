def call()
{
bat 'groovy ${env.WORKSPACE}/Pipeline-CSVReader@libs/Mahi-Shared-Lib-Groovy/vars/jenkinscsv.groovy'
}