package listeners;

import java.io.IOException;



import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.Keywords;


public class MyListeners implements ITestListener {

	Keywords keyword = new Keywords();

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			keyword.screenshotByAshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			keyword.screenshotByAshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
