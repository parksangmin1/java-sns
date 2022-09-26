package friendslist;

public class FriendsDTO {
	private String userid;
	private String friendid;
	
	public FriendsDTO(String userid, String friendid) {
		super();
		this.userid = userid;
		this.friendid = friendid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFriendid() {
		return friendid;
	}

	public void setFriendid(String friendid) {
		this.friendid = friendid;
	}

	@Override
	public String toString() {
		return "FriendsDTO [userid=" + userid + ", friendid=" + friendid + "]";
	}
	
}
