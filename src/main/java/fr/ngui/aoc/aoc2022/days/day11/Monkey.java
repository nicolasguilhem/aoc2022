package fr.ngui.aoc.aoc2022.days.day11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.LongUnaryOperator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Monkey {
	protected static final Logger log = LoggerFactory.getLogger(Monkey.class);

	private final List<Long> items = new ArrayList<>();
	private Operation operation;
	private long inspectedItems = 0;
	private Test test;

	public List<Long> getItems() {
		return items;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = new Operation(operation);
	}

	public Long getInspectedItems() {
		return inspectedItems;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public void addItem(Long item) {
		this.items.add(item);
	}

	public static Comparator<Monkey> compareByInspectedItems = (m1, m2) -> m2.getInspectedItems()
			.compareTo(m1.getInspectedItems());

	public void inspectItems(List<Monkey> lstMonkey, LongUnaryOperator afterInspection) {
		for (int iItem = 0; iItem < this.getItems().size(); iItem++) {
			inspectedItems++;

			final Long newValue = this.operation.doOperation(this.getItems().get(iItem), afterInspection);
			lstMonkey.get(this.test.getMonkeyToThrow(newValue)).addItem(newValue);
		}

		this.getItems().clear();
	}
}
