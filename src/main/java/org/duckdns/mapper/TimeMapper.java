package org.duckdns.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("SELECT sysdate()")
	public String getTime();
	
	@Select ("SELECT * FROM board LIMIT 1")
	public String getBoard();
	
	public String getTimeXML();
}
