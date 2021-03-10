#!/usr/bin/env groovy

def call (String ARTIFACTORY_NAME, String REPO_NAME, String JOB_NAME, int  BUILD_NUMBER) {
	rtUpload (
		serverId: ${ARTIFACTORY_NAME},
			spec: '''{
				"files": [
					{
					"pattern": "target/*.war",
					"target": "${REPO_NAME}/${JOB_NAME}/${BUILD_NUMBER}/"
				}
			]
		}''',
	buildName: ${JOB_NAME}
	)
}