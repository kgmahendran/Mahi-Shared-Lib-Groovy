#!/usr/bin/env groovy

def call(String command){
bat label: '', script: '${command}'
}