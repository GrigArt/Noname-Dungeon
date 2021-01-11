import java.util.Arrays;

public class storage {
	String[] store = new String[1];
	String[] storeCopy = new String[1];
	String[] store1 = new String[1];
	String[] storeCopy1 = new String[1];
	String[] store2 = new String[1];
	String[] storeCopy2 = new String[1];
	public void add(int id, String text) {
		if (id+1 == store.length) {
			store[id] = text; 
		}
		else {
			storeCopy = store;
			store = null;
			store = new String[id+1];
			for (int i = 0; i<storeCopy.length;i++) {
				store[i] = storeCopy[i];
			}
			storeCopy = null;
			store[id] = text;
		}
	}
	
	public String get(int id) {
		return store[id];
	}
	
	public String[] getArray() {
		System.out.println(Arrays.toString(store));
		return store;
	}
	
	
	public void add(int id, int type, String text) {
		if (type == 0) {
			if (id+1 == store1.length) {
				store1[id] = text; 
			}
			else {
				storeCopy1 = store1;
				store1 = null;
				store1 = new String[id+1];
				for (int i = 0; i<storeCopy1.length;i++) {
					store1[i] = storeCopy1[i];
				}
				storeCopy1 = null;
				store1[id] = text;
			}
		}
		else {
			if (id+1 == store2.length) {
				store2[id] = text; 
			}
			else {
				storeCopy2 = store2;
				store2 = null;
				store2 = new String[id+1];
				for (int i = 0; i<storeCopy2.length;i++) {
					store2[i] = storeCopy2[i];
				}
				storeCopy2 = null;
				store2[id] = text;
			}
		}
	}
	
	public String get(int id, int type) {
		if (type == 0)
			return store1[id];
		else
			return store2[id];
	}
	
	public String[] getArrayType0() {
		System.out.println(Arrays.toString(store1));
		return store1;
	}
	
	public String[] getArrayType1() {
		System.out.println(Arrays.toString(store2));
		return store2;
	}
}
