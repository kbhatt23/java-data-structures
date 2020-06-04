package selflearning.hashing.usinglinkedlist;

public class SelfHashMapTest {

	public static void main(String[] args) {
		SelfHashMap<String, String> map= new SelfHashMap<String, String>(4);
		map.insert("one", "jai shree ram");
		map.insert("two","jai sita ram");
		map.insert("three","jai radha madhav");
		map.insert("four","jai uma maheshwar");
		map.insert("five","jai hanuman");
		map.insert("six","jai shree ganesh");
		map.insert("seven","jai kanha");
		map.insert("eight","jai surya deva");
		map.insert("nine","jai pavan putra");
		
		map.printBeautifully();
	}

}
