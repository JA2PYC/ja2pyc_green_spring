package org.duckdns.mapper;

import org.duckdns.dto.MemberDTO;

public interface MemberMapper {
	
	public String getMember();
	public MemberDTO loginMember(MemberDTO mdto);
}
