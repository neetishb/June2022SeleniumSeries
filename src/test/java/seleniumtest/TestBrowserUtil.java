package seleniumtest;

public class TestBrowserUtil {

	public static void main(String[] args) throws Exception {
		
		String browser = "Chrome";
		BrowserUtil bUtil = new BrowserUtil();
		bUtil.launchBrowser(browser);
		bUtil.launchUrl("http://www.amazon.com");
		bUtil.getTitle();
		bUtil.getCurrentUrl();
		bUtil.closeBrowser();
	}

}
