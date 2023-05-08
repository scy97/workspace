package edu.kh.comm.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.comm.board.model.vo.Reply;

public interface ReplyService {

	List<Reply> selectReplyList(int boardNo);

	int addReply(Map<String, Object> paramMap);

}
