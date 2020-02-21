package base;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import elasticUtils.LogMatrics;
import pages.LoginPage;
import utils.ReadProperty;
import utils.ReadXMLData;
import utils.Utility;

public class SetupInit extends Constants {

	public static final int DEFAULT_PAUSE_INSECONDS = 2;
	public String paginationValue = "25";
	public static boolean booleanValue = false;
	protected Boolean failure = false;
	protected String reason = "None";
	protected String detailedFailureReason = "None";
	protected String stacktrace = "None";
	protected float ScriptExecution = 50;
	private long endTime;
	long end = Long.MIN_VALUE;
	long start = Long.MAX_VALUE;
	long startMS;
	LogMatrics logMatrics = new LogMatrics(elasticIndex, indexType);

	private static int setupCounter = 0;
	public boolean maskingAllowed = Boolean.parseBoolean(ReadProperty.getPropertyValue("MaskingAllowed"));
	public boolean viewReport = Boolean.parseBoolean(ReadProperty.getPropertyValue("ViewReport"));
	public static String configFileName = ReadProperty.getPropertyValue("ConfigurationFileName");
	public static String dkycFile = ReadProperty.getPropertyValue("DKYCFileName");
	public final String REPORT_FOLDER = ReadProperty.getPropertyValue("REPORT_FOLDER") + File.separator;
	public final String SCREENSHOT_FOLDER = ReadProperty.getPropertyValue("SCREENSHOT_FOLDER");
	public final String VIDEOS_FOLDER = ReadProperty.getPropertyValue("VIDEOS_FOLDER");
	public final String TESTDATA_FOLDER = ReadProperty.getPropertyValue("TESTDATA_FOLDER");
	public final String RESOURCES_FOLDER = TESTDATA_FOLDER + "/" + ReadProperty.getPropertyValue("RESOURCES_FOLDER")
			+ "/";
	public final String DOWNLOADS_FOLDER = ReadProperty.getPropertyValue("DOWNLOADS_FOLDER") + "/";
	public final String currentDir = System.getProperty("user.dir");
	public final String DEPENDENCIES_FOLDER = (currentDir + "\\" + ReadProperty.getPropertyValue("DEPENDENCIES_FOLDER")
			+ "\\");
	public final String APPLICATIONS_FOLDER = (currentDir + "\\" + ReadProperty.getPropertyValue("APPLICATIONS_FOLDER")
			+ "\\");
	public final String MOBILE_APP_PACKAGE_NAME = ReadProperty.getPropertyValue("MOBILE_APP_PACKAGE_NAME");
	private int GENERAL_TIMEOUT = 30;
	// private int MOBILE_GENERAL_TIMEOUT = 15;
	private int MAX_WAIT_TIME_IN_SEC = Integer.parseInt(ReadProperty.getPropertyValue("MAX_WAIT_TIME_IN_SEC"));
	private int POLLING_MAX_TIME_IN_MILLISEC = 400;
	public Date testStartTime;
	protected WebDriver driver;
	Wait<WebDriver> wait;
	static URL remote_grid;
	int reloadCounter = 0;
	public ReadXMLData configFileObj;
	protected ReadXMLData fwTestData = null;

	/* Minimum requirement for test configuration */
	protected boolean isRemoteEnable;
	protected String hubUrl; // Selenium hub IP
	protected String hubPort; // Selenium hub port
	protected String appWaitActivity;

	public String testUrl;

	protected String targetBrowser;

	protected static String test_data_folder_path = null;
	protected static String screenshot_folder_path = null;
	protected static String resources_folder_path = null;
	public boolean logDefectAutomated = false;
	public boolean recordSessionVideo = false;
	private static boolean incognito;
	static ReadXMLData readFilePath = null;
	protected static String proxyIP;
	protected static String proxyPort;
	String regexTCID;
	String regexAuthor;
	String sessionid = "";
	String videoURL = "";
	LoginPage loginPage;
	// CommonVariables log = new CommonVariables();

	protected enum Condition {
		isDisplayed, isClickable, isPresent
	}

