def call()
{
emailext body: '${JELLY_SCRIPT,template="text"}', subject: '[Jenkins_Pipeline]::[CSV Read] #BuildNumber : $BUILD_NUMBER', to: 'mahivalarmathi1@gmail.com'
}