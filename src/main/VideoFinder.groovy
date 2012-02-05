package main

class VideoFinder {

	def videoFinder() {}
	
	def getVideoLinkById(Integer id) {
		
		def link = "http://vimeo.com/9028476"
		
		if (id != 1) {
			link = "http://groovy.org.es/home/story/324"
		}
		
		return link 
	}
}
