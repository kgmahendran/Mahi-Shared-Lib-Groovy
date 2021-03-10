#!/usr/bin/env groovy

def call(Map stageParams) {
	 git branch: 'stageParams.branch', credentialsId: '12afdeaa-e9f3-4be8-bc17-64ccba068dbe', url: 'stageParams.url '
  }