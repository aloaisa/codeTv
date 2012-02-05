package test;

import groovy.util.GroovyTestCase
import main.VideoFinder

class CodeTv_Tests  extends GroovyTestCase {

    void testReturnAVideoLinkById_1() {

        assert new VideoFinder().getVideoLinkById(1) == "http://vimeo.com/9028476" : "Error to Obtain a StringCalculator Video on Vimeo."
    }
	
	void testReturnAVideoLinkById_2() {
		
		assert new VideoFinder().getVideoLinkById(2) == "http://groovy.org.es/home/story/324" : "Error to Obtain a \"Seminario de introducción a Groovy\" Video."
	}
		
}
