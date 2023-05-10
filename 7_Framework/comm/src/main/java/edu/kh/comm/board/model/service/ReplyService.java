package edu.kh.comm.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.comm.board.model.vo.Reply;

public interface ReplyService {

	/** 댓글 목록 조회 서비스
	 * @param boardNo
	 * @return rList
	 */
	List<Reply> selectReplyList(int boardNo);

	/** 댓글 등록 서비스
	 * @param reply
	 * @return result
	 */
	int addReply(Reply reply);

	/**
	 * @param replyNo
	 * @return result
	 */
	int deleteReply(int replyNo);

	/**
	 * @param reply
	 * @return result
	 */
	int updateReply(Reply reply);

}
