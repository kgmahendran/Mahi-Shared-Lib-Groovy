#!/usr/bin/env groovy

def call(String CMD) {
bat label: '', script: 'mvn clean ${CMD}'
}
