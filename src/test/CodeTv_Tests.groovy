package test;

import spock.lang.*

import main.objects.VideoList
import main.objects.Video

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
}
