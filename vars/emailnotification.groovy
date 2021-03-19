def call()
{
emailext attachLog: true, attachmentsPattern: 'Release_Status.csv', body: '${JELLY_SCRIPT,template="html-with-health-and-console"}', subject: '[Jenkins_Pipeline]::[CSV Read] #BuildNumber : $BUILD_NUMBER #Status : $BUILD_STATUS', to: 'mahivalarmathi1@gmail.com,mahendran.irusappan@cognizant.com'
}