package com.example.entity;

import java.util.Map;
import java.util.LinkedHashMap;

public class Rarities {
	
	public static Map<String, String> list = new LinkedHashMap<>() {
		{
			put("legend", "伝説レア");
			put("ultra", "超激レア");
			put("super", "激レア");
			put("rare", "レア");
			put("ex", "EX");
			put("normal", "基本キャラ");
		}
	};	
}