package hello.jdbc;

import static hello.jdbc.Main.*;

import hello.jdbc.domain.Item;
import java.util.List;
import org.springframework.util.StringUtils;

public class ProductSearch {

	public Status itemSearch() {
		System.out.println("상품 검색을 시작합니다.");
		command = scanner.next();
		if (command.equals(TERMINATE_COMMAND)) {
			if (isSureExit()) {
				return Status.MENU;
			}
		}

		if (!StringUtils.hasText(command)) {
			System.out.println("상품명을 입력해주세요.");
			return Status.SEARCH;
		}
		Item item = itemService.searchItem(command);

		if (item == null) {
			System.out.println("상품이 존재하지 않습니다.");
			return Status.SEARCH;
		} else {
			System.out.println(item.toString());
			return Status.MENU;
		}
	}

	public Status itemAllSearch() {
		System.out.println("상품 검색을 시작합니다.");
		command = scanner.next();
		if (command.equals(TERMINATE_COMMAND)) {
			if (isSureExit()) {
				return Status.MENU;
			}
		}

		if (!StringUtils.hasText(command)) {
			System.out.println("상품명을 입력해주세요.");
			return Status.SEARCH;
		}
		List<Item> items = itemService.searchAllItem(command);

		if (items == null) {
			System.out.println("상품이 존재하지 않습니다.");
			return Status.SEARCH;
		} else {
			for (Item item : items) {
				System.out.println(item.toString());
				System.out.println("============================");
			}
			return Status.MENU;
		}
	}
}
