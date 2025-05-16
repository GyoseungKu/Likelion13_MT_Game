package org.syu_likelion_game.MT_Game.model;

import java.util.*;

public class GameData {
    private static final Map<String, List<String>> DATA = new HashMap<>();

    static {
        DATA.put("음식", List.of(
                "김밥", "떡볶이", "삼겹살", "치킨", "라면",
                "바나나", "아이스크림", "수박", "붕어빵", "피자",
                "순대", "팥빙수", "우유", "햄버거", "감자튀김"
        ));
        DATA.put("운동", List.of(
                "축구", "농구", "배드민턴", "수영", "자전거 타기",
                "스키", "탁구", "골프", "요가", "마라톤",
                "줄넘기", "스케이트", "씨름", "등산", "복싱"
        ));
        DATA.put("영화", List.of(
                "겨울왕국", "해리포터", "스파이더맨", "어벤져스", "라푼젤",
                "마리오", "쿵푸팬더", "알라딘", "라라랜드", "라이온킹",
                "업", "인어공주", "타이타닉", "서울의 봄", "오징어 게임"
        ));
        DATA.put("속담", List.of(
                "소 잃고 외양간 고친다", "호랑이도 제 말 하면 온다", "티끌 모아 태산",
                "하늘의 별 따기", "닭 잡아먹고 오리발 내민다", "등잔 밑이 어둡다",
                "바늘 도둑이 소 도둑 된다", "구슬이 서 말이라도 꿰어야 보배다", "백문이 불여일견",
                "갈수록 태산", "원숭이도 나무에서 떨어진다", "눈에 넣어도 아프지 않다",
                "개구리 올챙이 적 생각 못 한다", "말 한마디에 천 냥 빚도 갚는다", "가는 말이 고와야 오는 말이 곱다"
        ));
        DATA.put("동물", List.of(
                "강아지", "고양이", "토끼", "닭", "돼지",
                "소", "원숭이", "코끼리", "펭귄", "오리",
                "사자", "호랑이", "고래", "거북이", "기린"
        ));
    }

    public static List<String> getCategories() {
        return new ArrayList<>(DATA.keySet());
    }

    public static String getRandomWord(String category) {
        List<String> words = DATA.getOrDefault(category, List.of("선택 오류"));
        return words.get(new Random().nextInt(words.size()));
    }
}
