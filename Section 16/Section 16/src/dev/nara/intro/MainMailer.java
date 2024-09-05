package dev.nara.intro;

import java.util.*;

public class MainMailer {

	public static void main(String[] args) {
		String[] names = {
			"Ann Jones",
			"Ann Jones Ph.D.",
			"Bob Jones M.D.",
			"Carol Jones",
			"Ed Green Ph.D.",
			"Ed Green M.D.",
			"Ed Black"
		};

		List<StringBuilder> pops = getNames(names);
		Map<StringBuilder, Integer> counts = new TreeMap<>();
		pops.forEach(s -> {
			counts.merge(s, 1, Integer::sum);
		});
		System.out.println(counts);

		StringBuilder annJonesPhd = new StringBuilder("Ann Jones Ph.D.");
		System.out.println("There are " + counts.get(annJonesPhd) + " records for " + annJonesPhd);

		List<StringBuilder> cleanedNames = standardizeNames(pops);
		System.out.println(cleanedNames);
		System.out.println("There are " + counts.get(annJonesPhd) + " records for " + annJonesPhd);
		System.out.println(counts);

		StringBuilder annJones = new StringBuilder("Ann Jones");
		System.out.println("There are " + counts.get(annJones) + " records for " + annJones);
		System.out.println("--------------");
		counts.forEach((k, v) -> System.out.println(k + " : " + v));

		System.out.println("--------------");
		counts.keySet().forEach(k -> System.out.println(k + " : " + counts.get(k)));
	}

	private static List<StringBuilder> getNames(String[] names) {

		List<StringBuilder> list = new ArrayList<>();
		int index = 3;

		for (String name : names) {
			for (int i = 0; i < index; i++) {
				System.out.println("i" + i);
				list.add(new StringBuilder(name));
			}
			index++;
		}
		System.out.println(list);

		return list;
	}

	private static List<StringBuilder> standardizeNames(List<StringBuilder> list) {

		List<StringBuilder> newList = new ArrayList<>();
		for (var name : list) {
			for (String suffix : new String[]{"Ph.D.", "M.D."}) {
				int startIndex = -1;
				// finds occurrence of a suffix
				if ((startIndex = name.indexOf(suffix)) > -1) {
					// startIndex is subtracted by 1 to include removing the starting space
					name.replace(startIndex - 1, startIndex + suffix.length(), "");
				}
			}
			newList.add(name);
		}
		return newList;
	}
}
