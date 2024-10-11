package com.ssafy.minsseam.model.dao;

import java.util.List;

import com.ssafy.minsseam.model.dto.Minkyu;

//[이 MinkyuDao 인터페이스 파일은 수정금지] 오류없음
public interface MinkyuDao {
	/** 등록 */
	public void InsertMinkyu(Minkyu minkyu);

	/** 전체 목록 조회 */
	public List<Minkyu> selectAll();

	/** 개별 정보 조회 */
	public Minkyu selectOne(int id);

	/** 수정 */
	public void updateMinkyu(Minkyu minkyu);

	/** 삭제 */
	public void deleteMinkyu(int id);
}
