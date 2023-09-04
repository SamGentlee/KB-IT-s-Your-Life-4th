package mulcam.kb04.bootmvc0901.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import mulcam.kb04.bootmvc0901.entity.BoardDto;

@Mapper
public interface BoardMapper {
	
	@Select("SELECT * FROM BOARD ORDER BY no DESC")
	List<BoardDto> findAll();
	
}
