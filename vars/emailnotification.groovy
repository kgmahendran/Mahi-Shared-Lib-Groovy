def call()
{
emailext attachLog: true, attachmentsPattern: 'Release_Status.csv', 
body: '${SCRIPT, template="groovy-html.template"}', 
subject: '[Jenkins_Pipeline]::[CSV Read] #BuildNumber : $BUILD_NUMBER #Status : $BUILD_STATUS', 
to: 'mahivalarmathi1@gmail.com,mahendran.irusappan@cognizant.com'
}