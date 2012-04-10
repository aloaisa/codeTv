package test;

import spock.lang.*

import main.objects.VideoList
import main.objects.Video
import main.objects.exceptions.VideoNotFinderException

class SpockTests extends Specification {

	VideoList videoList = VideoList.getInstance()
		
	def "Return a video example with id == 1"() {
		
		when:
		Video video = videoList.findVideoById(1)
		
		then:
		video.id == 1
		video.link == "http://vimeo.com/9028476" 
		video.description == "StringCalculator Groovy"
	}
	
	def "Return a video example with id == 2"() {
		
		when:
		Video video = videoList.findVideoById(2)
		
		then:
		video.id == 2
		video.link == "http://groovy.org.es/home/story/324"
		video.description == "Seminario de introducción a Groovy"
		
	}
	
	def "Return a video example with id == 3"() {
		
		when:
		Video video = videoList.findVideoById(3)
		
		then:
		video.id == 3
		video.link == "http://vimeo.com/11931804"
		video.description == "Groovy y la productividad para desarrolladores Java"
		
	}
	
	def "Return null if id doesn't exists"() {
		
		when:
		Video video = videoList.findVideoById(573464)
		
		then:
		video == null
		
	}
	
	def "Return null with negative id"() {
		
		when:
		Video video = videoList.findVideoById(-1)
		
		then:
		video == null
		
	}
	
	def "Return a video example with description like == \"StringCalculator\""() {
		
		when:
		List<Video> videoList = videoList.findVideoListByDescriptionLike("StringCalculator Groovy")
		
		then:
		videoList[0].id == 1
		videoList[0].link == "http://vimeo.com/9028476"
		videoList[0].description == "StringCalculator Groovy"
	}
	
	def "Return a video list with description like \"Groovy\""() {
		
		when:
		List<Video> videoList = videoList.findVideoListByDescriptionLike("Groovy")
		
		then:
		videoList.size() == 3
		
		videoList[0].id == 1
		videoList[0].link == "http://vimeo.com/9028476"
		videoList[0].description == "StringCalculator Groovy"
		
		videoList[1].id == 2
		videoList[1].link == "http://groovy.org.es/home/story/324"
		videoList[1].description == "Seminario de introducción a Groovy"
		
		videoList[2].id == 3
		videoList[2].link == "http://vimeo.com/11931804"
		videoList[2].description == "Groovy y la productividad para desarrolladores Java"
	}
	
	def "Return a video list with description like \"groovy\" independient of Lowercase or UpperCase"() {
		
		when:
		List<Video> videoList = videoList.findVideoListByDescriptionLike("groovy")
		
		then:
		videoList.size() == 3
		
		videoList[0].id == 1
		videoList[0].link == "http://vimeo.com/9028476"
		videoList[0].description == "StringCalculator Groovy"
		
		videoList[1].id == 2
		videoList[1].link == "http://groovy.org.es/home/story/324"
		videoList[1].description == "Seminario de introducción a Groovy"
		
		videoList[2].id == 3
		videoList[2].link == "http://vimeo.com/11931804"
		videoList[2].description == "Groovy y la productividad para desarrolladores Java"
	}
	
	def "Return exception if add a video that exist id"() {
		given: 
		Video video = new Video()
		video.id = 1
		video.description = 'Test Exception'
		video.link = 'http://test.com'
 
		when:
		videoList.addVideo(video)
		
		then:
		def exception = thrown(VideoNotFinderException)
	}
}
