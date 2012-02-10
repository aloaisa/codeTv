package test;

import static org.junit.Assert.*;
import org.junit.Before;

import groovy.util.GroovyTestCase

import main.objects.Video
import main.objects.VideoList

class CodeTv_Tests  extends GroovyTestCase {

	VideoList videoList
	
	@Before
	public void setUp() throws Exception {
	
		videoList = VideoList.getInstance()
		
		Video video1 = new Video()
		video1.setId(1)
		video1.setDescription("StringCalculator Groovy")
		video1.setLink("http://vimeo.com/9028476")
		
		Video video2 = new Video()
		video2.setId(2)
		video2.setDescription("Seminario de introducción a Groovy")
		video2.setLink("http://groovy.org.es/home/story/324")
		
		Video video3 = new Video()
		video3.setId(3)
		video3.setDescription("Groovy y la productividad para desarrolladores Java")
		video3.setLink("http://vimeo.com/11931804")
		
		videoList.addVideo(video1)
		videoList.addVideo(video2)
		videoList.addVideo(video3)
	}
		
    void testReturnAVideoById_1() {
        assert videoList.findVideoById(1).link == "http://vimeo.com/9028476" : "Error to Obtain a " +
				"StringCalculator Video on Vimeo."
    }
	
	void testReturnAVideoById_2() {
		assert videoList.findVideoById(2).link == "http://groovy.org.es/home/story/324" : "Error to " +
				"Obtain a \"Seminario de introducción a Groovy\" Video."
	}
		
	void testReturnAVideoById_3() {
		assert videoList.findVideoById(3).link == "http://vimeo.com/11931804" : "Error to Obtain a " +
				"\"Groovy y la productividad para desarrolladores Java\" Video."
	}
	
	void testReturnAEmptyLinkById_0() {
		assert videoList.findVideoById(0) == null : "Error to Obtain a " +
				"Video with id 0."
	}
	
	void testReturnAEmptyLinkByNegativeId() {
		assert videoList.findVideoById(-1) == null : "Error to Obtain a " +
				"Video with id Negative."
	}
	
	void testReturnAEmptyLinkWhenTryToGetAIdThatNotExists() {
		assert videoList.findVideoById(78686) == null : "Error to Obtain a " +
				"Video with a id that not exist."
	}
}
