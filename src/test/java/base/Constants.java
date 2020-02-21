package base;

import java.io.File;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import elasticUtils.LogMatrics;
import pages.LoginPage;
import utils.ReadProperty;
import utils.ReadXMLData;

public class Constants {
	static String currentDir = System.getProperty("user.dir");
	final String elasticIndex = "";
	final String indexType = "";
	static final String CONFIG_FILE_NAME = ReadProperty.getPropertyValue("ConfigurationFileName");
	static final String REPORT_FOLDER = ReadProperty.getPropertyValue("REPORT_FOLDER");
	static final String SCREENSHOT_FOLDER = ReadProperty.getPropertyValue("SCREENSHOT_FOLDER");
	static final String VIDEOS_FOLDER = ReadProperty.getPropertyValue("VIDEOS_FOLDER");
	static final String TESTDATA_FOLDER = ReadProperty.getPropertyValue("TESTDATA_FOLDER");
	static final String RESOURCES_FOLDER = TESTDATA_FOLDER + "/" + ReadProperty.getPropertyValue("RESOURCES_FOLDER")
			+ "/";
	static final String DOWNLOADS_FOLDER = ReadProperty.getPropertyValue("DOWNLOADS_FOLDER");
	static final String DEPENDENCIES_FOLDER = (currentDir + File.separator
			+ ReadProperty.getPropertyValue("DEPENDENCIES_FOLDER"));
	static final String APPLICATIONS_FOLDER = (currentDir + File.separator
			+ ReadProperty.getPropertyValue("APPLICATIONS_FOLDER"));
	static final int DEFAULT_PAUSE_INSECONDS = 2;
	String paginationValue = "25";
	static boolean booleanValue = false;
	Boolean failure = false;
	String reason = "None";
	String detailedFailureReason = "None";
	String stacktrace = "None";
	float ScriptExecution = 50;
	long endTime;
	long end = Long.MIN_VALUE;
	long start = Long.MAX_VALUE;
	long startMS;
	protected static int setupCounter = 0;
	boolean maskingAllowed = Boolean.parseBoolean(ReadProperty.getPropertyValue("MaskingAllowed"));
	boolean viewReport = Boolean.parseBoolean(ReadProperty.getPropertyValue("ViewReport"));
	protected int GENERAL_TIMEOUT = 30;
	public boolean logDefectAutomated = false;
	String test_data_folder_path;
	String screenshot_folder_path;
	String resources_folder_path;
	String configFilePath;
	int MAX_WAIT_TIME_IN_SEC = Integer.parseInt(ReadProperty.getPropertyValue("MAX_WAIT_TIME_IN_SEC"));
	Date testStartTime;
	protected WebDriver driver;
	Wait<WebDriver> wait;
	static URL remote_grid;
	int reloadCounter = 0;
	ReadXMLData configFileObj;
	ReadXMLData fwTestData = null;
	protected boolean isRemoteEnable;
	// Selenium hub IP
	protected String hubUrl;
	// Selenium hub port
	protected String hubPort;
	public String testUrl;
	protected String targetBrowser;
	boolean recordSessionVideo = false;
	static boolean incognito;
	static ReadXMLData readFilePath = null;
	protected static String proxyIP;
	protected static String proxyPort;
	String regexTCID;
	String regexAuthor;
	LoginPage loginPage;
	LogMatrics logMatrics = new LogMatrics(elasticIndex, indexType);
}
