package june15th;

public class User {
	private int numPointsGiven;
	private int numPointsReceived;
	private boolean canPost;
	protected boolean isBanned;
	private String username;

	public User(String name) {
		this.username = name;
		this.numPointsGiven = 0;
		this.numPointsReceived = 0;
		this.canPost = false;
		this.isBanned = false;
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

	public void setNumPointsReceived(int points) {
		this.numPointsReceived += points;
	}

	public void awardPoints(User u) {
		u.incrementPoints();
		numPointsGiven++;
	}

	public void addComment(String text) {
		if (!isBanned) {
			System.out.println(username + ": " + text);
			incrementPoints();
		}
	}

	public void addPost(String text) {
		if (canPost && !isBanned) {
			System.out.println(username + ": " + text);
		}
		for (int i = 0; i < 5; i++)
			incrementPoints();
	}

	public String toString() {
		return username + " (pg: " + numPointsGiven + "; pr: " + numPointsReceived + ")" + (isBanned ? "BANNED" : "");
	}
}