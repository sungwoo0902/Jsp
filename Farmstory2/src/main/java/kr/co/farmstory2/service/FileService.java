package kr.co.farmstory2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dao.FileDAO;
import kr.co.farmstory2.dto.FileDTO;

public enum FileService {

	INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private FileDAO dao = new FileDAO();

	public void insertFile(FileDTO fileDto) {
		dao.insertFile(fileDto);	
	}
	
	public FileDTO selectFile(String fno) {
		return dao.selectFile(fno);
	}

	public List<FileDTO> selectFiles(){
		return dao.selectFiles();
		
	}
	
	public void updateFile(FileDTO dto) {
		dao.updateFile(dto);
	}

	public List<String> deleteFile(String ano) {
		return dao.deleteFile(ano);
	}
}
