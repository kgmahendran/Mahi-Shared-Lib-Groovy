def call()
{
emailext attachLog: true, attachmentsPattern: 'D:\\Demo-Pipeline\\Output\\Release_Status.csv', body: '${JELLY_SCRIPT,template="html"}', subject: '[Jenkins_Pipeline]::[CSV Read] #BuildNumber : $BUILD_NUMBER #Status : $BUILD_STATUS', to: 'mahivalarmathi1@gmail.com'
}