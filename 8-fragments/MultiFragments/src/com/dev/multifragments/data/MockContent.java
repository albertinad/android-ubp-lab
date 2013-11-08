package com.dev.multifragments.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockContent {

	public static List<Book> ITEMS = new ArrayList<Book>();

	public static Map<String, Book> ITEM_MAP = new HashMap<String, Book>();

	static {
		addItem(new Book(
				"1",
				"Expert Android",
				"Expert Android gives you advanced techniques for customizing views, controls and layouts, and to master OpenGL."));
		addItem(new Book(
				"2",
				"Decompiling Android",
				"Decompiling Android looks at the reason why Android apps can be decompiled to recover their source code."));
		addItem(new Book(
				"3",
				"Embedded Android",
				"Embedded Android is for Developers wanting to create embedded systems based on Android and to port it to new hardware"));
	}

	private static void addItem(Book item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	public static class Book {
		public String id;
		public String title;
		public String summary;

		public Book(String id, String content, String summary) {
			this.id = id;
			this.title = content;
			this.summary = summary;
		}

		@Override
		public String toString() {
			return title;
		}
	}
}
