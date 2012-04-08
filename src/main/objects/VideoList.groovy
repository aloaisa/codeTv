package main.objects

import org.codehaus.groovy.ast.stmt.ThrowStatement;

class VideoList {
	
	private static VideoList INSTANCE = null
	private List<Video> listOfVideos
	
	public static VideoList getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoList()
		}
		return INSTANCE
	 }

	protected VideoList() {
	
		listOfVideos = new ArrayList<Video>()
		
		// Initialize Videos
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
			
		addVideo(video1)
		addVideo(video2)
		addVideo(video3)
	}
	
	
	def addVideo(Video video) {
		
		Video findIt = findVideoById(video.getId())
		
		if (findIt == null) {
			listOfVideos.add(video)
		} else {
			 throw new Exception("This Id Exists.") 
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
			if (item.description.contains(textToFind)) {
				resultVideoList.add(item)
			}
		}		
		
		return resultVideoList
	}
}
