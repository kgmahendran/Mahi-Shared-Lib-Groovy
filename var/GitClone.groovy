def call(Map getval) {

    checkout([
        $class: 'GitSCM',
        branches: [[name:  getval.branch ]],
        userRemoteConfigs: [[ url: getval.url ]]
    ])
  }