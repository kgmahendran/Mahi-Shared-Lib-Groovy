#!/usr/bin/env groovy

def call(Map stageParams) {

    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
		credentialsId: '12afdeaa-e9f3-4be8-bc17-64ccba068dbe'
    ])
  }