	protected enum Speed {
		slow
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void initializeSetupInit(@Optional String browserType, @Optional String testUrl, ITestContext testContext) {
		this.targetBrowser = browserType;
		this.testUrl = testUrl;
		test_data_folder_path = new File(TESTDATA_FOLDER).getAbsolutePath() + "\\";
		screenshot_folder_path = new File(SCREENSHOT_FOLDER).getAbsolutePath() + "\\";
		resources_folder_path = new File(RESOURCES_FOLDER).getAbsolutePath() + "\\";
		File downloadsDirectoryName = new File(DOWNLOADS_FOLDER);
		if (!downloadsDirectoryName.exists()) {
			downloadsDirectoryName.mkdir();
		}
		Utility.removeFolder("allure-report");
		if (setupCounter == 0) {
			Utility.removeFolder(ReadProperty.getPropertyValue("REPORT_FOLDER"));
			setupCounter++;
		}
		fetchSuiteConfiguration("Master");
		testStartTime = new Date();
		if (isRemoteEnable) {
			try {
				remote_grid = new URL("http://" + hubUrl + ":" + hubPort + "/wd/hub");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		}
		if (recordSessionVideo == true) {
			File f = new File(REPORT_FOLDER + VIDEOS_FOLDER);
			if (!f.exists()) {
				f.mkdirs();
			}

		}
		try {
			setDriver(targetBrowser);
			pauseInSeconds(5);
			testContext.setAttribute("WebDriver", this.driver);
		} catch (Exception e) {
			System.out.println(e);
		}
		this.driver.get(testUrl);
		String userNameVal = getTestData("Admin", "username");
		String passwordVal = commonWeb.getTestData("Admin", "password");
		loginPage = new LoginWeb(this.driver);
		loginPage.login(userNameVal, passwordVal);
	}

	public void pauseInSeconds(int i) {
		try {
			Thread.sleep(1000 * i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void defaultPause() {
		try {
			Thread.sleep(1000 * DEFAULT_PAUSE_INSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void setDriver(String browserType) {
		String toLowerCase = browserType.toLowerCase();
		switch (toLowerCase.hashCode()) {
		case -1361128838:
			if (toLowerCase.equals("chrome")) {
				this.driver = initChromeDriver();
				return;
			}
		case -1115062407:
			if (toLowerCase.equals("headless")) {
				this.driver = initChromeHeadlessDriver();
				return;
			}
		case -849452327:
			if (toLowerCase.equals("firefox")) {
				this.driver = initFirefoxDriver();
				return;
			}
		case 3356:
			if (toLowerCase.equals("ie")) {
				this.driver = initIEDriver();
				return;
			}
		case 472085556:
			if (toLowerCase.equals("chromeproxy")) {
				this.driver = initChromeProxyDriver();
				return;
			}
		case -1862645963:
			if (toLowerCase.equals("firefoxproxy")) {
				this.driver = initFirefoxProxyDriver();
				return;
			}
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			this.driver = initFirefoxDriver();
			return;
		}
	}

	private WebDriver initChromeHeadlessDriver() {
		System.setProperty("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments(new String[] { "headless" });
		chromeOptions.addArguments(new String[] { "window-size=1200x600" });
		driver = new ChromeDriver(chromeOptions);
		return driver;
	}

	private WebDriver initChromeDriver() {
		System.out.println("Launching google chrome with new profile..");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", Integer.valueOf(0));
		chromePrefs.put("download.default_directory", DOWNLOADS_FOLDER);
		System.setProperty("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		if (incognito)
			options.addArguments("--incognito");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extenstions");
		options.addArguments(new String[] { "disable-infobars" });
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("acceptSslCerts", true);
		// capabilities.setCapability("goog:chromeOptions", options);
		// capabilities.setCapability("screen-resolution", "1280x1024");
		options.merge(capabilities);
		if (isRemoteEnable) {
			capabilities.setCapability("goog:chromeOptions", options);
			driver = new RemoteWebDriver(remote_grid, capabilities);
			return driver;
		}
		driver = new ChromeDriver(options);
		return driver;
	}

	private WebDriver initFirefoxDriver() {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", DEPENDENCIES_FOLDER + "geckodriver.exe");
		// DesiredCapabilities dc = DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("gecko", true);
		if (isRemoteEnable) {
			driver = new RemoteWebDriver(remote_grid, options);
			return driver;
		}
		driver = new FirefoxDriver(options);
		return driver;
	}

	private WebDriver initIEDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		InternetExplorerOptions options = new InternetExplorerOptions();
		capabilities.setPlatform(Platform.ANY);
		capabilities.setBrowserName("internet explorer");
		// capabilities.setVersion("8.0");
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		capabilities.setJavascriptEnabled(true);
		if (isRemoteEnable) {
			driver = new RemoteWebDriver(remote_grid, capabilities);
			return driver;
		}

		options.merge(capabilities);
		driver = new InternetExplorerDriver(options);
		return driver;
	}

	private WebDriver initChromeProxyDriver() {
		configFileObj = new ReadXMLData(test_data_folder_path + configFileName);
		proxyIP = configFileObj.get("Proxy", "ProxyIP");
		proxyPort = configFileObj.get("Proxy", "ProxyPort");
		System.setProperty("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(proxyIP + ":" + proxyPort);
		proxy.setFtpProxy(proxyIP + ":" + proxyPort);
		proxy.setSslProxy(proxyIP + ":" + proxyPort);
		proxy.setSocksProxy(proxyIP + ":" + proxyPort);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setProxy(proxy);
		chromeOptions.addArguments("test-type");
		if (incognito)
			chromeOptions.addArguments("--incognito");
		chromeOptions.addArguments("disable-infobars");
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		capabilities.setCapability("webdriver.chrome.driver", DEPENDENCIES_FOLDER + "chromedriver.exe");
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setBrowserName("chrome");
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("proxy", proxy);

		chromeOptions.merge(capabilities);
		if (isRemoteEnable) {
			driver = new RemoteWebDriver(remote_grid, capabilities);
			return driver;
		}
		driver = new ChromeDriver(chromeOptions);
		return driver;
	}

	private WebDriver initFirefoxProxyDriver() {
		FirefoxProfile profile1 = new FirefoxProfile();
		configFileObj = new ReadXMLData(test_data_folder_path + configFileName);
		proxyIP = configFileObj.get("Proxy", "ProxyIP");
		proxyPort = configFileObj.get("Proxy", "ProxyPort");
		System.setProperty("webdriver.gecko.driver", DEPENDENCIES_FOLDER + "geckodriver.exe");
		profile1.setPreference("dom.max_chrome_script_run_time", "999");
		profile1.setPreference("dom.max_script_run_time", "999");
		profile1.setPreference("browser.download.folderList", 2);
		profile1.setPreference("browser.download.useDownloadDir", true);
		profile1.setPreference("browser.download.manager.showWhenStarting", false);
		profile1.setPreference("javascript.enabled", true);
		profile1.setPreference("network.http.use-cache", false);
		profile1.setPreference("network.proxy.type", 1);
		profile1.setPreference("network.proxy.http", proxyIP);
		profile1.setPreference("network.proxy.http_port", proxyPort);
		profile1.setPreference("network.proxy.ssl", proxyIP);
		profile1.setPreference("network.proxy.ssl_port", proxyPort);
		profile1.setPreference("network.proxy.ftp", proxyIP);
		profile1.setPreference("network.proxy.ftp_port", proxyPort);
		profile1.setPreference("network.proxy.socks", proxyIP);
		profile1.setPreference("network.proxy.socks_port", proxyPort);
		FirefoxOptions options1 = new FirefoxOptions();
		options1.setProfile(profile1);
		options1.setAcceptInsecureCerts(true);
		if (isRemoteEnable) {
			driver = new RemoteWebDriver(remote_grid, options1);
			return driver;
		}
		driver = new FirefoxDriver(options1);
		return driver;
	}

	public WebElement findVisibleElement(By locator, int... time) {
		return waitAndFindElement(locator, Condition.isDisplayed, getTimeOut(time));
	}

	public WebElement findPresentElement(By locator, int... time) {
		return waitAndFindElement(locator, Condition.isPresent, getTimeOut(time));
	}

	private int getTimeOut(int[] time) {
		int timeOut = MAX_WAIT_TIME_IN_SEC;
		if (time.length != 0)
			if (time[0] > 0)
				timeOut = time[0];
		return timeOut;
	}

	private WebElement waitAndFindElement(By locator, Condition condition, int time) {
		WebElement foo = null;
		do {
		} while (!waitForLoader());
		do {
		} while (!isAjaxCallCompleted());

		this.wait = new WebDriverWait(driver, time);
		switch (condition) {
		case isClickable:
			try {
				foo = (WebElement) this.wait.until(ExpectedConditions.elementToBeClickable(locator));
			} catch (Exception e) {
			}
			break;
		case isDisplayed:
			try {
				foo = (WebElement) this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			} catch (Exception e) {
			}
			break;
		case isPresent:
			try {
				foo = (WebElement) this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			} catch (Exception e) {
			}
			break;
		}
		if (foo != null)
			if (!isVisibleInViewport(foo))
				scrollToElement(foo);
		return foo;
	}

	protected void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		if (!isVisibleInViewport(element)) {
			((JavascriptExecutor) driver).executeScript(
					"window.scrollTo(" + element.getLocation().x + "," + (element.getLocation().y - 80) + ");");
		}
	}

	private boolean isAjaxCallCompleted() {
		WebDriverWait wait = new WebDriverWait(this.driver, (long) this.GENERAL_TIMEOUT);
		wait.ignoring(StaleElementReferenceException.class);
		try {
			return ((Boolean) wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver inDriver) {
					boolean z = SetupInit.this.isJQueryLoaded() && SetupInit.this.isJSLoaded();
					return Boolean.valueOf(z);
				}

				public String toString() {
					return "Waiting for Ajax call to be completed";
				}
			})).booleanValue();
		} catch (TimeoutException e) {
			return false;
		}
	}

	private boolean isJSLoaded() {
		return ((JavascriptExecutor) this.driver).executeScript("return document.readyState", new Object[0]).toString()
				.equals("complete");
	}

	public boolean isJQueryLoaded() {
		try {
			return ((Long) ((JavascriptExecutor) this.driver).executeScript("return jQuery.active", new Object[0]))
					.longValue() == 0;
		} catch (Exception e) {
			return true;
		}
	}

	protected boolean isVisibleInViewport(WebElement element) {
		return ((Boolean) ((JavascriptExecutor) ((RemoteWebElement) element).getWrappedDriver()).executeScript(
				"var elem = arguments[0],                   box = elem.getBoundingClientRect(),      cx = box.left + box.width / 2,           cy = box.top + box.height / 2,           e = document.elementFromPoint(cx, cy); for (; e; e = e.parentElement) {           if (e === elem)                            return true;                         }                                        return false;                            ",
				new Object[] { element })).booleanValue();
	}

	public boolean isLoderDisplayed(By locator) {
		boolean state = false;
		try {
			state = driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			state = false;
		}
		return state;
	}

	public boolean isDisplayed(By locator, int... wait) {
		boolean state = false;
		WebElement element = findVisibleElement(locator, getTimeOut(wait));
		try {
			state = element.isDisplayed();
		} catch (Exception e) {
			RuntimeException re = new RuntimeException();
		}
		return state;
	}

	public boolean waitForLoader() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (isLoderDisplayed(By.xpath("//html[@class='nprogress-busy']"))) {
			Instant currentTime = getCurrentTime();
			while (isLoderDisplayed(By.xpath("//html[@class='nprogress-busy']"))) {
				Instant loopingTime = getCurrentTime();
				Duration timeElapsed = Duration.between(currentTime, loopingTime);
				long sec = timeElapsed.toMillis() / 1000;
				int durDiff = (int) sec;
				if (durDiff >= MAX_WAIT_TIME_IN_SEC) {
					reloadCurrentPage();
					reloadCounter++;
					if (reloadCounter == 3)
						driver.close();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public void makeScreenshot(String screenShotName, File screenShotLoaction) {
		File screenshot;
		WebDriver augmentedDriver = null;
		augmentedDriver = new Augmenter().augment(driver);
		screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		try {
			File f = new File(screenShotLoaction + File.separator + screenShotName);
			FileUtils.copyFile(screenshot, f);
		} catch (IOException e) {
			e.printStackTrace();
			commonWeb = new Common();
			commonWeb.log("Failed to capture screenshot:" + e.getMessage());
		}
		commonWeb = new Common();
		commonWeb.log(createScreenshotLink(screenShotName, screenShotLoaction.toString()));
	}

	public String makeScreenshot(String testClassName, String testMethod) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		String currentTime = timeFormat.format(date);
		String currentDir = System.getProperty("user.dir");
		String folderPath = currentDir + File.separator + "Failure_Screenshots" + File.separator + testClassName
				+ File.separator + currentDate.replaceAll("/", "_");
		folderPath = folderPath.trim();
		String screenshotName = currentTime.replace(":", "_") + ".png";
		String filePath = folderPath + File.separator + testMethod + "_" + screenshotName;
		filePath = filePath.trim();
		File screenshotLocation = new File(folderPath);
		if (!screenshotLocation.getAbsoluteFile().exists())
			screenshotLocation.mkdir();
		File screenshot;
		WebDriver augmentedDriver = null;
		augmentedDriver = new Augmenter().augment(driver);
		screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		try {
			File f = new File(filePath);
			FileUtils.copyFile(screenshot, f);
			return filePath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed to capture a sccreenshot";
	}

	/**
	 * @author vivek.mishra
	 * @return the current URL
	 * @created on 25/02/2019
	 */
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	/**
	 * @author dishant.doshi to reload current url
	 * @creation date 23/11/2018
	 */
	public void reloadCurrentPage() {
		String url = getCurrentURL();
		driver.get(url);
	}

	// ################ Supporting methods
	// ####################################################################################################

	protected void logException(Throwable e, Map<Object, Object> map) {
		// map.put("Steps To Reproduce", logList);
		stacktrace = Utility.getStackStrace(e);
		Scanner sc = new Scanner(stacktrace);
		String firstLine = sc.nextLine();
		sc.close();
		Map<String, Object> dataMap = getDataMap(map);
		dataMap.put("Failure Reason", firstLine);
		dataMap.put("Datailed Failure Reason", stacktrace);
		endTime = System.currentTimeMillis();
		if (endTime > end)
			end = endTime / 1000;
		if ((Long) dataMap.get("Test Start Time") < start) {
			startMS = (Long) dataMap.get("Test Start Time");
			start = startMS / 1000;
		}
		dataMap.put("Test Start Time", Utility.formatTime(startMS));
		dataMap.put("Test End Time", Utility.formatTime(endTime));
		dataMap.put("Total Execution Time", Utility.millisToTimeConversion(end - start));
		String clsName = dataMap.get("Class Name").toString();
		String className = clsName.contains(".") ? clsName.substring(clsName.lastIndexOf('.') + 1) : clsName;
		dataMap.put("Failed Screenshot path", makeScreenshot(className, dataMap.get("Method Name").toString()));
		logMatrics.logToElasticsearch(dataMap);
		e.printStackTrace();
	}

	public Map<String, Object> getDataMap(Map<Object, Object> map) {
		Map<String, Object> dataToDump = new HashMap<>();
		for (Map.Entry<Object, Object> e : map.entrySet()) {
			dataToDump.put(e.getKey().toString(), e.getValue());
		}
		dataToDump.put("Executor IP", getIPOfNode());
		return dataToDump;
	}

	public String getIPOfNode() {
		// boolean isRemote = Boolean.parseBoolean(ReadProperty.getPropertyValue(""));
		boolean isRemote = Boolean.parseBoolean(Utility.getTestData(configFilePath, "Master", "isRemoteEnable"));
		if (isRemote) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String hostFound = null;
			try {
				HttpCommandExecutor ce = (HttpCommandExecutor) ((RemoteWebDriver) this.driver).getCommandExecutor();
				String hostName = ce.getAddressOfRemoteServer().getHost();
				int port = ce.getAddressOfRemoteServer().getPort();
				HttpHost host = new HttpHost(hostName, port);
				HttpClient client = new DefaultHttpClient();
				URL sessionURL = new URL("http://" + hostName + ":" + port + "/grid/api/testsession?session="
						+ ((RemoteWebDriver) this.driver).getSessionId());
				BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST",
						sessionURL.toExternalForm());
				HttpResponse response = client.execute(host, r);
				JSONObject object = extractObject(response);
				URL myURL = new URL(object.getString("proxyId"));
				if ((myURL.getHost() != null) && (myURL.getPort() != -1)) {
					hostFound = myURL.getHost();
				}
			} catch (Exception e) {
				System.err.println(e);
			}
			return hostFound;
		} else {
			String inetAddress = null;
			try {
				inetAddress = InetAddress.getLocalHost().toString();
			} catch (UnknownHostException e) {
			}
			return inetAddress;
		}
	}

	public JSONObject extractObject(HttpResponse resp) throws IOException, JSONException {
		InputStream contents = resp.getEntity().getContent();
		StringWriter writer = new StringWriter();
		IOUtils.copy(contents, writer, "UTF8");
		JSONObject objToReturn = new JSONObject(writer.toString());
		return objToReturn;
	}

	public String getCurrentMethodName() {
		return new Throwable().getStackTrace()[0].getMethodName();
	}

	public String createScreenshotLink(String screenShotName, String link_text) {
		return "<br><Strong><font color=#FF0000>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Failed screenshot name = </font></strong><a target='_blank' href='../"
				+ link_text + File.separator + screenShotName + "'>" + screenShotName + "</a>";
	}

	/**
	 * @author vivek.mishra
	 * @return current time in integer
	 * @created on 25/02/2019
	 */
	public Instant getCurrentTime() {
		return Instant.now();
	}

	public void fetchSuiteConfiguration(String configuration) {
		configFileObj = new ReadXMLData(test_data_folder_path + configFileName);
		isRemoteEnable = Boolean.parseBoolean(configFileObj.get(configuration, "isRemoteEnable"));
		incognito = Boolean.parseBoolean(configFileObj.get(configuration, "incognito"));
		if (isRemoteEnable) {
			hubUrl = configFileObj.get(configuration, "Hub");
			hubPort = configFileObj.get(configuration, "Port");
		}
		logDefectAutomated = new Boolean(configFileObj.get(configuration, "AutoLogDefectInJira"));
		recordSessionVideo = new Boolean(configFileObj.get(configuration, "RecordVideoOfTestExecution"));
		regexTCID = configFileObj.get("Configuration", "TestIdRegex");
		regexAuthor = configFileObj.get("Configuration", "TestAuthorRegex");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {
		// logList.clear();
		if (!testResult.isSuccess()) {
			System.out.println(testResult);
			Reporter.setCurrentTestResult(testResult);
			String[] testClass = testResult.getTestClass().toString().split("\\.");
			String testClassName = testClass[testClass.length - 1].replace("]", "\\");
			String testMethod = testResult.getName().toString();

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			String currentDate = dateFormat.format(date);
			String currentTime = timeFormat.format(date);

			File screenshotLocation = new File(REPORT_FOLDER + SCREENSHOT_FOLDER + File.separator + testClassName
					+ testMethod + File.separator + currentDate.replaceAll("/", "-"));
			if (!screenshotLocation.getAbsoluteFile().exists())
				screenshotLocation.mkdir();

			String screenshotName = currentTime.replace(":", ";") + ".png";
			Reporter.log("<br> <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Please click for screenshot - </b>");
			makeScreenshot(screenshotName, screenshotLocation);
		}
	}

	@AfterClass
	public void closeBrowser() {
		this.driver.quit();
	}

}