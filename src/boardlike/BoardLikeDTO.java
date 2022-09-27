package boardlike;

import java.sql.Timestamp;

public class BoardLikeDTO {
	private int boardLikeId;
	private int boardId;
	private String userId;
	private Timestamp clickDate;
	private Integer likeFlag = 0;
	
	public int getBoardLikeId() {
		return boardLikeId;
	}
	public void setBoardLikeId(int boardLikeId) {
		this.boardLikeId = boardLikeId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getClickDate() {
		return clickDate;
	}
	public void setClickDate(Timestamp clickDate) {
		this.clickDate = clickDate;
	}
	public Integer getLikeFlag() {
		return likeFlag;
	}
	public void setLikeFlag(Integer likeFlag) {
		this.likeFlag = likeFlag;
	}
	@Override
	public String toString() {
		return "BoardLikeDTO [boardLikeId=" + boardLikeId + ", boardId=" + boardId + ", userId=" + userId
				+ ", clickDate=" + clickDate + ", likeFlag=" + likeFlag + "]";
	}
	public BoardLikeDTO(int boardLikeId, int boardId, String userId, Timestamp clickDate, Integer likeFlag) {
		super();
		this.boardLikeId = boardLikeId;
		this.boardId = boardId;
		this.userId = userId;
		this.clickDate = clickDate;
		this.likeFlag = likeFlag;
	}

	
}
