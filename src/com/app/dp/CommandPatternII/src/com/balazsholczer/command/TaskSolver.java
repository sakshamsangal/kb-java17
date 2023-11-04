package com.app.dp.CommandPatternII.src.com.balazsholczer.command;

public class TaskSolver implements Command {

	private Task task;
	
	public TaskSolver(Task task){
		this.task = task;
	}
	
	@Override
	public void execute() {
		this.task.solveProblem();
	}
}
