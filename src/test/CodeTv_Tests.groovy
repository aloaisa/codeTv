package test;

import groovy.util.GroovyTestCase
import main.VideoFinder

class CodeTv_Tests  extends GroovyTestCase {

    void testReturnAVideoLinkById_1() {

        assert new VideoFinder().getVideoLinkById(1) == "http://vimeo.com/9028476" : "Error to Obtain a " +
				"StringCalculator Video on Vimeo."
    }
	
	void testReturnAVideoLinkById_2() {
		
		assert new VideoFinder().getVideoLinkById(2) == "http://groovy.org.es/home/story/324" : "Error to " +
				"Obtain a \"Seminario de introducción a Groovy\" Video."
	}
		
	void testReturnAVideoLinkById_3() {
		
		assert new VideoFinder().getVideoLinkById(3) == "http://vimeo.com/11931804" : "Error to Obtain a " +
				"\"Groovy y la productividad para desarrolladores Java\" Video."
	}
	
	void testReturnAEmptyLinkById_0() {
		
		assert new VideoFinder().getVideoLinkById(0) == "" : "Error to Obtain a " +
				"Video with id 0."
	}
}
