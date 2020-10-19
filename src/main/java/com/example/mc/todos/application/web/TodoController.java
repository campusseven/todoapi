package com.example.mc.todos.application.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mc.todos.application.web.dto.TodoDto;
import com.example.mc.todos.domain.Todo;
import com.example.mc.todos.domain.service.TodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags= {"1.일정관리"})
@RestController
@RequestMapping("/api/todos/")
public class TodoController {

	@Autowired
	private TodoService service;
	
	@ApiOperation(value="일정등록")
	@PostMapping()
	public void todoCreate(@ApiParam(value="date format:yyyy-MM-dd hh:mm", required=true)
	                       @RequestBody TodoDto todo) {
		service.todoCreate(todo.toEntity());
	}
	@ApiOperation(value="일정 정보")
	@GetMapping("{todoNum}")
	public TodoDto todoDetail(@ApiParam(value="목록보기로 조회한 번호", required=true)
	                          @PathVariable long todoNum) {
		return service.todoDetail(todoNum).toDto();
	}
	@ApiOperation(value="일정 목록")
	@GetMapping()
	public List<TodoDto> todoList(){
		return Todo.toDtoList(service.todoList());
	}
	@ApiOperation(value="일정 수정")
	@PutMapping()
	public void todoModify(@ApiParam(value="일정 등록 테스트 값 복사 수정", required=true)
	                       @RequestBody TodoDto todo) {
		service.todoModify(todo.toEntity());
	}
	@ApiOperation(value="일정 삭제")
	@DeleteMapping("{todoNum}")
	public void todoDelete(@ApiParam(value="목록보기로 조회한 번호", required=true) 
	                       @PathVariable int todoNum) {
		service.todoDelete(todoNum);
	}

}







