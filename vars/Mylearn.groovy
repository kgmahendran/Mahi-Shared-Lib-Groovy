def call(){

		def inputJson = readJSON file: 'ARMTem.json'
		inputJson.resources.each{it.put("condition","false")}
		inputJson.resources.name.each{println it}
		def Read_Deploy_project = readProperties file: 'Deploy_List.properties'
		def KEY_NAME = Read_Deploy_project.keySet();
		for (def i=0;i<KEY_NAME.size();i++)
			{
			def KEY_VALUES = Read_Deploy_project["${KEY_NAME[i]}"].split(',')
			for (def j=0;j<=KEY_VALUES.size();j++)
				{
				inputJson.resources.findAll{
					//println (it.name("${KEY_NAME[j]}")
					if (it.name.contains("${KEY_NAME[j]}") && it.type.contains("${KEY_NAME[i]}"))
						{
						echo "Test"
						it.put("condition","true")
						}
					}
				}
			}
			writeJSON file: 'ARMTem1.json', json: inputJson, pretty: 5;

}
