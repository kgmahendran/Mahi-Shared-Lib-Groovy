#!/usr/bin/env groovy

def call(string command){
bat label: '', script: '${command}'
}