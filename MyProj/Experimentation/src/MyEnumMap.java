import java.util.EnumMap;



enum TEST {
	A,
	B;
}

class Y2 {
	EnumMap<TEST, Integer> TESTENUM = new EnumMap<TEST, Integer>(TEST.class);
}