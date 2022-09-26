package board;

public class BoardDTO {
	private int BoardId;
	private String UserId;
	private String Title;
	private String Text;
	
	public BoardDTO() {}

	public int getBoardId() {
		return BoardId;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	@Override
	public String toString() {
		return "BoardDTO [BoardId=" + BoardId + ", UserId=" + UserId + ", Title=" + Title + ", Text=" + Text + "]";
	}

	public BoardDTO(int boardId, String userId, String title, String text) {
		super();
		BoardId = boardId;
		UserId = userId;
		Title = title;
		Text = text;
	}
	
	
}
