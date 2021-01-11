import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Generator {
	Generator(){
		File file = new File("Maps/MapOrganization.txt");
		storage stor = new storage();
		FileReader reader = null;
		int id = 0;
		int id1 = -1;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Автоматически созданный блок catch
			e.printStackTrace();
		}
		BufferedReader readFile = new BufferedReader(reader);
		String line;
		try {
			line = readFile.readLine();
			if (line!=null) {
				if (line.indexOf("MapOrganization")!= -1) {
					char[] ch0 = new char[(int) file.length()];
					readFile.read(ch0);
					String st1 = String.valueOf(ch0);
					String st = "";
					int start =st1.indexOf("{");
					int end =st1.indexOf("}");
					//System.out.println(start+" "+end);
					System.out.println(st1);
					for (int i = start+3; i<end-1; i++)
					st = st+ch0[i];
				//	st = st.replace("{", "");
				//	st = st.replace("}", "");
					st = st.replaceAll("\"", "");		
					st = st.replaceAll(" ", "");
					st = st.replaceAll("\n", "");
					st = st.replaceAll("\r", "");
					st = st.trim();
					st.indexOf(",");
					int a = 0;
					//System.out.println(st.length());
					System.out.println(st);
					while(a<st.length()) {
							for (int s = 0; s<st.length();s++) {
								if (s == st.indexOf("(")) {
									start = st.indexOf("(");
									end = st.indexOf(")");
									st1 = "";
									//System.out.println(start+" "+end);
									ch0 = st.toCharArray();
									if (start+1 == end) {
										st = st.replace("(", "");
										st = st.replace(")", "");
									} else {
										for (int i = start+1; i<end; i++) {
											st1 = st1+ch0[i];
											ch0[i] = ' ';
										}
										ch0[start] = ch0[end] = ' ';
										System.out.println(st1+"= st1");
										if (st1.indexOf(",")==-1) {
											stor.add(id1,0, st1);
										}
										else {
											String stroke1 = "";
											int k = st1.indexOf(",");
											if (0 == k) ;
											else {
												for (int m = 0; m<k;m++) {
													stroke1 = stroke1 + st1.charAt(m);
												}
												stor.add(id1,0,stroke1);
												System.out.println("type 0 "+stroke1);
												stroke1 = "";
											}
											if (st1.length()==k) ;
											else {
												for (int m = k+1; m<st1.length();m++) {
													stroke1 = stroke1 + st1.charAt(m);
												}
												stor.add(id1, 1, stroke1);
												System.out.println("type 1 "+stroke1);
												stroke1 = "";
												
											}
										}
										st = String.valueOf(ch0);
										st = st.replaceAll(" ", "");
										//st = st.replace("(", "");
										//st = st.replace(")", "");
									}
									System.out.println(st+" st");
								}
							}
							String stroke = "";
							//System.out.println("a = "+a+", d = "+d);
						if (a+1==st.indexOf(",")) {
							//System.out.println(st.charAt(a)+" num1");
							stor.add(id, (st.valueOf(st.charAt(a))));
							id++;
							a++;
							st = st.replaceFirst(",", "");
							
							
						} else {
							
							int d;
							//st = st.replaceFirst(",", "");
							//System.out.println(st);
							if (st.indexOf(",")!=-1) {
								d = st.indexOf(",");
								//System.out.println("индекс найден");
							}
							else {
								d = st.length()-1;
								//System.out.println("длина строки выбрана");
							}
							for (int s = a; s<d;s++) {
								//System.out.println(st.charAt(s)+" собирается в строку");
								stroke = stroke+ st.charAt(s);
								a++;
							}
							if (d == st.length()-1) {
								stroke = stroke +st.charAt(d);
								a++;
							}
							stor.add(id, stroke);
							//System.out.println("собрано в строку");
							id++;
							stroke = "";
							st = st.replaceFirst(",", "");
						//	if (st.indexOf(",")!=-1)
						//		a++;
						}
					}
					//ch0 = st.toCharArray();
					System.out.println(st);
					
				//	System.out.println(ch0[0]);
				}
			}
		} catch (IOException e) {
			// TODO Автоматически созданный блок catch
			e.printStackTrace();
		}
		String[] st = stor.getArray();
		String[] st1 = stor.getArrayType0();
		String[] st2 = stor.getArrayType1();
		}
	public void mapCreator(int numMap) {
		
		
	}
}
