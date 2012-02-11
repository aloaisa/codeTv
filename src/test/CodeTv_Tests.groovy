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
	
	
	/**
	 * Start Tests
	 */
	
    void testReturnAVideoById_1() {
		
		Video video = new Video()
		video.setId(1)
		video.setDescription("StringCalculator Groovy")
		video.setLink("http://vimeo.com/9028476")
		
        Video result = videoList.findVideoById(1)
		
		assert result.id == video.id
		assert result.link == video.link
		assert result.description == video.description
    }
	
	void testReturnAVideoById_2() {
		
		Video video = new Video()
		video.setId(2)
		video.setDescription("Seminario de introducción a Groovy")
		video.setLink("http://groovy.org.es/home/story/324")
		
		Video result = videoList.findVideoById(2)
		
		assert result.id == video.id
		assert result.link == video.link
		assert result.description == video.description
		
	}
		
	void testReturnAVideoById_3() {
		
		Video video = new Video()
		video.setId(3)
		video.setDescription("Groovy y la productividad para desarrolladores Java")
		video.setLink("http://vimeo.com/11931804")
		
		Video result = videoList.findVideoById(3)
		
		assert result.id == video.id
		assert result.link == video.link
		assert result.description == video.description
	}
	
	void testReturnAEmptyLinkById_0() {
		assert videoList.findVideoById(0) == null
	}
	
	void testReturnAEmptyLinkByNegativeId() {
		assert videoList.findVideoById(-1) == null
	}
	
	void testReturnAEmptyLinkWhenTryToGetAIdThatNotExists() {
		assert videoList.findVideoById(78686) == null
	}
	
	void testShouldFailIfAddAExistId() {
		
		Video video = new Video()
		video.setId(1)
		video.setDescription("Test testShouldFailIfAddAExistId")
		video.setLink("http://testShouldFailIfAddAExistId")
		
		shouldFail videoList.addVideo(video)
	}
}
