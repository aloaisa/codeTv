package main

class VideoFinder {

	def linksMap = [1 : "http://vimeo.com/9028476",
					2 : "http://groovy.org.es/home/story/324",
					3 : "http://vimeo.com/11931804"]
	
	def videoFinder() {}
	
	def getVideoLinkById(Integer id) {

		if (id > 0) { 
			linksMap[id]
		} else {
			""
		} 
	}
}
