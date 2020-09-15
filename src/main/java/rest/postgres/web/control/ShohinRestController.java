package rest.postgres.web.control;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import rest.postgres.web.models.ShohinEntity;
import rest.postgres.web.models.ShohinEntityRepository;

@RestController
public class ShohinRestController {
	@Autowired
	ShohinEntityRepository repository;
	
	@RequestMapping(value = "/rest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ShohinEntity> index(Model model) {
		model.addAttribute("title", "商品一覧表");
		List<ShohinEntity> data = repository.findAll(Sort.by(Direction.ASC, "_NumId"));
		model.addAttribute("data", data);
		return data;
	}
	
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
    public ShohinEntity insert(@RequestBody @Validated ShohinEntity shohin) {
		String daytime = getDaytime();
		shohin.setEditDate(BigDecimal.valueOf(Integer.valueOf(daytime.substring(0,8))));
		shohin.setEditTime(BigDecimal.valueOf(Integer.valueOf(daytime.substring(8))));
		return repository.save(shohin);
    }
	
	@PutMapping("/rest/{numid}")
	@ResponseBody
	public ShohinEntity update(@PathVariable("numid")Integer numid, @RequestBody @Validated ShohinEntity shohin) {
		shohin.setNumId(numid);
		String daytime = getDaytime();
		shohin.setEditDate(BigDecimal.valueOf(Integer.valueOf(daytime.substring(0,8))));
		shohin.setEditTime(BigDecimal.valueOf(Integer.valueOf(daytime.substring(8))));
		return repository.save(shohin);
	}
	
	@DeleteMapping("/rest/{numid}")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer numid) {
		repository.deleteById(numid);
	}
	
	private String getDaytime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String daytime = formatter.format(java.time.LocalDateTime.now());
		return daytime;
	}
}