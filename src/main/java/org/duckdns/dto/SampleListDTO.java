package org.duckdns.dto;

import java.util.List;

public class SampleListDTO {
	private List<SampleDTO> list;

	public List<SampleDTO> getList() {
		return list;
	}

	public void setList(List<SampleDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "SampleListDTO [list=" + list + "]";
	}
	
}
