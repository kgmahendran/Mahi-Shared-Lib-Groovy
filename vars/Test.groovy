import org.apache.commons.csv.*
import java.util.stream.*

class BuildDetails {
	def appId;
	def appName;
	def environment;
	def releaseVersion;
	def status;
	BuildDetails() {}
	BuildDetails(def appId, def appName, def environment, def releaseVersion, def status) {
		super();
		this.appId = appId;
		this.appName = appName;
		this.environment = environment;
		this.releaseVersion = releaseVersion;
		this.status = status;
	}
	int getAppId() {
		return appId;
	}
	void setAppId(int appId) {
		this.appId = appId;
	}
	def  getAppName() {
		return appName;
	}
	def setAppName(String appName) {
		this.appName = appName;
	}
	def getEnvironment() {
		return environment;
	}
	def setEnvironment(String environment) {
		this.environment = environment;
	}
	def getReleaseVersion() {
		return releaseVersion;
	}
	def setReleaseVersion(String releaseVersion) {
		this.releaseVersion = releaseVersion;
	}
	def getStatus() {
		return status;
	}
	def setStatus(String status) {
		this.status = status;
	}
	
	def getCsvfilterval() {
		return getAppId() + "-" + getAppName() + "-" + getReleaseVersion();
	}
}


@NonCPS
def call()
{

def BuildDet = new BuildDetails()
String[] HEADERS = ["AppID","AppName","Environment","ReleaseVersion","Status"]


Reader filereader = new FileReader("D:\\Demo-Pipeline\\CSV-Jenkins\\Input.csv");
Iterable<CSVRecord> records = CSVFormat.DEFAULT
		.withHeader(HEADERS)
		.withFirstRecordAsHeader()
		.parse(filereader);


Map<String, List<CSVRecord>> recordListBySK =   StreamSupport
		.stream(records.spliterator(), false).
		collect(Collectors.groupingBy(BuildDetails.&getCsvfilterval as Function);
		

recordListBySK.each { key,value ->
		println "$key : $value"
}

}