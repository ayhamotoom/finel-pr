package com.myproect.games.entities;

import java.util.HashMap;
import java.util.Map;

public class ListOfValueMapper {
	private static final Map<Integer, String> studios = new HashMap<>();
	private static final Map<Integer, String> categories = new HashMap<>();

	static {
		studios.put(1, "Naughty Dog");
		studios.put(2, "Rockstar Games");
		studios.put(3, "Ubisoft");
		studios.put(4, "Bethesda Game Studios");
		studios.put(5, "CD Projekt Red");
		studios.put(6, "FromSoftware");
		studios.put(7, "Blizzard Entertainment");
		studios.put(8, "Nintendo");
		studios.put(9, "Square Enix");
		studios.put(10, "Epic Games");
		// add categories
		categories.put(1, "Action");
		categories.put(2, "Role-Playing (RPG)");
		categories.put(3, "Adventure");
		categories.put(4, "Simulation");
		categories.put(5, "Strategy");
		categories.put(6, "Sports");
		categories.put(7, "Racing");
		categories.put(8, "Shooter");
		categories.put(9, "Puzzle");
		categories.put(10, "Survival Horror");
	}

	public static String getStudioName(Integer studioId) {
		return studios.getOrDefault(studioId, "Unknown Studio");
	}

	public static String getCategoryName(Integer studioId) {
		return categories.getOrDefault(studioId, "Unknown Category");
	}
}
