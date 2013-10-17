package testProject;

import org.jenkinsci.testinprogress.runner.ProgressSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import test.test.rrrTest;

@RunWith(ProgressSuite.class)
@SuiteClasses({ rrrTest.class})
public class ProgressAllTestsSuite {

}
