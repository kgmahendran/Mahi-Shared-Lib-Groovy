#!/usr/bin/env groovy

def call(String cmd){
bat label: '', script: '${cmd}'
}