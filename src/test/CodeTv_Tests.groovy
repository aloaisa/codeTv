package test;

import groovy.util.GroovyTestCase
import main.VideoFinder

class CodeTv_Tests  extends GroovyTestCase {

    void testReturnAVideoLinkById() {
        
        assert new VideoFinder().getVideoLinkById(1) == "http://vimeo.com/9028476" : "Obtain a StringCalculator Video on Vimeo."
    }
}
