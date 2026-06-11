Feature: This test case contains login with different data


	
	Scenario Outline: To verify application login with different useres

	Given browser for sauceLab should be open
	And valid URL of sauceLab should be passed
	When user enter valid username "<username>" and password "<password>" of sauceLab
	And user should click on login button of sauceLab
	Then login successfully of sauceLab
	
	
	Examples: UernameAndPassword
	|username||password|
	|standard_user||secret_sauce|
	|visual_user||secret_sauce|
	|problem_user||secret_sauce|
	|performance_glitch_user||secret_sauce|
	|error_user||secret_sauce|