package test;

import spock.lang.*

import main.objects.VideoList
import main.objects.Video

class SpockTests extends Specification {
	
	def "Return a video example with id == 1"() {
		
		given:
		VideoList videoList = VideoList.getInstance()
		
		when:
		Video video = videoList.findVideoById(1)
		
		then:
		video.id == 1
		video.link == "http://vimeo.com/9028476" 
		video.description == "StringCalculator Groovy"
	}
	
	def "Return a video example with id == 2"() {
		
		given:
		VideoList videoList = VideoList.getInstance()
		
		when:
		Video video = videoList.findVideoById(2)
		
		then:
		video.id == 2
		video.link == "http://groovy.org.es/home/story/324"
		video.description == "Seminario de introducción a Groovy"
		
	}
}
