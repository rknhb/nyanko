package com.example.entity;

import java.util.Map;
import java.util.HashMap;

public class Rarity {
	
	public static Map<String, String> list = new HashMap<>() {
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