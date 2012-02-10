package main.objects

class VideoList {

	 private static List<Video> videoList = null
	 private static VideoList INSTANCE = null
	 
	 private videoList() {}
	 
	 def static VideoList getInstance() {
		 
		 if (INSTANCE == null) {
			 INSTANCE = new VideoList()
			 initialize()
		 }
		 
		 return INSTANCE
	 }

	private static initialize() {
		videoList = new ArrayList<Video>()
	}
	
	def static addVideo(Video video) {
		videoList.add(video)
	}
	
	def static Video findVideoById(Integer id) {
		Video result = null
		
		videoList.each { item ->
			if (item.id.equals(id)) {
				result = item
			}
		}
		
		return result
	}
		
	def static getVideoLinkByDescriptionContains() {
		return
	}
}
