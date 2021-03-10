#!/usr/bin/env groovy

def call (Map getval) {
	rtUpload (
		serverId: '${getval.ARTIFACTORY_NAME}',
			spec: '''{
				"files": [
					{
					"pattern": "target/*.war",
					"target": "getval.REPO_NAME/getval.JOB_NAME/getval.BUILD_NUMBER/"
				}
			]
		}''',
	buildName: 'getval.JOB_NAME'
	)
}