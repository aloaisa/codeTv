package main.objects

import main.objects.exceptions.VideoNotFinderException;

import org.codehaus.groovy.ast.stmt.ThrowStatement;

class VideoList {
	
	private static VideoList INSTANCE = null
	private List<Video> listOfVideos
	
	public static VideoList getInstance() {
		INSTANCE ?: new VideoList()
	}
	
	protected VideoList() {
	
		listOfVideos = []
		
		// Initialize Videos
		Video video1 = new Video()
		video1.id = 1
		video1.description = 'StringCalculator Groovy'
		video1.link = 'http://vimeo.com/9028476'
			
		Video video2 = new Video()
		video2.id = 2
		video2.description = 'Seminario de introducción a Groovy'
		video2.link = 'http://groovy.org.es/home/story/324'
			
		Video video3 = new Video()
		video3.id = 3
		video3.description = 'Groovy y la productividad para desarrolladores Java'
		video3.link = 'http://vimeo.com/11931804'
			
		addVideo(video1)
		addVideo(video2)
		addVideo(video3)
	}
	
	
	def addVideo(Video video) {
		
		Video findIt = findVideoById(video.getId())

		if (findIt == null) {
			listOfVideos << video
		} else {
			 throw new VideoNotFinderException("This Id Exists.") 
		}
	}
	
	def Video findVideoById(Integer id) {
		Video result = null
		
		listOfVideos.each { item ->
			if (item.id == id) {
				result = item
			}
		}
		
		return result
	}
	
	def findVideoListByDescriptionLike(String textToFind) {
		List<Video> resultVideoList = new ArrayList<Video>()
		
		listOfVideos.each { item ->
			if (item.description.toLowerCase().contains(textToFind.toLowerCase())) {
				resultVideoList.add(item)
			}
		}		
		
		return resultVideoList
	}
}
