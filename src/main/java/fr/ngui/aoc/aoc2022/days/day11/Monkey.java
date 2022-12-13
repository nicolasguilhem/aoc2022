package fr.ngui.aoc.aoc2022.days.day11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import fr.ngui.aoc.aoc2022.model.PartOfDay;

public class Monkey {

	private final List<BigInteger> items = new ArrayList<>();
	private Operation operation;
	private int inspectedItems = 0;
	private Test test;

	public List<BigInteger> getItems() {
		return items;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = new Operation(operation);
	}

	public int getInspectedItems() {
		return inspectedItems;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public void addItem(BigInteger item) {
		this.items.add(item);
	}

	public void inspectItems(List<Monkey> lstMonkey, PartOfDay partOfDay) {
		for (int iItem = 0; iItem < this.getItems().size(); iItem++) {
			inspectedItems++;

			final BigInteger newValue = this.operation.doOperation(this.getItems().get(iItem))
					.divide(BigInteger.valueOf(PartOfDay.ONE.equals(partOfDay) ? 3L : 1L));

			lstMonkey.get(this.test.getMonkeyToThrow(newValue)).getItems().add(newValue);
		}

		this.getItems().clear();
	}

	public String getListItemsAsString() {
		return items.stream().map(intValue -> intValue.toString()).collect(Collectors.joining(", "));
	}

	public static Comparator<Monkey> compareByInspectedItems = (m1, m2) -> {
		return m2.getInspectedItems() - m1.getInspectedItems();
	};

	@Override
	public String toString() {
		return String.format("Items : %s\n%s\n%s", getListItemsAsString(), operation.toString(), test.toString());
	}
}
