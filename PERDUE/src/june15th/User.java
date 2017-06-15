package june15th;

public class User {
	private int numPointsGiven;
	private int numPointsReceived;
	private boolean canPost;
	private String username;

	public User(String name) {
		this.username = name;
		this.numPointsGiven = 0;
		this.numPointsReceived = 0;
		this.canPost = false;
	}

	public int getNumPointsGiven() {
		return numPointsGiven;
	}

	public int getNumPointsReceived() {
		return numPointsReceived;
	}

	public void incrementPoints() {
		numPointsReceived++;
		if (numPointsReceived > 100)
			canPost = true;
	}

	public void awardPoints(User u) {
		u.incrementPoints();
		numPointsGiven++;
	}

	public void addComment(String text) {
		System.out.println(text);
		incrementPoints();
	}

	public void addPost(String text) {
		if (canPost)
			System.out.println(username + " " + text);
	}
}
